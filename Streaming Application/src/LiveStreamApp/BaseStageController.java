package LiveStreamApp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class BaseStageController {
    static BufferedReader reader;
    static BufferedWriter writer;

    private User user;

    @FXML
    private ImageView home_btn,profile_btn,chat_btn,channels_btn,settings_btn,exit;
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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
                Pane view = (Pane) loader.load();
                HomePageController HomePageController = loader.getController();
                HomePageController.setUser(user.getUserName());

                TabPane.getChildren().removeAll();
                TabPane.getChildren().setAll(view);

            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (event.getTarget()==profile_btn) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilePage.fxml"));
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
                ChatPageController chatPageController = loader.getController();
                chatPageController.setUser(user.getUserName());
                //chatPageController.fetchContact();
                System.out.println(user.getUser_id());
                Thread chatThread = new Thread(new ThreadController(chatPageController));
                chatThread.start();
                //ye thread ko close krao exit p..... Exit function m
                TabPane.getChildren().removeAll();
                TabPane.getChildren().setAll(view);

            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (event.getTarget()==settings_btn) {
            ReturnView retrnView = new ReturnView();
            Pane view = retrnView.getPage("HomePage.fxml");
            TabPane.getChildren().setAll(view);
        }
    }
}
