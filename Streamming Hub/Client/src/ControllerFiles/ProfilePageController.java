package ControllerFiles;


import ClientThread.Client;
import Query.ServerTimeData;
import Query.SubscribeTo;
import Query.UnsubscribeTo;
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
    private static Streamer streamer;
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
    private Button subcribeBtn,unsubcribeBtn;
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

    // For showing the profile information in GUI
    public void setUser(User user, long serverTime) throws IOException {
        this.user = user;
        firstNameTextField.setText(user.getFirstName());
        lastNameTextField.setText(user.getLastName());
        UserNameTextField.setText(user.getUserName());
        email.setText(user.getEmail());
        if (user.getUserStatus().equals(UserStatus.ONLINE)){
            userStatusLabel.setText(user.getUserStatus().toString());
        }else {
            // For calcualting the time difrence between our system and server system
            long timeDiff = new Date().getTime() - serverTime;
            System.out.println(new Date().getTime() + "   " + serverTime);
            System.out.println("timediff" + timeDiff);
            // Adding the time difference in lastActiveTime
            long lastActiveTime = user.getLastActiveTime() + timeDiff;
            System.out.println(lastActiveTime);
            //Finding the diffrence of current time when any other user see it and when that other user become offline
            lastActiveTime = new Date().getTime() - lastActiveTime;
            System.out.println(lastActiveTime);
            //convrting the lastActiveTime (MILLISECONDS) into MINUTES
            long minutes = TimeUnit.MINUTES.convert(lastActiveTime,TimeUnit.MILLISECONDS);
            //Converting minutes into hour and minutes
            userStatusLabel.setText("ACTIVE " + minutes/60 + "hr" + minutes%60 + "minutes ago");
            //Changing the color as according
            circle.setFill(Color.YELLOW);
        }


        if (user.getisChannel()){
            streamer = (Streamer) user;
            channelName.setText(streamer.getChannel().getChannelName());
            subscribers.setText(""+streamer.getChannel().getNoSubscribers());
        }else{
            channelSection.setVisible(false);
        }
        System.out.println(user.getUserName()+"   "+homeUser.getUserName());

        if(user.getisChannel()){
            if (homeUser.getUserName()== user.getUserName()){
                subcribeBtn.setVisible(false);
            }
            for (Channel channel:homeUser.getSubcribedChannel()){

                Streamer streamer = (Streamer) user;
                if (streamer.getChannel().getChannelId()==channel.getChannelId()){
                    subcribeBtn.setVisible(false);
                    unsubcribeBtn.setVisible(true);
                }

            }
        }

    }

    public void subcribeBtnAction(ActionEvent event) throws IOException{
        SubscribeTo subscribeTo = new SubscribeTo();
        subscribeTo.setRequest(homeUser, streamer.getChannel());
        objectOutputStream.writeObject(subscribeTo);
        BaseStageController.user.getSubcribedChannel().add(streamer.getChannel());
        subcribeBtn.setVisible(false);
        unsubcribeBtn.setVisible(true);
    }

    public void unsubcribeBtnAction(ActionEvent event) throws IOException{
        UnsubscribeTo unsubscribeTo = new UnsubscribeTo();
        unsubscribeTo.setRequest(homeUser, streamer.getChannel());
        objectOutputStream.writeObject(unsubscribeTo);
        BaseStageController.user.getSubcribedChannel().remove(streamer.getChannel());
        subcribeBtn.setVisible(true);
        unsubcribeBtn.setVisible(false);
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