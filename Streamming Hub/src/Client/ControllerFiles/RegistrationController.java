package Client.ControllerFiles;

// all Imports
import Client.ClientThread.Client;
import Client.Query.RegisterData;

import Client.Response.*;
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
import java.sql.Connection;


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
            Parent loginWindow = FXMLLoader.load(getClass().getResource("../Client.FXMLFiles/login.fxml"));
            primaryStage.setTitle("Live Streaming");
            primaryStage.setScene(new Scene(loginWindow, 524, 529));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void registerbuttonAction(Event event) throws IOException {
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
        registerUser();
    }

    public void registerUser() throws IOException {

        String firstname = firstnametextfield.getText();
        String lastname = lastnametextfield.getText();
        String username = usernametextfield.getText();
        String password = setpasswordfield.getText();
        RegisterData data = new RegisterData();

        data.setFirstName(firstname);
        data.setLastName(lastname);
        data.setUserName(username);
        data.setPassword(password);
        System.out.println(objectOutputStream);
        System.out.println("hello1");
        if(objectOutputStream != null){
            System.out.println("hello1");
            objectOutputStream.writeObject(data);
            objectOutputStream.flush();
            System.out.println("hello");
        }

    }


    public void appendReply(TFReply tfReply) {
        if(tfReply.getReply() == true){
            registrationmessage.setTextFill(Color.GREEN);
            registrationmessage.setText("*User Registered Successfully. Please Login");
        }
        else{
            registrationmessage.setTextFill(Color.RED);
            registrationmessage.setText("Registration failed");
        }
    }
}
