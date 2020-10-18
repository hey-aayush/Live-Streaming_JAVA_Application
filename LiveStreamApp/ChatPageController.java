package LiveStreamApp;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ChatPageController{
    //can put this in it's constructor better hai
    //https://www.youtube.com/watch?v=5qmlh4suIYE
    static User homeUser;

    @FXML
    TextArea ChatTextArea;

    @FXML
    private TextField MsgField;

    @FXML
    private TableView<OtherUsers> contactTable;

    @FXML
    private TableColumn<OtherUsers,String> Contacts;

    public void setUser(String username){
        this.homeUser = new User(username);

        try {
            initialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //runs as page loads


    private void initialize() throws Exception{
        Contacts.setCellValueFactory(cellData->cellData.getValue().getusernameProperty());
        populateTable(homeUser.contactlist);
    }
    private void populateTable(ObservableList<OtherUsers> otherUsersObservableList){
        contactTable.setItems(otherUsersObservableList);
    }

    public void appendMessage(String message) {
        ChatTextArea.appendText(message + "\r\n");
    }

    BufferedWriter writer = BaseStageController.writer;
    BufferedReader reader = BaseStageController.reader;

    public void sendMessage(MouseEvent event) {
        String str = MsgField.getText() ;
        System.out.println(str);
        try {
            writer.write(str);
            writer.write("\r\n");
            writer.flush();
        } catch (Exception e) {
        }
        MsgField.setText("");
    }


}
