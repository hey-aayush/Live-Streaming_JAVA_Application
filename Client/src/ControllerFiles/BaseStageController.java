package ControllerFiles;

import Application.AskProfileData;
import ClientThread.Client;
import Query.OnlineOfflineData;
import User.UserStatus;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BaseStageController implements Initializable {
    public static BaseStageController singleInstance;
    public static BaseStageController getInstance(){
        if(singleInstance == null)
            singleInstance = new BaseStageController();
            return singleInstance;

    }


    public static SearchPageController searchPageController;
    public static ChatPageController chatPageController;
    public static ProfilePageController profilePageController;

    public SearchPageController getSearchPageController() {
        return searchPageController;
    }

    public void setSearchPageController(SearchPageController searchPageController) {
        this.searchPageController = searchPageController;
    }

    static BufferedReader reader;

    @FXML
    private ImageView home_btn,profile_btn,chat_btn,channels_btn,settings_btn,exit;
    @FXML
    public AnchorPane TabPane;




    public void handleButtonAction(MouseEvent event) throws IOException {
        if (event.getTarget()==exit) {

            OnlineOfflineData data = new OnlineOfflineData();
            data.setUserName(LoginController.myUserName);
            data.setUserStatus(UserStatus.OFFLINE);
            Client.objectOutputStream.writeObject(data);
            Client.objectOutputStream.flush();

            Stage BaseStage = (Stage) exit.getScene().getWindow();
            BaseStage.close();
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

               // HomePageController HomePageController = loader.getController();
              //  HomePageController.setUser(user);

                TabPane.getChildren().removeAll();
                TabPane.getChildren().setAll(view);

            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (event.getTarget()==profile_btn) {
                openProfile();
                AskProfileData askProfileData = new AskProfileData(LoginController.myUserName);
                askProfileData.profileInfo();

        }else if (event.getTarget()==chat_btn) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLFiles/chatPage.fxml"));
                Pane view = (Pane) loader.load();
                chatPageController = (ChatPageController)loader.getController();
                TabPane.getChildren().removeAll();
                TabPane.getChildren().setAll(view);


        }else if (event.getTarget()==settings_btn) {
            //settings button
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void openProfile(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLFiles/ProfilePage.fxml"));
        try {
            Pane profileView = (Pane) loader.load();
            profilePageController = loader.getController();
            System.out.println(TabPane);
            TabPane.getChildren().removeAll();
            TabPane.getChildren().setAll(profileView);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
