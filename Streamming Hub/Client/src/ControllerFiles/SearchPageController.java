package ControllerFiles;

import Application.AskProfileData;
import ClientThread.Client;
import Query.AddFriendData;
import Query.SearchData;
import Response.SearchReply;
import User.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchPageController implements Initializable {

    private static User user;

    private static BaseStageController baseStageController;



    static ObjectInputStream objectInputStream = Client.objectInputStream;
    static ObjectOutputStream objectOutputStream = Client.objectOutputStream;

    @FXML
    private ListView<User> searchList;
    @FXML
    private  ListView<Channel> subscribedChannnelListView;
    @FXML
    private TextField searchField;
    @FXML
    private Label heyName,useremail,username;

    public static void setBaseStageController(BaseStageController baseStageController) {
        SearchPageController.baseStageController = baseStageController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    ObservableList<User> observableList = FXCollections.observableArrayList();
    ObservableList<Channel> subsObervseList = FXCollections.observableArrayList();

    public void setUser(User user){
        this.user = user;
        heyName.setText("Hey , "+user.getFirstName());
        username.setText(user.getUserName());
        useremail.setText(user.getEmail());
        for(Channel channel:user.getSubcribedChannel() ){
            System.out.println(channel.getChannelName());
            subsObervseList.add(channel);
        }
        subscribedChannnelListView.setItems(subsObervseList);
        subscribedChannnelListView.setCellFactory(param -> new SubsCells());
    }
    //Onclicking any user present in listView it will open its proifle
    public void onClicked(MouseEvent mouseEvent) throws IOException {

        System.out.println(searchList.getSelectionModel().getSelectedItem().getUserName().trim());
        String userName = searchList.getSelectionModel().getSelectedItem().getUserName().trim();
        System.out.println();
        baseStageController.openProfile(user);
        AskProfileData askProfileData = new AskProfileData(userName);
        askProfileData.profileInfo();
    }
    //For searching the user
    public void onSearch(ActionEvent event) throws IOException {
        String searchName = searchField.getText();
        System.out.println(searchName);
        SearchData data = new SearchData();
        data.setUserName(searchName);
        objectOutputStream.writeObject(data);
        objectOutputStream.flush();
        System.out.println("qyery send");
    }
    //For searching the user by clicking on search button
    public void onSearchbtn(MouseEvent event) throws IOException {
        String searchName = searchField.getText();
        System.out.println(searchName);
        SearchData data = new SearchData();
        data.setUserName(searchName);
        objectOutputStream.writeObject(data);
        objectOutputStream.flush();
        System.out.println("qyery send");
    }
    //Showing the searchList in listView
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
    //For customsiing the cell
    static class Cells extends ListCell<User> {
        VBox vBox= new VBox();
        Label label = new Label();
        Label label2 = new Label();
        Button button = new Button("Add as a friend");

        public Cells(){
            super();
            vBox.getChildren().addAll(label,label2,button );
            //OnClicking this button the user will add to chat friendList
            button.setOnAction(e -> {
                ChatPageController.friendList.add(label.getText().trim());
                AddFriendData addFriendData = new AddFriendData();
                addFriendData.setUserName(LoginController.myUserName);
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

    static class SubsCells extends ListCell<Channel> {
        VBox vBox= new VBox();
        Image profile = new Image("res/001-profile.png",30,30,false,false);
        ImageView img = new ImageView(profile);
        Label label = new Label();
//        Label label2 = new Label();
        //Button button = new Button("Unsubscribe");


        public SubsCells(){
            super();
            vBox.getChildren().addAll(img,label);
//            button.setOnAction(e -> {
//                //function for Unsubcribe...
//            });
        }
        public void updateItem(Channel channel, boolean empty){
            super.updateItem(channel, empty);
            setText(null);
            setGraphic(null);

            if(channel != null && !empty){
                System.out.println(channel.getChannelName() +  "Added in List ");
                label.setText(channel.getChannelName() + " No Subs : "+channel.getNoSubscribers());
                setGraphic(vBox);
            }
        }
    }
}