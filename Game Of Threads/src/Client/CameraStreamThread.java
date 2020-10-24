package Client;

import ControllerFiles.BaseStageController;
import ControllerFiles.ChannelSectionController;
import ControllerFiles.StreammerSectionController;
import com.github.sarxos.webcam.Webcam;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import User.User;
import java.awt.image.BufferedImage;


public class CameraStreamThread implements Runnable{

    static BufferedImage grabbedImage;
    static Webcam webcam;
    static boolean terminate =false;


    public CameraStreamThread(Webcam webcam){
        this.webcam = webcam;
        this.webcam.open();
        this.terminate =false;

    }

    public void terminateStream(){
        this.terminate=true;
    }

    public void run(){
        while((grabbedImage = webcam.getImage())!=null  & !terminate){
            final Image mainimage = SwingFXUtils.toFXImage(grabbedImage, null);
            System.out.println(BaseStageController.user.getFirstName());
            StreammerSectionController.imageProperty.set(mainimage);
            grabbedImage.flush();
        }
        webcam.close();
        StreammerSectionController.imageProperty.set(null);
        System.out.println("Stream Ended");
    }
}
