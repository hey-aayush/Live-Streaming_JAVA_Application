package Client;

import ControllerFiles.BaseStageController;
import ControllerFiles.ChannelSectionController;
import ControllerFiles.StreammerSectionController;
import User.User;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ScreenStreamThread implements Runnable{

    static BufferedImage grabbedImage;
    static boolean terminate =false;
    static Robot screenshot;
    static Rectangle  capture;

    public ScreenStreamThread(){

        this.terminate =false;


        try {
            screenshot= new Robot();
            capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void terminateStream(){
        this.terminate=true;
    }

    public void run(){
        while((grabbedImage = screenshot.createScreenCapture(capture))!=null  & !terminate){
            final Image mainimage = SwingFXUtils.toFXImage(grabbedImage, null);
            StreammerSectionController.imageProperty.set(mainimage);
            System.out.println(BaseStageController.user.getFirstName());
            grabbedImage.flush();
        }
        System.out.println("Stream Ended");
        StreammerSectionController.imageProperty.set(null);
    }
}
