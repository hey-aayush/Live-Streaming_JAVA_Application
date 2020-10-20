package ControllerFiles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ProfilePageController {
    @FXML
    private TextField UserNameTextField,firstNameTextField,lastNameTextField;
    @FXML
    private Button editButtonProfile,updateButtonProfile;

    public void setUser(User user) {
        UserNameTextField.setText(user.getUserName());
        firstNameTextField.setText(user.getFirstName());
        lastNameTextField.setText(user.getLastName());
    }
    public void setEditButtonProfile(ActionEvent event){

        firstNameTextField.setEditable(true);
        firstNameTextField.setStyle("-fx-control-inner-background: white");
        lastNameTextField.setEditable(true);
        lastNameTextField.setStyle("-fx-control-inner-background: white");
        editButtonProfile.setVisible(false);
        updateButtonProfile.setVisible(true);
    }
}
