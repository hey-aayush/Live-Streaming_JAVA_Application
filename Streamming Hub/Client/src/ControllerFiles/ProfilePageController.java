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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class ProfilePageController implements Initializable {

    private static User user;
    private static User homeUser;

    private ObjectOutputStream objectOutputStream = Client.objectOutputStream;
    @FXML
    private TextField UserNameTextField,firstNameTextField,lastNameTextField,email;
    @FXML
    private Button editButtonProfile,updateButton,add;
    @FXML
    private Label channelName,subscribers,noOfLiveStream,userStatusLabel;
    @FXML
    private Circle circle;
    @FXML
    private AnchorPane channelSection;
    @FXML
    private Button subcribeBtn;
    public static void findServerTime() throws IOException {
        ServerTimeData serverTimeData = new ServerTimeData();
        Client.objectOutputStream.writeObject(serverTimeData);
        Client.objectOutputStream.flush();

    }

    public User getHomeUser() {
        return this.homeUser;
    }

    public void setHomeUser(User homeUser) {
        this.homeUser = homeUser;
    }
//    @FXML
//    private AnchorPane channelSection;
//    @FXML
//    private Label channelName,userStatus, content, subscribers, rating, noOfLiveStreams;


    public void setUser(User user, long serverTime) throws IOException {
        this.user = user;
        firstNameTextField.setText(user.getFirstName());
        lastNameTextField.setText(user.getLastName());
        UserNameTextField.setText(user.getUserName());
        if (user.getUserStatus().equals(UserStatus.ONLINE)){
            userStatusLabel.setText(user.getUserStatus().toString());
        }else {

            long timeDiff = new Date().getTime() - serverTime;
            System.out.println(new Date().getTime() + "   " + serverTime);
            System.out.println("timediff" + timeDiff);
            long lastActiveTime = user.getLastActiveTime() + timeDiff;
            System.out.println(lastActiveTime);
            lastActiveTime = new Date().getTime() - lastActiveTime;
            System.out.println(lastActiveTime);
            long minutes = TimeUnit.MINUTES.convert(lastActiveTime,TimeUnit.MILLISECONDS);
            userStatusLabel.setText("ACTIVE " + minutes/60 + "hr" + minutes%60 + "minutes ago");
            circle.setFill(Color.YELLOW);
        }

        email.setText(user.getEmail());
        if (user.getisChannel()){
            Streamer streamer = (Streamer) user;
            channelName.setText(streamer.getChannel().getChannelName());
            subscribers.setText(""+streamer.getChannel().getNoSubscribers());
        }else{
            channelSection.setVisible(false);
        }

//        if(user.getisChannel()){
//            if (homeUser.getisChannel()){
//                Streamer home_user = (Streamer) homeUser;
//                Streamer streamer = (Streamer) user;
//                if(home_user.getChannel().getChannelId()==streamer.getChannel().getChannelId()){
//                    subcribeBtn.setVisible(false);
//                }
//            }
//            for (Channel channel:homeUser.getSubcribedChannel()){
//
//                Streamer streamer = (Streamer) user;
//                if (streamer.getChannel().getChannelId()==channel.getChannelId()){
//                    subcribeBtn.setText("Unsubcribe");
//                }
//
//            }
//        }



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
