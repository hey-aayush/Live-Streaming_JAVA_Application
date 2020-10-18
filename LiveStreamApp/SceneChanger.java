package LiveStreamApp;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SceneChanger {

    public void changeWindow(String fxmlfile){

    }

    public void changeScene(Stage primaryStage,String fxmlfile) {

        try{
            Parent newWindow = FXMLLoader.load(getClass().getResource(fxmlfile));
            primaryStage.setScene(new Scene(newWindow, 596, 524));
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }

}
