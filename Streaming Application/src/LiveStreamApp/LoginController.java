package LiveStreamApp;

//All imports
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {

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
    public void validdateLogin(){

        //Making A Connection
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();
        String verifyLoginQuery = "select count(1) from users_account_details where username = ? and password = ?";
        //Stop SQL injections like Pass = WrongPws'+'OR 1=1....
        try {
            PreparedStatement statement = connectDB.prepareStatement(verifyLoginQuery);
            statement.setString(1,usernametextfield.getText());
            statement.setString(2,userpasswordfield.getText());
            ResultSet queryResult = statement.executeQuery();
            if(queryResult.next()){
                //Query found in DataBase
                if (queryResult.getInt(1)==1){
                    loginmessagelabel.setTextFill(Color.GREEN);
                    loginmessagelabel.setText("Login Successfull");
                    enterloginscene((Stage) loginbutton.getScene().getWindow());
                }//Not Found so invalid credentials
                else{
                    loginmessagelabel.setTextFill(Color.RED);
                    loginmessagelabel.setText("Enter valid Credentials");
                }
            }
            connectDB.close();

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
}
