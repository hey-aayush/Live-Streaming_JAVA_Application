import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import java.net.*;

public class Client extends Application {
    static BufferedReader reader;
    static BufferedWriter writer;

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("clientGui.fxml"));
        //Loading the FXML file
        Parent root = loader.load();


        //Access the controller by calling getController() on the FXMLLoader instance.
        ClientGuiController controller = (ClientGuiController)loader.getController();

        //Setting title of the stage
        primaryStage.setTitle("Group chat");
        //setting the height and width of stage and setting the scene in stage
        primaryStage.setScene(new Scene(root, 300, 450));

        //starting thread for the client which will print the message got by server
        Thread t = new Thread(new ThreadController(controller));
        t.start();

        primaryStage.show();
    }

    public static void main(String[] args) throws Exception{
        try{
            //Creaing client
            Socket socketClient = new Socket("localhost", 5436);
            //Outputstream
            writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
            //InputStream
            reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
        }catch(Exception e){}
        launch(args);

    }

}