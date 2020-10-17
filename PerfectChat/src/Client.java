

import com.sun.javafx.tk.AppletWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends Application {

    static ObjectInputStream objectInputStream;
    static ObjectOutputStream objectOutputStream;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        //Loading the FXML file
        Parent root = loader.load();


        //Access the controller by calling getController() on the FXMLLoader instance.
        ClientGuiController controller = (ClientGuiController)loader.getController();

        //Setting title of the stage
        primaryStage.setTitle("Group chat");
        //setting the height and width of stage and setting the scene in stage
        primaryStage.setScene(new Scene(root, 755, 524));

        //starting thread for the client which will print the message got by server
        Thread t = new Thread(new ThreadController(controller));
        t.start();

        primaryStage.show();
    }

    public static void main(String[] args) {
        try{
            //Creaing client
            System.out.println("Yes");
            Socket socketClient = new Socket("localhost", 5781);
            //Outputstream
            Message firstMessage = new Message();
            firstMessage.setSendername("alok");
            firstMessage.setReceiverName("xyz");
            firstMessage.setContent("Hi");
            firstMessage.setStatus(0);

            objectOutputStream = new ObjectOutputStream(socketClient.getOutputStream());
            objectInputStream = new ObjectInputStream(socketClient.getInputStream());

            objectOutputStream.writeObject(firstMessage);
            System.out.println(firstMessage);
            //InputStream
            System.out.println(socketClient);

        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Hello");
        launch(args);
    }
}
