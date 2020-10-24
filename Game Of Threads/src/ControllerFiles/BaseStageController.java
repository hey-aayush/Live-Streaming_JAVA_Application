package ControllerFiles;

import User.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jdk.dynalink.beans.StaticClass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class BaseStageController {


    public static SearchPageController searchPageController;
    public static ChatPageController chatPageController;

    public SearchPageController getSearchPageController() {
        return searchPageController;
    }

    public void setSearchPageController(SearchPageController searchPageController) {
        this.searchPageController = searchPageController;
    }

    static BufferedReader reader;
    static BufferedWriter writer;

    public static User user;

    public User getUser() {
        return user;
    }

    @FXML
    private ImageView home_btn,profile_btn,chat_btn,channel_btn,stream_btn,settings_btn,exit;
    @FXML
    private AnchorPane TabPane;

    Thread chatThread;

    public void setUser(String username) {
        this.user = new User(username);
    }

    public void handleButtonAction(MouseEvent event){
        if (event.getTarget()==exit) {
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

               // HomePageController HomePageController = loader.getController();
              //  HomePageController.setUser(user);

                TabPane.getChildren().removeAll();
                TabPane.getChildren().setAll(view);

            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (event.getTarget()==profile_btn) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLFiles/ProfilePage.fxml"));
                Pane view = (Pane) loader.load();
                ProfilePageController profilePageController = loader.getController();
                profilePageController.setUser(user);

                TabPane.getChildren().removeAll();
                TabPane.getChildren().setAll(view);

            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (event.getTarget()==chat_btn) {
            try {
                try{
                    //Creaing client
                    Socket socketClient = new Socket("localhost", 5436);
                    //Outputstream
                    writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
                    //InputStream
                    reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
                }catch(Exception e){
                    e.printStackTrace();
                }

                FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatPage.fxml"));
                Pane view = (Pane) loader.load();
                 chatPageController = (ChatPageController)loader.getController();
                TabPane.getChildren().removeAll();
                TabPane.getChildren().setAll(view);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if (event.getTarget()==channel_btn) {
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLFiles/ChannelSection.fxml"));
                Pane view = (Pane) loader.load();
                TabPane.getChildren().removeAll();
                TabPane.getChildren().setAll(view);

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
                TabPane.getChildren().removeAll();
                TabPane.getChildren().setAll(view);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else if (event.getTarget()==settings_btn) {
            //settings button
        }
    }
}
