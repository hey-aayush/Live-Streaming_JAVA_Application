package Main;

import ClientThread.Client;
import ControllerFiles.LoginController;
import ControllerFiles.RegistrationController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static LoginController controller;
    //Value of x,y relative to Scene required to drag window
    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //creating Login Window and Scene (undecorated)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLFiles/login.fxml"));
        //Loading the FXML file
        Parent root = loader.load();
        //Access the controller by calling getController() on the FXMLLoader instance.
        controller = (LoginController) loader.getController();
        Image appIcon = new Image("res/icon.png");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getIcons().add(appIcon);
        primaryStage.setTitle("Live Streaming");

        //Adding Dragging Function
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });
        //Setting Scene
        primaryStage.setScene(new Scene(root, 524, 529));
        //Showing Window
        primaryStage.show();
    }
    public static void main(String[] args) {
        System.out.println("hello");
        Client client = Client.getInstance();
        client.createSocket();
        System.out.println("hi");
        launch(args);



    }
}
