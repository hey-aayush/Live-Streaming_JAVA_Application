package ControllerFiles;

import Application.HomeUser;
import Application.OtherChannels;
import ClientThread.CameraStreamThread;
import ClientThread.Client;
import ClientThread.StreamReceivingThread;
import Query.SearchChannelQuery;
import Query.StreamRequest;
import Streamer.StreamingAddress;
import Streamer.StreamingConstants;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
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
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class ChannelSectionController implements Initializable {

    private static HomeUser homeUser;
    ObjectOutputStream objectOutputStream = Client.objectOutputStream;
    private StreamingAddress streamingAddress = null;

    public static Thread streamThread;
    public static StreamReceivingThread streamReceivingThread;

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
        Image profile = new Image("res/001-profile.png",30,30,false,false);
        ImageView img = new ImageView(profile);


        public Cell(){
            super();
            hBox.getChildren().addAll(img,channelDescription,pane,joinbtn,subbtn);
            hBox.setHgrow(pane, Priority.ALWAYS);
            joinbtn.setOnAction(e->{
                System.out.println(getItem().getChannelId());
                try {
                    BaseStageController.channelSectionController.viewChannel(getItem().getChannelId());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
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

    public void setStreamingAddress(StreamingAddress streamingAddress){
        this.streamingAddress = streamingAddress;

        System.out.println("In ChannelSectionController: ");
        System.out.println(streamingAddress.getAddress() + ", " + streamingAddress.getVideoPort() + ", " + streamingAddress.getAudioPort());
    }

    public void viewChannel(int currentChannelID) throws IOException {

        requestRoomForJoining(currentChannelID);
        LiveFeed.setVisible(true);
        SearchView.setVisible(false);

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

    boolean alreadyConnected = false;

    public void DisconnectButtonAction(ActionEvent Event){


        alreadyConnected = false;
    }
    public void ConnectButtonAction(ActionEvent Event) throws IOException {
        if(alreadyConnected) return;

        streammingVideo.imageProperty().bind(imageProperty);
//        Webcam webcam = Webcam.getDefault();
//        webcam.setViewSize(WebcamResolution.VGA.getSize());

        streamReceivingThread = new StreamReceivingThread(streamingAddress);
        streamThread = new Thread(streamReceivingThread);
        streamThread.start();

        alreadyConnected = true;
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
            Client.objectOutputStream.writeObject(searchChannelQuery);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onClicked(MouseEvent event) throws IOException {
        //geting Channel Id
        int currentChannelID = SearchOtherChannelList.get(SearchListView.getSelectionModel().getSelectedIndex()).getChannelId();
        System.out.println("onClicked: " +  currentChannelID);

    }

    private void requestRoomForJoining(int currentChannelID) throws IOException {
        StreamRequest streamRequest = new StreamRequest(currentChannelID, StreamingConstants.REQUEST_JOIN_GROUP);
        objectOutputStream.writeObject(streamRequest);
        objectOutputStream.flush();
        System.out.println("Joining request sent!");
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
