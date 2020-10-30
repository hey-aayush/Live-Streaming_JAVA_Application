package Streamer;

import ControllerFiles.StreammerSectionController;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;

import javax.sound.sampled.SourceDataLine;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class Synchronizer implements Runnable {


    private volatile Queue<VideoPacket> frameQueue;
    private volatile Queue<AudioPacket> audioQueue;
    private Decoder decoder;
    SourceDataLine sourceLine;
    long time;
    boolean terminate = false;

    //Don't know why
    private WritableImage image;

    public Synchronizer(){

        decoder = new Decoder(new Dimension(640, 480));
        this.frameQueue = new LinkedList<>();
        this.audioQueue = new LinkedList<>();
        image = null;
        terminate = false;
    }

    public synchronized void addVideoPacket(VideoPacket videoPacket){
        frameQueue.add(videoPacket);
    }

    public synchronized void addAudioPacket(AudioPacket audioPacket){
        audioQueue.add(audioPacket);
    }

    public synchronized void setSourceLine(SourceDataLine sourceLine){
        this.sourceLine = sourceLine;
    }

    public void terminateSynchronizer(){
        this.terminate = true;
        System.out.println("Terminating synchronizer!");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Started atleast!!");

        while(!terminate) {

            if(getAudioQueueSize()>0){

                AudioPacket audioPacket;

                try{
                    audioPacket = audioQueue.peek();
                    audioQueue.remove();
                }
                catch (Exception e){
                    e.printStackTrace();
                    continue;
                }

                time = audioPacket.getTimestamp();
                byte[] audioData = audioPacket.getData();

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        framePlayer();
                    }
                });
                t.start();

                sourceLine.write(audioData, 0, audioData.length);

                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

     public synchronized void framePlayer() {

             while (frameQueue.size()>0 && frameQueue.peek().getTimestamp() <= time) {

                 try {
                     BufferedImage bufferedImage = decoder.decode(frameQueue.peek());

                     if(bufferedImage!=null) {
                         //New lines for javafx
                         if(bufferedImage!=null) {
                             image = SwingFXUtils.toFXImage(bufferedImage, null);

                             if(image!=null)
                                 StreammerSectionController.imageProperty.set(image);
                         }
                         Thread.sleep(50);
                     }

                     frameQueue.remove();
                 } catch (Exception e) {
                     e.printStackTrace();
                 }

             }
    }

    private int getAudioQueueSize(){
        return audioQueue.size();
    }
}
