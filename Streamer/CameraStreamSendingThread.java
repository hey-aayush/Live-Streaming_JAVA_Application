package Streamer;

import ControllerFiles.StreammerSectionController;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import User.Streamer;

/**
 * Thread for sending camera stream
 */

public class CameraStreamSendingThread implements Runnable{

    private BufferedImage grabbedImage;
    private Webcam webcam;
    private boolean terminate =false;
    private Streamer streamer;
    private StreamingAddress streamingAddress;
    private DatagramSocket sendingSocket;
    private int imageNumber;
    private Encoder encoder;
    private InetAddress ip;
    private int port;
    private Image image;
    private MulticastSocket receivingSocket;
    private Decoder decoder;


    public CameraStreamSendingThread(Webcam webcam, Streamer streamer, StreamingAddress streamingAddress) throws IOException {
        this.webcam = webcam;
        this.webcam.open();
        this.terminate =false;
        this.streamer = streamer;
        this.streamingAddress = streamingAddress;
        imageNumber = 0;
        encoder = new Encoder(WebcamResolution.VGA.getSize());
        sendingSocket = new DatagramSocket();
        ip = InetAddress.getByName(streamingAddress.getAddress());
        port = streamingAddress.getVideoPort();
        receivingSocket = new MulticastSocket(port);
        receivingSocket.joinGroup(new InetSocketAddress(streamingAddress.getAddress(), port), null);
        image = null;
        decoder = new Decoder(new Dimension(640, 480));
    }

    public void terminateCameraStreamSendingThread(){
        this.terminate=true;
    }

    public void run(){

        while((grabbedImage = webcam.getImage())!=null  & !terminate){

            image = SwingFXUtils.toFXImage(grabbedImage, null);
            StreammerSectionController.imageProperty.set(image);

            try {
                sendVideoPackets(grabbedImage);
            } catch (Exception e) {
                e.printStackTrace();
            }
            grabbedImage.flush();

        }
        webcam.close();
        StreammerSectionController.imageProperty.set(null);
        System.out.println("Stream Ended");
    }

    /*Sending video packets method*/

    private void sendVideoPackets(BufferedImage bufferedImage) throws Exception {
        imageNumber++;

        //Encoding video packets
        VideoPacket videoPacket = encoder.encode(bufferedImage, imageNumber, System.currentTimeMillis());
        videoPacket.setEncoded(true);
        byte[] sendData = null;

        //Conversion
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
            sendingSocket.send(senddp);
        }
        else {
            System.out.println("Can't Video Packet Sent!!");
        }

        Thread.sleep(5);
    }


}
