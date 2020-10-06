package sample;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class RegistrationController {

    @FXML
    private Button closebutton;
    @FXML
    private Label registrationmessage;
    @FXML
    private Label confirmpasswordmessage;
    @FXML
    private TextField firstnametextfield;
    @FXML
    private TextField lastnametextfield;
    @FXML
    private TextField usernametextfield;
    @FXML
    private PasswordField setpasswordfield;
    @FXML
    private PasswordField confirmpasswordfield;


    public void closeButtonAction(Event event){
        Stage primaryStage = (Stage) closebutton.getScene().getWindow();
        try {
            Parent loginWindow = FXMLLoader.load(getClass().getResource("login.fxml"));
            primaryStage.setTitle("Live Streaming");
            primaryStage.setScene(new Scene(loginWindow, 524, 529));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void registerbuttonAction(Event event) {
        registrationmessage.setText("");
        if (!setpasswordfield.getText().equals(confirmpasswordfield.getText())){
            confirmpasswordmessage.setTextFill(Color.RED);
            confirmpasswordmessage.setText("*Passwords didn't Matched");
            return;
        }else{
            confirmpasswordmessage.setTextFill(Color.GREEN);
            confirmpasswordmessage.setText("*Passwords Matched");
        }
        if (registerUser()) {
            registrationmessage.setTextFill(Color.GREEN);
            registrationmessage.setText("*User Registered Successfully. Please Login");
        }
    }

    public boolean registerUser(){

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        String firstname = firstnametextfield.getText();
        String lastname = lastnametextfield.getText();
        String username = usernametextfield.getText();
        String password = setpasswordfield.getText();

        if(dublicatecheck(username,connectDB)==true){
            registrationmessage.setTextFill(Color.RED);
            registrationmessage.setText("*Username already Exits");
            return false;
        }
        String registeruser = "insert ignore into LiveStream_user_account (firstname,lastname,username,password) values ('"+firstname+"','"+lastname+"','"+username+"','"+password+"');";

        try {
            Statement registrationupdate = connectDB.createStatement();
            int count = registrationupdate.executeUpdate(registeruser);
            System.out.println(count);
            if (count==1){
                registrationupdate.close();
                return true;
            }else{
                registrationupdate.close();
                return false;
            }
        }catch (Exception E){
            E.printStackTrace();
            return false;
        }
    }

    public boolean dublicatecheck(String username,Connection connectionDB){
        String dublicatecheckquery = "select count(*) from LiveStream_user_account where username = '"+username+"'";
        try{
            Statement dublicatestatement = connectionDB.createStatement();
            ResultSet resultSet = dublicatestatement.executeQuery(dublicatecheckquery);
            resultSet.next();
            if (resultSet.getInt(1)==1){
                dublicatestatement.close();
                return true;
            }
            dublicatestatement.close();
            return false;

        }catch (Exception e){
            e.printStackTrace();
            return true;
        }
    }

}
