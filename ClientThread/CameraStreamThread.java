package ClientThread;

import ControllerFiles.StreammerSectionController;
import Streamer.*;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import javafx.scene.image.Image;
import javax.sound.sampled.LineUnavailableException;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import User.Streamer;


public class CameraStreamThread implements Runnable{

    static BufferedImage grabbedImage;
    static Webcam webcam;
    static boolean terminate =false;
    static Streamer streamer;
    private StreamingAddress streamingAddress;
    private DatagramSocket sendingSocket;
    private int imageNumber;
    private Encoder encoder;
    private InetAddress ip;
    private int port;
    private Image image;
    static AudioSen audioSen;


    public CameraStreamThread(Webcam webcam, Streamer streamer, StreamingAddress streamingAddress) throws IOException {
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

        image = null;
    }

    public void terminateStream(){
        this.terminate=true;
        audioSen.terminateAudioSen();
//        audioRec.terminateAudioRec();
//        synchronizer.terminateSynchronizer();
    }

    public void run(){

        //System.out.println("Reached CameraStreamThread!");

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    previewVideo();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

        try {
            audioSen = new AudioSen(streamingAddress);
            new Thread(audioSen).start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

//        try {
//            new Thread(new AudioSen(streamingAddress)).start();
//        } catch (LineUnavailableException | UnknownHostException e) {
//            e.printStackTrace();
//        }

        while((grabbedImage = webcam.getImage())!=null  & !terminate){


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

    private void sendVideoPackets(BufferedImage bufferedImage) throws Exception {
        imageNumber++;

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
            sendingSocket.send(senddp);

        }
        else {
            System.out.println("Can't Video Packet Sent!!");
        }

        Thread.sleep(5);

    }


}
