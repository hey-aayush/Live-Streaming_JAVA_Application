package ControllerFiles;

import Application.HomeUser;
import Application.OtherChannels;
import Client.AddFriendData;
import Client.Query.SearchChannelQuery;
import User.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChannelSectionController implements Initializable {

    private static HomeUser homeUser;

    public static ObservableList<OtherChannels> SearchOtherChannelList = FXCollections.observableArrayList();
    public static ObservableList<String> SearchChannelList = FXCollections.observableArrayList();

    @FXML
    private ImageView streammingVideo;

    @FXML
    private JFXButton Connectbtn,Disconnectbtn,ChannelSearchBtn;

    @FXML
    private Button muteBtn,unmuteBtn;

    @FXML
    private AnchorPane LiveFeed,SearchView;

    @FXML
    private TextField channelSearchField;

    @FXML
    private JFXListView<OtherChannels> SearchListView;


    public static ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();

    static class Cell extends ListCell<OtherChannels>{
        HBox hBox = new HBox();
        Button joinbtn = new Button("Join");
        Button subbtn = new Button("Subscribe");
        Label channelDescription = new Label("ChannelDescription");
        Pane pane = new Pane();
        Image profile = new Image("./res/001-profile.png",30,30,false,false);
        ImageView img = new ImageView(profile);


        public Cell(){
            super();
            hBox.getChildren().addAll(img,channelDescription,pane,joinbtn,subbtn);
            hBox.setHgrow(pane, Priority.ALWAYS);
            joinbtn.setOnAction(e->{
                System.out.println(getItem().getChannelId());
                BaseStageController.channelSectionController.viewChannel();
            });
            subbtn.setOnAction(e->{
                System.out.println("Subcribe Channel");

            });
        }

        public void updateItem(OtherChannels otherChannels,boolean empty){
            super.updateItem(otherChannels,empty);
            setText(null);
            setGraphic(null);
            if (otherChannels!=null && !empty){
                channelDescription.setText("Name :"+otherChannels.getChannelName()+" NoSub: "+otherChannels.getNoSubscribers()+" ");
                //Add Status Fields in OtherChannel
                img.setImage(profile);
                hBox.setAlignment(Pos.CENTER);
                setGraphic(hBox);
            }
        }
    }

    public void viewChannel(){
        LiveFeed.setVisible(true);
        SearchView.setVisible(false);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        LiveFeed.setVisible(false);
        SearchView.setVisible(true);
    }

    public void setHomeUser(HomeUser homeUser){
        this.homeUser=homeUser;
    }

    public void DisconnectButtonAction(ActionEvent Event){

    }
    public void ConnectButtonAction(ActionEvent Event){

    }

    public void updateList(){
        SearchListView.setItems(SearchOtherChannelList);
        SearchListView.setCellFactory(param -> new Cell());
    }

    public void ChannelSearchBtnAction(ActionEvent Event){
        String searchedChannel = channelSearchField.getText();
        System.out.println("Searching Channels :"+searchedChannel);
        SearchChannelQuery searchChannelQuery = new SearchChannelQuery(searchedChannel);
        try {
            System.out.println("Searched :" + searchChannelQuery.getQueryChannel());
            Client.Client.objectOutputStream.writeObject(searchChannelQuery);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onClicked(MouseEvent event){
        //geting Channel Id
        System.out.println(SearchOtherChannelList.get(SearchListView.getSelectionModel().getSelectedIndex()).getChannelId());
        LiveFeed.setVisible(true);
        SearchView.setVisible(false);

    }

    public void muteAction(ActionEvent event){
        //mute
        System.out.println("Muted");
    }
    public void unmuteAction(ActionEvent event){
        //Unmute
        System.out.println("Unmuter");
    }

}
