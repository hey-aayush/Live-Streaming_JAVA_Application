package ControllerFiles;

// all Imports
import Client.*;
import Database.DatabaseConnection;
import Server.TFReply;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class RegistrationController {

    static ObjectOutputStream objectOutputStream = Client.objectOutputStream;
    static ObjectInputStream objectInputStream = Client.objectInputStream;

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
        /*if (registerUser()) {
            registrationmessage.setTextFill(Color.GREEN);
            registrationmessage.setText("*User Registered Successfully. Please Login");
        }*/
    }

    public void registerUser() throws IOException {

        DatabaseConnection connection = DatabaseConnection.getInstance();
        Connection connectDB = connection.getConnection();

        String firstname = firstnametextfield.getText();
        String lastname = lastnametextfield.getText();
        String username = usernametextfield.getText();
        String password = setpasswordfield.getText();
        RegisterData data = new RegisterData();

        data.setFirstName(firstname);
        data.setLastName(lastname);
        data.setUserName(username);
        data.setPassword(password);

        objectOutputStream.writeObject(data);
        objectOutputStream.flush();
    }


    public void appendReply(TFReply tfReply) {
        if(tfReply.getReply());
    }
}
