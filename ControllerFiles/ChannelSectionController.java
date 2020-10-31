package ControllerFiles;

import Application.HomeUser;
import Application.OtherChannels;
import ClientThread.Client;
import Streamer.VideoStreamReceivingThread;
import Query.SearchChannelQuery;
import Query.StreamRequest;
import Streamer.AudioStreamReceivingThread;
import Streamer.StreamingAddress;
import Streamer.StreamingConstants;
import Streamer.Synchronizer;
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

    private VideoStreamReceivingThread videoStreamReceivingThread;
    private AudioStreamReceivingThread audioStreamReceivingThread;
    private Synchronizer synchronizer;

    public static ObservableList<OtherChannels> SearchOtherChannelList = FXCollections.observableArrayList();
    public static ObservableList<String> SearchChannelList = FXCollections.observableArrayList();

    @FXML
    private ImageView streammingVideo;

    @FXML
    private JFXButton Connectbtn,Disconnectbtn,ChannelSearchBtn;

    @FXML
    private Button muteBtn,unmuteBtn, PauseBtn, ResumeBtn;

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

        audioStreamReceivingThread.terminateAudioStreamReceiver();
        videoStreamReceivingThread.terminateVideoStreamThread();
        synchronizer.terminateSynchronizer();
        imageProperty.set(null);
        LiveFeed.setVisible(false);
        SearchView.setVisible(true);

        alreadyConnected = false;
    }


    public void ConnectButtonAction(ActionEvent Event) throws IOException {
        if(alreadyConnected) return;

        streammingVideo.imageProperty().bind(imageProperty);

        //Synchronizer for playing frames with sync
        synchronizer = new Synchronizer();
        new Thread(synchronizer).start();

        //Thread for receiving audio stream
        audioStreamReceivingThread = new AudioStreamReceivingThread(synchronizer, streamingAddress);
        new Thread(audioStreamReceivingThread).start();

        //Thread for receiving video stream
        videoStreamReceivingThread = new VideoStreamReceivingThread(synchronizer, streamingAddress);
        new Thread(videoStreamReceivingThread).start();

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

    /* Join stream method */
    private void requestRoomForJoining(int currentChannelID) throws IOException {
        StreamRequest streamRequest = new StreamRequest(currentChannelID, StreamingConstants.REQUEST_JOIN_GROUP);
        objectOutputStream.writeObject(streamRequest);
        objectOutputStream.flush();
        System.out.println("Joining request sent!");
    }

    /*Method for mute*/
    public void muteAction(ActionEvent event){

        synchronizer.muteAudio();
        System.out.println("Muted");
    }

    /* Method for unmute */
    public void unmuteAction(ActionEvent event){

        synchronizer.unMuteAudio();
        System.out.println("Unmuter");
    }

    /* Method for pause */
    public void pauseAction(ActionEvent event){

        synchronizer.pauseStream();
        System.out.println("Paused !!");
    }

    /* Method for resume */
    public void resumeAction(ActionEvent event){

        synchronizer.unPauseStream();
        System.out.println("Resumed !!");
    }

}
