package Streamer;

import ControllerFiles.ChannelSectionController;
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
    private final Decoder decoder;
    private SourceDataLine sourceLine;
    private long time;
    private boolean terminate = false;
    private boolean isMute;
    private boolean isPause;
    private volatile WritableImage image;

    public Synchronizer(){
        decoder = new Decoder(new Dimension(640, 480));
        this.frameQueue = new LinkedList<>();
        this.audioQueue = new LinkedList<>();
        image = null;
        terminate = false;
        isMute = false;
        isPause = false;
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


    public void muteAudio(){
        isMute = true;
    }

    public void unMuteAudio(){
        isMute = false;
    }

    public void pauseStream(){
        isPause = true;
    }

    public void unPauseStream(){
        isPause = false;
    }

    @Override
    public void run() {
//        try {
//            Thread.sleep(60);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("Started atleast!!");

        while(!terminate) {

            if(isPause){
                continue;
            }

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

                if(!isMute){
                    sourceLine.write(audioData, 0, audioData.length);
                }

                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

     public synchronized void framePlayer() {

         System.out.println("Framequeue Size: " + frameQueue.size());
             while (frameQueue.size()>0 && frameQueue.peek().getTimestamp() <= time) {

                 try {
                     BufferedImage bufferedImage = decoder.decode(frameQueue.peek());

                     if(bufferedImage!=null) {
                         //New lines for javafx
                         if(bufferedImage!=null) {
                             image = SwingFXUtils.toFXImage(bufferedImage, null);

                             if(image!=null)
                                 ChannelSectionController.imageProperty.set(image);
                             else{
                                 System.out.println("Null image (Synchronizer)");
                             }
                         }
                         Thread.sleep(40);
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
