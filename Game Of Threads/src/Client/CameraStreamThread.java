package sample;

import com.github.sarxos.webcam.Webcam;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import java.awt.image.BufferedImage;

public class CameraStreamThread implements Runnable{

    static BufferedImage grabbedImage;
    static Webcam webcam;
    static boolean terminate =false;

    CameraStreamThread(Webcam webcam){
        this.webcam = webcam;
        this.webcam.open();
        this.terminate =false;
    }

    void terminateStream(){
        this.terminate=true;
    }

    public void run(){
        while((grabbedImage = webcam.getImage())!=null  & !terminate){
            final Image mainimage = SwingFXUtils.toFXImage(grabbedImage, null);
            ChannelSectionController.imageProperty.set(mainimage);
            grabbedImage.flush();
        }
        webcam.close();
        ChannelSectionController.imageProperty.set(null);
        System.out.println("Stream Ended");
    }
}
