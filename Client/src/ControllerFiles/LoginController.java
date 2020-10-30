package ControllerFiles;

//All imports
import ClientThread.Client;
import Query.LoginData;
import Response.TFReply;
import javafx.event.ActionEvent;
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
import javafx.stage.StageStyle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LoginController {

    // Singleton
    public static LoginController singleInstance;
    public LoginController(){}
    public static LoginController getInstance(){
        if(singleInstance == null)
            singleInstance = new LoginController();
        return singleInstance;
    }

    public static String myUserName;
    public BaseStageController baseStageController;

    public RegistrationController getController() {
        return controller;
    }

    public void setController(RegistrationController controller) {
        this.controller = controller;
    }

    private static RegistrationController controller;

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
        myUserName = usernametextfield.getText();
        System.out.println(usernametextfield.getText() + myUserName);
        data.setUserName(myUserName);
        data.setPassword(userpasswordfield.getText());
        if(objectOutputStream != null){
            objectOutputStream.writeObject(data);
            objectOutputStream.flush();
        }


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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLFiles/registration.fxml"));
            //Loading the FXML file
            Parent registrationWindow = loader.load();
            //Access the controller by calling getController() on the FXMLLoader instance.
            controller = (RegistrationController) loader.getController();
            System.out.println("regcontroller" + getController());
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
            /*Stage BaseStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLFiles/searchPage.fxml"));
            Parent BaseWindow = loader.load();
            Scene scene = new Scene(BaseWindow, 700, 650);

            BaseStage.setScene(scene);
            BaseStage.show();
*/
            Stage BaseStage = new Stage();
            BaseStage.initStyle(StageStyle.TRANSPARENT);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLFiles/baseStage.fxml"));
            Parent BaseWindow = loader.
                    load();
            Image appIcon = new Image("res/icon.png");
            BaseStage.getIcons().add(appIcon);
            BaseStage.setTitle("Live Stream");
            baseStageController  = (BaseStageController)loader.getController();
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