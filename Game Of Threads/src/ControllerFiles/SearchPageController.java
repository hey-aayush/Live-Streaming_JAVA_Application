package ControllerFiles;

import Client.*;
import Server.SearchReply;
import User.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchPageController implements Initializable {
    ObjectInputStream objectInputStream = Client.objectInputStream;
    ObjectOutputStream objectOutputStream = Client.objectOutputStream;

    @FXML
    private ListView<User> searchList;
    @FXML
    private TextField searchField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    ObservableList<User> observableList = FXCollections.observableArrayList();


    public void onClicked(MouseEvent mouseEvent) {
       System.out.println(searchList.getSelectionModel().getSelectedItem().getUserName());
    }

    public void onSearch(ActionEvent event) throws IOException {
        String searchName = searchField.getText();
        System.out.println(searchName);
       SearchData data = new SearchData();
       data.setUserName(searchName);
       objectOutputStream.writeObject(data);
       objectOutputStream.flush();
    }

    public void appendReply(SearchReply searchReply) {
        observableList.clear();
        for(int i=0; i<searchReply.getVector().size(); i++){
            User usr = searchReply.getVector().get(i);
            observableList.add(usr);
        }
        //System.out.println(observableList.get(0));
        searchList.setItems(observableList);
        searchList.setCellFactory(param -> new Cell());
    }

    static class Cell extends ListCell<User> {
        VBox vBox= new VBox();
        Label label = new Label();
        Label label2 = new Label();

        public Cell(){
            super();
            vBox.getChildren().addAll(label,label2 );
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
