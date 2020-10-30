package ControllerFiles;

import Application.AskProfileData;
import ClientThread.Client;
import Query.AddFriendData;
import Query.SearchData;
import Response.SearchReply;
import User.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;


public class SearchPageController implements Initializable {
    private BaseStageController baseStageController;

    static ObjectInputStream objectInputStream = Client.objectInputStream;
    static ObjectOutputStream objectOutputStream = Client.objectOutputStream;

    @FXML
    public ListView<User> searchList;
    @FXML
    private TextField searchField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    ObservableList<User> observableList = FXCollections.observableArrayList();

    public void setBaseStageController(BaseStageController baseStageController){
        this.baseStageController = baseStageController;
    }

    public void onClicked(MouseEvent mouseEvent) throws IOException {
        String userName = searchList.getSelectionModel().getSelectedItem().getUserName().trim();
       System.out.println();
       baseStageController.openProfile();
       AskProfileData askProfileData = new AskProfileData(userName);
       askProfileData.profileInfo();
    }


    public void onSearch(ActionEvent event) throws IOException {
        String searchName = searchField.getText();
        System.out.println(searchName);
       SearchData data = new SearchData();
       data.setUserName(searchName);
       objectOutputStream.writeObject(data);
       objectOutputStream.flush();
       System.out.println("qyery send");
    }

    public void appendReply(SearchReply searchReply) {
        observableList.clear();
        for(int i=0; i<searchReply.getVector().size(); i++){
            User usr = searchReply.getVector().get(i);
            observableList.add(usr);
            System.out.println(usr.getUserName());
        }
        //System.out.println(observableList.get(0));
        searchList.setItems(observableList);
        searchList.setCellFactory(param -> new Cells());
    }

    static class Cells extends ListCell<User> {
        VBox vBox= new VBox();
        Label label = new Label();
        Label label2 = new Label();
        Button button = new Button("Add as a friend");

        public Cells(){
            super();
            vBox.getChildren().addAll(label,label2,button );
            button.setOnAction(e -> {
                ChatPageController.friendList.add(label.getText().trim());
                AddFriendData addFriendData = new AddFriendData();
                addFriendData.setUserName(LoginController.getInstance().myUserName);
                addFriendData.setFriendName(label.getText().trim());
                try {
                    SearchPageController.objectOutputStream.writeObject(addFriendData);
                    SearchPageController.objectOutputStream.flush();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }


            });
        }
        public void updateItem(User name, boolean empty){
            super.updateItem(name, empty);
            setText(null);
            setGraphic(null);

            if(name != null && !empty){
                System.out.println(name.getUserName() +  "===----");
                label.setText(name.getUserName() + " ");
                label2.setText(name.getFirstName() + "" + name.getLastName());

                setGraphic(vBox);
            }
        }
    }
}
