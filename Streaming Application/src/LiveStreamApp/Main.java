package LiveStreamApp;
// ALl imports
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

//App starts from here..

public class Main extends Application {

    //Value of x,y relative to Scene required to drag window
    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //creating Login Window and Scene (undecorated)
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
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
        launch(args);
    }
    
}
