package Streamer;

import ControllerFiles.ChannelSectionController;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;
import javax.sound.sampled.SourceDataLine;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class for synchronizing and playing audio and video
 * Maintains a video and audio queue
 */

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

    /* Basic buttons function*/

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

        System.out.println("Started atleast!!");

        while(!terminate) {

            if(isPause){
                continue;
            }

            // When we receive an audio packet

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

                // If player is on mute, audio data is not written on source line

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

    /* Method for playing frames */

     public synchronized void framePlayer() {

         System.out.println("Framequeue Size: " + frameQueue.size());
             while (frameQueue.size()>0 && frameQueue.peek().getTimestamp() <= time) {

                 try {
                     BufferedImage bufferedImage;
                     if(frameQueue.peek().isEncoded()) {
                            bufferedImage = decoder.decode(frameQueue.peek());
                     }
                     else{
                         byte data[] = frameQueue.peek().getData();
                         ByteArrayInputStream bais = new ByteArrayInputStream(data);
                         bufferedImage = ImageIO.read(bais);
                     }

                     if(bufferedImage!=null) {
                             image = SwingFXUtils.toFXImage(bufferedImage, null);

                             // If image is not null video stream is updated

                             if(image!=null)
                                 ChannelSectionController.imageProperty.set(image);
                             else {
                                 System.out.println("Null image (Synchronizer)");
                             }
                         Thread.sleep(40);
                     }

                     frameQueue.remove();
                 } catch (Exception e) {
                     e.printStackTrace();
                 }

             }
    }

    /* Getting current size of queue */

    private int getAudioQueueSize(){
        return audioQueue.size();
    }
}
