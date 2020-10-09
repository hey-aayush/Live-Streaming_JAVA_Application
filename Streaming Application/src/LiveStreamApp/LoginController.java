package LiveStreamApp;
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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private Button loginbutton;

    @FXML
    private Button cancelbutton;

    @FXML
    private Label loginmessagelabel;

    @FXML
    private TextField usernametextfield;

    @FXML
    private PasswordField userpasswordfield;

    public void validdateLogin(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();
        String verifyLogin = "select count(1) from LiveStream_user_account where username = '"+usernametextfield.getText()+"' and password = '"+userpasswordfield.getText()+"'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while(queryResult.next()){
                if (queryResult.getInt(1)==1){
                    loginmessagelabel.setTextFill(Color.GREEN);
                    loginmessagelabel.setText("Login Successfull");
                    enterloginscene((Stage) loginbutton.getScene().getWindow());
                }else{
                    loginmessagelabel.setTextFill(Color.RED);
                    loginmessagelabel.setText("Enter valid Credentials");
                }
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public void loginbuttonAction(ActionEvent event){
        if(usernametextfield.getText().isBlank()==true|| userpasswordfield.getText().isBlank()==true){
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
            Parent RegistrationWindow = FXMLLoader.load(getClass().getResource("Registration.fxml"));
            primaryStage.setTitle("Live Streaming");
            RegistrationWindow.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });
            RegistrationWindow.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    primaryStage.setX(event.getScreenX() - xOffset);
                    primaryStage.setY(event.getScreenY() - yOffset);
                }
            });
            primaryStage.setScene(new Scene(RegistrationWindow, 596, 524));
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }

    public void enterloginscene(Stage primaryStage){
        try{
            primaryStage.close();
            Stage ProfileStage = new Stage();
            ProfileStage.initStyle(StageStyle.TRANSPARENT);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Profile.fxml"));
            Parent ProfileWindow = (Parent) loader.load();
            Image appIcon = new Image("res/icon.png");
            ProfileStage.getIcons().add(appIcon);
            ProfileStage.setTitle("Live Stream");
            ProfileController setprofile = loader.getController();
            User user = new User(usernametextfield.getText());
            setprofile.setUser(user);
            Scene profilescene = new Scene(ProfileWindow, 676, 611);
            profilescene.setFill(Color.TRANSPARENT);
            ProfileStage.setTitle("Profile");

            ProfileWindow.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });
            ProfileWindow.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    ProfileStage.setX(event.getScreenX() - xOffset);
                    ProfileStage.setY(event.getScreenY() - yOffset);
                }
            });
            ProfileStage.setScene(profilescene);
            ProfileStage.show();
        }
        catch(Exception E){
            E.printStackTrace();
        }

    }
}
