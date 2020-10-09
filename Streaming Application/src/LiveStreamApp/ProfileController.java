package LiveStreamApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;


public class ProfileController {

    @FXML
    private TextField UserNameTextField,firstNameTextField,lastNameTextField;

    @FXML
    private ImageView home_btn,profile_btn,channels_btn,settings_btn,exit;

    @FXML
    private AnchorPane homePage,profile,channel,settings;

    @FXML
    private Button editButtonProfile,updateButtonProfile;

    private int curr_page = 1;

    private void setCurr_pageInv(){
        if (curr_page == 1){
            homePage.setVisible(false);
            return;
        }else if (curr_page == 2) {
            profile.setVisible(false);
            return;
        }else if (curr_page == 3) {
            channel.setVisible(false);
            return;
        }else if (curr_page == 4) {
            settings.setVisible(false);
            return;
        }
    }

    public void handleButtonAction(MouseEvent event){
        if (event.getTarget()==exit) {
            Stage ProfileStage = (Stage) exit.getScene().getWindow();
            ProfileStage.close();
        }else if (event.getTarget()==home_btn) {
            setCurr_pageInv();
            homePage.setVisible(true);
            curr_page = 1;
        }else if (event.getTarget()==profile_btn) {
            setCurr_pageInv();
            profile.setVisible(true);
            curr_page = 2;
        }else if (event.getTarget()==channels_btn) {
            setCurr_pageInv();
            channel.setVisible(true);
            curr_page = 3;
        }else if (event.getTarget()==settings_btn) {
            setCurr_pageInv();
            settings.setVisible(true);
            curr_page = 4;
        }
    }

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
