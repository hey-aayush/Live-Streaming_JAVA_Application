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
    private ObjectOutputStream objectOutputStream = Client.objectOutputStream;
    @FXML
    private TextField UserNameTextField,firstNameTextField,lastNameTextField,email;
    @FXML
    private Button editButtonProfile,updateButtonProfile,add;
    @FXML
    private AnchorPane channelSection;
    @FXML
    private Label channelName,userStatus, content, subscribers, rating, noOfLiveStreams;


    public void setUser(User user) {

    }
    public void setEditButtonProfile(ActionEvent event) throws IOException {
        firstNameTextField.setEditable(true);
        firstNameTextField.setStyle("-fx-control-inner-background: white");
        lastNameTextField.setEditable(true);
        lastNameTextField.setStyle("-fx-control-inner-background: white");
        editButtonProfile.setVisible(false);
        updateButtonProfile.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void appendProfileDataReply(ProfileReply profileReply) throws IOException {

        User user = profileReply.getUser();
        System.out.println(user.getUserName() + "===");
        UserNameTextField.setText(user.getUserName());
        firstNameTextField.setText(user.getFirstName());
        lastNameTextField.setText(user.getLastName());
        email.setText(user.getEmail());
        if(user.getUserStatus() == UserStatus.ONLINE)
        userStatus.setText(user.getUserStatus().name());
        else {
            ServerTimeData serverTimeData = new ServerTimeData();
            Client.objectOutputStream.writeObject(serverTimeData);
            Client.objectOutputStream.flush();
            long timeDiff = new Date().getTime() - serverTime;
            long lastActiveTime = user.getLastActiveTime() + timeDiff;
            long minutes = TimeUnit.MINUTES.convert(lastActiveTime,TimeUnit.MILLISECONDS);
            userStatus.setText("ACTIVE " + minutes/60 + "hr" + minutes%60 + "minutes ago");
        }
        if(user instanceof Streamer){
              content.setText(((Streamer) user).getChannel().getContent());
              rating.setText(((Streamer) user).getChannel().getRating() + "");
              subscribers.setText(((Streamer) user).getChannel().getSubscribers());
              noOfLiveStreams.setText(((Streamer) user).getChannel().getNumberOfLiveStreams() + "");
              channelName.setText(((Streamer) user).getChannel().getChannelName());

        }else{
            channelSection.setVisible(false);
        }
    }

}
