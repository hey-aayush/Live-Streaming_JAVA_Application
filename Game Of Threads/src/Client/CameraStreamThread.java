package Client;

import ControllerFiles.ChannelSectionController;
import ControllerFiles.StreammerSectionController;
import Streamer.Decoder;
import Streamer.Encoder;
import Streamer.StreamingAddress;
import Streamer.VideoPacket;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import User.User;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;


public class CameraStreamThread implements Runnable{

    static BufferedImage grabbedImage;
    static Webcam webcam;
    static boolean terminate =false;
    static User user;
    private StreamingAddress streamingAddress;
    private DatagramSocket sendingSocket;
    private MulticastSocket receivingSocket;
    private int imageNumber;
    private Encoder encoder;
    private Decoder decoder;
    private InetAddress ip;
    private int port;
    private Image image;


    public CameraStreamThread(Webcam webcam, User user, StreamingAddress streamingAddress) throws IOException {
        this.webcam = webcam;
        this.webcam.open();
        this.terminate =false;
        this.user=user;
        this.streamingAddress = streamingAddress;
        imageNumber = 0;
        encoder = new Encoder(WebcamResolution.VGA.getSize());
        decoder = new Decoder(WebcamResolution.VGA.getSize());
        ip = InetAddress.getByName(streamingAddress.getAddress());
        port = streamingAddress.getPort();
        sendingSocket = new DatagramSocket();
        receivingSocket = new MulticastSocket(port);
        receivingSocket.joinGroup(new InetSocketAddress(streamingAddress.getAddress(), port), null);
        image = null;
    }

    public void terminateStream(){
        this.terminate=true;
    }

    public void run(){

        System.out.println("Reached CameraStreamThread!");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    previewVideo();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        while((grabbedImage = webcam.getImage())!=null  & !terminate){


            try {
                sendVideoPackets(grabbedImage);
            } catch (Exception e) {
                e.printStackTrace();
            }
            grabbedImage.flush();



            //            final Image mainimage = SwingFXUtils.toFXImage(grabbedImage, null);
//            StreammerSectionController.imageProperty.set(mainimage);
        }
        webcam.close();
        StreammerSectionController.imageProperty.set(null);
        System.out.println("Stream Ended");
    }

    private void sendVideoPackets(BufferedImage bufferedImage) throws Exception {
        imageNumber++;

        //BufferedImage bufferedImage = webcam.getImage();

        VideoPacket videoPacket = encoder.encode(bufferedImage, imageNumber, System.currentTimeMillis());
        byte[] sendData = null;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        ObjectOutputStream out;
        try {

            out = new ObjectOutputStream(bos);
            out.writeObject(videoPacket);
            out.flush();
            sendData = bos.toByteArray();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {

            try {
                bos.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(sendData!=null) {

            DatagramPacket senddp = new DatagramPacket(sendData, sendData.length, ip, port);

            System.out.println("send data length: " + sendData.length);

            sendingSocket.send(senddp);
            System.out.println("Video packet sent!!!!!!!");
        }
        else {
            System.out.println("Can't Video Packet Sent!!");
        }

    }

    private void previewVideo() throws Exception {

        //Image mainimage = SwingFXUtils.toFXImage(grabbedImage, null);

        while(!terminate){
            //System.out.println("loop start");

            byte[] buf = new byte[8000];
            DatagramPacket dp = new DatagramPacket(buf, 8000);
            receivingSocket.receive(dp);

            System.out.println("received an object!");

            buf = dp.getData();

            System.out.println("Length of received packet: " + dp.getData().length);

            Object o = null;

            ByteArrayInputStream bis = new ByteArrayInputStream(buf);
            ObjectInput in = null;
            try {
                in = new ObjectInputStream(bis);
                o = in.readObject();

            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(o!=null)
            {
                if(o instanceof VideoPacket)
                {
                    System.out.println("Video Packet received!!");
                    System.out.println(((VideoPacket) o).getSeqNumber());
                }
                else
                {
                    System.out.println("Something corrupted!");
                    continue;
                }
            }
            else
            {
                System.out.println("Video Null value!");
                continue;
            }

            VideoPacket encodedImage = ((VideoPacket)o);

            BufferedImage bufferedImage = decoder.decode(encodedImage);

            if(bufferedImage!=null) {

                image = SwingFXUtils.toFXImage(grabbedImage, null);
            }


            if(image!=null)
                StreammerSectionController.imageProperty.set(image);
        }
    }
}
