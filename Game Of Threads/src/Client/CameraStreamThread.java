package Client;

import ControllerFiles.ChannelSectionController;
import com.github.sarxos.webcam.Webcam;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import User.User;
import java.awt.image.BufferedImage;


public class CameraStreamThread implements Runnable{

    static BufferedImage grabbedImage;
    static Webcam webcam;
    static boolean terminate =false;
    static User user;


    public CameraStreamThread(Webcam webcam, User user){
        this.webcam = webcam;
        this.webcam.open();
        this.terminate =false;
        this.user=user;
    }

    public void terminateStream(){
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
