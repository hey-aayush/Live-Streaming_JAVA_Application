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
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

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
    private JFXListView<String> SearchListView;


    public static ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();

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
        SearchListView.setItems(SearchChannelList);
        for(String name:SearchChannelList){
            System.out.println("Updated :"+name);
        }
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
