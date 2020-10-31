package Streamer;

import ControllerFiles.StreammerSectionController;
import User.Streamer;
import com.github.sarxos.webcam.WebcamResolution;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

public class ScreenStreamSendingThread implements Runnable{

    static BufferedImage grabbedImage;
    static boolean terminate =false;
    static Robot screenshot;
    static Rectangle  capture;
    static Streamer streamer;
    private int imageNumber;
    private DatagramSocket sendingSocket;
    private StreamingAddress streamingAddress;
    private Encoder encoder;
    private InetAddress ip;
    private int port;

    public ScreenStreamSendingThread(Streamer streamer, StreamingAddress streamingAddress) throws SocketException, UnknownHostException {

        this.terminate =false;
        this.streamer=streamer;
        this.streamingAddress = streamingAddress;
        imageNumber = 0;
        encoder = new Encoder(WebcamResolution.VGA.getSize());
        sendingSocket = new DatagramSocket();
        ip = InetAddress.getByName(streamingAddress.getAddress());
        port = streamingAddress.getVideoPort();

        try {
            screenshot= new Robot();
            capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void terminateScreenStreamSendingThread(){
        this.terminate=true;
    }

    public void run(){
        while((grabbedImage = screenshot.createScreenCapture(capture))!=null  & !terminate){
            //final Image image = SwingFXUtils.toFXImage(grabbedImage, null);
            //StreammerSectionController.imageProperty.set(mainimage);

            try {
                sendVideoPackets(grabbedImage);
            } catch (Exception e) {
                e.printStackTrace();
            }

            grabbedImage.flush();
        }
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
