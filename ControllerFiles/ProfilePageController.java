package ControllerFiles;


import ClientThread.Client;
import Query.ServerTimeData;
import Response.ProfileReply;
import User.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class ProfilePageController implements Initializable {
    public static long serverTime;
    private static User user;

    private ObjectOutputStream objectOutputStream = Client.objectOutputStream;
    @FXML
    private TextField UserNameTextField,firstNameTextField,lastNameTextField,email;
    @FXML
    private Button editButtonProfile,updateButton,add;
    @FXML
    private Label channelName,subscribers,noOfLiveStream;
//    @FXML
//    private AnchorPane channelSection;
//    @FXML
//    private Label channelName,userStatus, content, subscribers, rating, noOfLiveStreams;


    public void setUser(User user) {
        this.user = user;
        firstNameTextField.setText(user.getFirstName());
        lastNameTextField.setText(user.getLastName());
        UserNameTextField.setText(user.getUserName());
        email.setText(user.getEmail());
        if (user.getisChannel()){
            Streamer streamer = (Streamer) user;
            channelName.setText(streamer.getChannel().getChannelName());
            subscribers.setText(""+streamer.getChannel().getNoSubscribers());
        }
    }
    public void setEditButtonProfile(ActionEvent event) throws IOException {
        firstNameTextField.setEditable(true);
        firstNameTextField.setStyle("-fx-control-inner-background: white");
        lastNameTextField.setEditable(true);
        lastNameTextField.setStyle("-fx-control-inner-background: white");
        editButtonProfile.setVisible(false);
        updateButton.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
