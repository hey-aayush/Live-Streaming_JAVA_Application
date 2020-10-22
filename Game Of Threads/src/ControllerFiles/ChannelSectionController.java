package ControllerFiles;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ChannelSectionController implements Initializable {

    @FXML
    private ImageView VideoFeed;

    @FXML
    private JFXButton Connectbtn,Disconnectbtn;

    public static ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    public void DisconnectButtonAction(ActionEvent Event){

    }
    public void ConnectButtonAction(ActionEvent Event){

    }

}
