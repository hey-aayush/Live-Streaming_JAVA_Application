package Client;

import ControllerFiles.LoginController;
import ControllerFiles.RegistrationController;
import Server.TFReply;
import com.sun.javafx.tk.AppletWindow;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client implements Runnable{

    Socket socketClient;

    public static ObjectInputStream objectInputStream;
    public static ObjectOutputStream objectOutputStream;

    private static Client singleClient;

    private Client(){

    }
    //For making Client class as a Singleton class
    public static Client getInstance(){
        if(singleClient == null)
            singleClient = new Client();
        return singleClient;
    }


  public void createSocket() {
      try {

          //Creaing client
           socketClient = new Socket("localhost", 5781);
          objectOutputStream = new ObjectOutputStream(socketClient.getOutputStream());
          objectInputStream = new ObjectInputStream(socketClient.getInputStream());

          Thread t= new Thread(new Client());
          t.start();

      }catch (Exception e){
          e.printStackTrace();
      }
  }




    @Override
    public void run() {
      while (socketClient.isConnected()){
          try {
             Object ref = objectInputStream.readObject();
              LoginController lc = new LoginController();

             if(ref instanceof TFReply){
                 TFReply tfReply = (TFReply)ref;
                 Platform.runLater(new Runnable() {
                     @Override
                     public void run() {
                       lc.controller.appendReply(tfReply);
                     }
                 })

             }
          } catch (IOException e) {
              e.printStackTrace();
          } catch (ClassNotFoundException e) {
              e.printStackTrace();
          }
      }
    }
}
