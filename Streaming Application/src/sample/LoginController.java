package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javax.xml.transform.Result;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController {

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
            primaryStage.setScene(new Scene(RegistrationWindow, 596, 524));
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }
}
