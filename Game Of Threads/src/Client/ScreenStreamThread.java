package Client;

import ControllerFiles.ChannelSectionController;
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
    static User user;

    public ScreenStreamThread(User user){

        this.terminate =false;
        this.user=user;

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
            ChannelSectionController.imageProperty.set(mainimage);
            grabbedImage.flush();
        }
        System.out.println("Stream Ended");
        ChannelSectionController.imageProperty.set(null);
    }
}
