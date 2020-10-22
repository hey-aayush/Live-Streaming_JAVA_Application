package ControllerFiles;

//All imports
import Client.*;
import Database.DatabaseConnection;
import Server.Registration;
import Server.TFReply;
import com.mysql.cj.log.Log;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {

    public RegistrationController getController() {
        return controller;
    }

    public void setController(RegistrationController controller) {
        this.controller = controller;
    }

    private RegistrationController controller;

    static ObjectOutputStream objectOutputStream = Client.objectOutputStream;
    static ObjectInputStream objectInputStream = Client.objectInputStream;

    //var for x,y for dragging.
    private double xOffset = 0;
    private double yOffset = 0;

    //All elements
    @FXML
    private Button loginbutton,cancelbutton;

    @FXML
    private Label loginmessagelabel;

    @FXML
    private TextField usernametextfield;

    @FXML
    private PasswordField userpasswordfield;

    //Function to verify credentials.
    public void validdateLogin() throws IOException {
        LoginData data = new LoginData();
        data.setUserName(usernametextfield.getText());
        data.setPassword(userpasswordfield.getText());
        objectOutputStream.writeObject(data);
        objectOutputStream.flush();

    }

    public void loginbuttonAction(ActionEvent event) throws IOException {
        if(usernametextfield.getText().isBlank()|| userpasswordfield.getText().isBlank()){
            loginmessagelabel.setText("Enter valid Credentials");
        }else{
            validdateLogin();
        }
    }

    public void cancelButtonAction(ActionEvent event){
        Stage stage = (Stage) cancelbutton.getScene().getWindow();
        stage.close();
    }

    public void RegisterButtonAction(ActionEvent event){
        Stage primaryStage = (Stage) cancelbutton.getScene().getWindow();
        createAccountForm(primaryStage);
    }

    public void createAccountForm(Stage primaryStage) {

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            //Loading the FXML file
            Parent registrationWindow = loader.load();
            //Access the controller by calling getController() on the FXMLLoader instance.
             controller = (RegistrationController) loader.getController();
            primaryStage.setTitle("Live Streaming");
            registrationWindow.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });
            registrationWindow.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    primaryStage.setX(event.getScreenX() - xOffset);
                    primaryStage.setY(event.getScreenY() - yOffset);
                }
            });
            primaryStage.setScene(new Scene(registrationWindow, 596, 524));
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }

    public void enterloginscene(Stage primaryStage){
        try{
            //Need to close it use Transparent Background.
            primaryStage.close();

            Stage BaseStage = new Stage();
            BaseStage.initStyle(StageStyle.TRANSPARENT);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BaseStage.fxml"));
            Parent BaseWindow = (Parent) loader.load();
            Image appIcon = new Image("res/icon.png");
            BaseStage.getIcons().add(appIcon);
            BaseStage.setTitle("Live Stream");
            BaseStageController BaseController  = loader.getController();
            BaseController.setUser(usernametextfield.getText());
            Scene Basescene = new Scene(BaseWindow, 700, 650);
            Basescene.setFill(Color.TRANSPARENT);
            BaseStage.setTitle("Profile");

            BaseWindow.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });
            BaseWindow.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    BaseStage.setX(event.getScreenX() - xOffset);
                    BaseStage.setY(event.getScreenY() - yOffset);
                }
            });
            BaseStage.setScene(Basescene);
            BaseStage.show();
        }
        catch(Exception E){
            E.printStackTrace();
        }

    }

    public void appendReply(TFReply tfReply) {
        if (tfReply.getReply()){
            loginmessagelabel.setTextFill(Color.GREEN);
            loginmessagelabel.setText("Login Successfull");
            enterloginscene((Stage) loginbutton.getScene().getWindow());

        }
        else{
            loginmessagelabel.setTextFill(Color.RED);
            loginmessagelabel.setText("Enter valid Credentials");
        }
    }
}