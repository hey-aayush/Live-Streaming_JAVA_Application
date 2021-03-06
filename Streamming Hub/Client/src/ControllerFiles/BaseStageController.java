package ControllerFiles;

import Application.AskProfileData;
import ClientThread.Client;
import Query.OnlineOfflineData;
import ControllerFiles.*;
import User.User;
import User.UserStatus;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BaseStageController implements Initializable {



    public static User user;

    public static BaseStageController singleInstance;

    public static BaseStageController getInstance(){
        if(singleInstance == null) {
            singleInstance = new BaseStageController();
        }
        return singleInstance;

    }

    public void setUser(User user){
        this.user = user;
        System.out.println("IsChannel :"+user.getisChannel());
        try {
            switchTosearchPage();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public User getUser(User user){
        return this.user ;
    }

    public static SearchPageController searchPageController;
    public static ChatPageController chatPageController;
    public static ProfilePageController profilePageController;
    public static StreammerSectionController streammerSectionController;
    public static ChannelSectionController channelSectionController;

    public SearchPageController getSearchPageController() {
        return searchPageController;
    }

    public void setSearchPageController(SearchPageController searchPageController) {
        this.searchPageController = searchPageController;
    }

    static BufferedReader reader;

    @FXML
    private ImageView home_btn,profile_btn,chat_btn,channel_btn,stream_btn,settings_btn,exit;

    @FXML
    private VBox sectionBox;
    @FXML
    public AnchorPane TabPane;

    public void switchTosearchPage() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLFiles/searchPage.fxml"));
        //Loading the FXML file
        Pane view = (Pane) loader.load();
        //Access the controller by calling getController() on the FXMLLoader instance.
        searchPageController = (SearchPageController) loader.getController();
        searchPageController.setBaseStageController(this);
        searchPageController.setUser(user);
        // HomePageController HomePageController = loader.getController();
        //  HomePageController.setUser(user);

        TabPane.getChildren().removeAll();
        TabPane.getChildren().setAll(view);
    }


    public void handleButtonAction(MouseEvent event) throws IOException {
        if (event.getTarget()==exit) {

            OnlineOfflineData data = new OnlineOfflineData();
            data.setUserName(LoginController.myUserName);
            data.setUserStatus(UserStatus.OFFLINE);
            Client.objectOutputStream.writeObject(data);
            Client.objectOutputStream.flush();

            Stage BaseStage = (Stage) exit.getScene().getWindow();
            BaseStage.close();
            System.exit(0);
            //ye thread ko close krao exit p..... Exit function m
            //chatThread.interrupt();
        }else if (event.getTarget()==home_btn) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLFiles/searchPage.fxml"));
                //Loading the FXML file
                Pane view = (Pane) loader.load();
                //Access the controller by calling getController() on the FXMLLoader instance.
                searchPageController = (SearchPageController) loader.getController();
                searchPageController.setBaseStageController(this);
                searchPageController.setUser(user);

                // HomePageController HomePageController = loader.getController();
                //  HomePageController.setUser(user);

                TabPane.getChildren().removeAll();
                TabPane.getChildren().setAll(view);

            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (event.getTarget()==profile_btn) {
            // openProfile();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLFiles/ProfilePage.fxml"));
            Pane profileView = (Pane) loader.load();
            profilePageController = loader.getController();
            profilePageController.setHomeUser(user);
            profilePageController.setUser(user,0);

            System.out.println(TabPane);
            TabPane.getChildren().removeAll();
            TabPane.getChildren().setAll(profileView);
            //AskProfileData askProfileData = new AskProfileData(LoginController.myUserName);
            //askProfileData.profileInfo();

        }else if (event.getTarget()==chat_btn) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLFiles/chatPage.fxml"));
            Pane view = (Pane) loader.load();
            chatPageController = (ChatPageController)loader.getController();
            TabPane.getChildren().removeAll();
            TabPane.getChildren().setAll(view);


        }else if (event.getTarget()==channel_btn) {
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLFiles/ChannelSection.fxml"));
                Pane view = (Pane) loader.load();

                channelSectionController = (ChannelSectionController)loader.getController();

                System.out.println(channelSectionController);

                TabPane.getChildren().removeAll();
                sectionBox.getChildren().removeAll();
                sectionBox.getChildren().setAll(view);
                sectionBox.setAlignment(Pos.TOP_CENTER);
                TabPane.getChildren().setAll(sectionBox);


//                TabPane.getChildren().removeAll();
//                TabPane.getChildren().setAll(view);

            }catch (Exception E){
                E.printStackTrace();
            }
            //ye thread ko close krao exit p..... Exit function m
            //chatThread.interrupt();
        }
        else if (event.getTarget()==stream_btn) {
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLFiles/StreammerSection.fxml"));
                Pane view = (Pane) loader.load();

                streammerSectionController = (StreammerSectionController)loader.getController();
                streammerSectionController.setUser(user);
                streammerSectionController.setBaseStageController(this);

                TabPane.getChildren().removeAll();
                sectionBox.getChildren().removeAll();
                sectionBox.getChildren().setAll(view);
                sectionBox.setAlignment(Pos.TOP_CENTER);
                TabPane.getChildren().setAll(sectionBox);

//                TabPane.getChildren().removeAll();
//                TabPane.getChildren().setAll(view);
            }catch (Exception E){
                E.printStackTrace();
            }
        }

        else if (event.getTarget()==settings_btn) {
            //settings button
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void openProfile(User homeuser){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLFiles/ProfilePage.fxml"));
        try {
            Pane profileView = (Pane) loader.load();
            profilePageController = loader.getController();
            profilePageController.setHomeUser(homeuser);
            System.out.println(TabPane);
            TabPane.getChildren().removeAll();
            TabPane.getChildren().setAll(profileView);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
