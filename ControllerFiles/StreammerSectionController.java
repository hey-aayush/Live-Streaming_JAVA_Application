package ControllerFiles;

import ClientThread.CameraStreamThread;
import ClientThread.Client;
import ClientThread.ScreenStreamThread;
import Query.LoginData;
import Query.StreamRequest;
import Streamer.StreamingAddress;
import Streamer.StreamingConstants;
import User.Channel;
import User.Streamer;
import User.User;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class StreammerSectionController implements Initializable {

    static User user;
    static Streamer streamer;
    private StreamingAddress streamingAddress = null;
    private BaseStageController baseStageController;

    ObjectOutputStream objectOutputStream = Client.objectOutputStream;

    @FXML
    private ImageView VideoFeed;

    @FXML
    private JFXComboBox<SourceInfo> StreamOptions;

    @FXML
    private JFXButton StopButton,StartButton,respuestRoombtn;

    @FXML
    private Button muteBtn,unmuteBtn;


    public static ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();

    public static Thread streamThread;
    public static CameraStreamThread cameraStreamThread;
    public static ScreenStreamThread screenStreamThread;

    enum StreamSource{
        WebCamera,ScreenShare;
    }

    public void setUser(User user){

        this.streamer = new Streamer();
        //Testing
        Channel channel = new Channel();
<<<<<<< HEAD
        channel.setChannelId(1);
=======
        channel.setChannelID(1);
>>>>>>> 28f023f87cf88b9093f9b9961bec14b82fa4493f
        this.streamer.setChannel(channel);
    }

    public void setBaseStageController(BaseStageController baseStageController){
        this.baseStageController=baseStageController;
    }

    public void setStreamingAddress(StreamingAddress streamingAddress){
        this.streamingAddress = streamingAddress;
        System.out.println("Received streaming address!! In StreamerSectionController: ");
        System.out.println(streamingAddress.getAddress() + " " +  streamingAddress.getVideoPort() + " " + streamingAddress.getAudioPort());
    }

    private class SourceInfo{

        private String srcName;

        private StreamSource streamSource;

        public String getsrcName() {
            return srcName;
        }

        public void setsrcName(String srcName) {
            this.srcName = srcName;
        }

        public StreamSource getStreamSource() {
            return streamSource;
        }

        public void setStreamSource(StreamSource streamSource) {
            this.streamSource = streamSource;
        }

        @Override
        public String toString() {
            return srcName;
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        ObservableList<StreammerSectionController.SourceInfo> options = FXCollections.observableArrayList();
        Webcam webcam = Webcam.getDefault();
        StreammerSectionController.SourceInfo srcInfo = new StreammerSectionController.SourceInfo();
        srcInfo.setStreamSource(StreamSource.WebCamera);
        srcInfo.setsrcName(webcam.getName());
        options.add(srcInfo);

        srcInfo = new StreammerSectionController.SourceInfo();
        srcInfo.setStreamSource(StreamSource.ScreenShare);
        srcInfo.setsrcName("Whole Screen Share");
        options.add(srcInfo);

        StreamOptions.setItems(options);
        StreamOptions.setPromptText("Select Source");

        StopButton.setDisable(true);
        StartButton.setDisable(true);

        StreamOptions.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<StreammerSectionController.SourceInfo>() {

            @Override
            public void changed(ObservableValue<? extends StreammerSectionController.SourceInfo> arg0, StreammerSectionController.SourceInfo arg1, StreammerSectionController.SourceInfo arg2) {
                if (arg2 != null) {
                    StartButton.setDisable(false);
                    VideoFeed.imageProperty().bind(imageProperty);
                }
            }
        });

    }

    public void StartStream(StreammerSectionController.SourceInfo sourceInfo) throws IOException {

        if(streamingAddress==null){
            return;
        }

        StreamSource streamSource = sourceInfo.getStreamSource();
        if( streamSource == StreamSource.WebCamera){

            Webcam webcam = Webcam.getDefault();
            webcam.setViewSize(WebcamResolution.VGA.getSize());

            cameraStreamThread = new CameraStreamThread(webcam, streamer, streamingAddress);
            streamThread = new Thread(cameraStreamThread);
            streamThread.start();
        }else if (streamSource == StreamSource.ScreenShare){
            screenStreamThread = new ScreenStreamThread(streamer);
            streamThread = new Thread(screenStreamThread);
            streamThread.start();
        }
    }

    public void StartButtonAction(ActionEvent event) throws IOException {
        StartStream(StreamOptions.getSelectionModel().getSelectedItem());
        System.out.println(StreamOptions.getSelectionModel().getSelectedItem().srcName);
        StartButton.setDisable(true);
        StreamOptions.setDisable(true);
        StopButton.setDisable(false);
        StopButton.setDisableVisualFocus(true);
    }

    public void StopButtonAction(ActionEvent event){
        if (StreamOptions.getSelectionModel().getSelectedItem().getStreamSource()==StreamSource.WebCamera){
            cameraStreamThread.terminateStream();
        }else if (StreamOptions.getSelectionModel().getSelectedItem().getStreamSource()==StreamSource.ScreenShare){
            screenStreamThread.terminateStream();
        }
        StartButton.setDisableVisualFocus(true);
        StartButton.setDisable(false);
        StreamOptions.setDisable(false);
        StopButton.setDisable(true);
    }

    public void requestRoomAction(ActionEvent event) throws IOException {
        writeStreamRequest();
    }

    public void writeStreamRequest() throws IOException {
        if(streamingAddress==null) {
<<<<<<< HEAD
            objectOutputStream.writeObject(new StreamRequest(streamer.getChannel().getChannelId(), StreamingConstants.REQUEST_STREAMING_ROOM));
=======
            objectOutputStream.writeObject(new StreamRequest(streamer.getChannel().getChannelID(), StreamingConstants.REQUEST_STREAMING_ROOM));
>>>>>>> 28f023f87cf88b9093f9b9961bec14b82fa4493f
            //objectOutputStream.writeObject(new LoginData());
            objectOutputStream.flush();
            System.out.println("Room Requested");
        }
    }

//    public void changeToProfile(User user) {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Client.FXMLFiles/ProfilePage.fxml"));
//        Pane view = null;
//        try {
//            view = (Pane) loader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ProfilePageController profilePageController = loader.getController();
//        profilePageController.setUser(user);
//
//        BaseStageController.TabPane.getChildren().removeAll();
//        BaseStageController.TabPane.getChildren().setAll(view);
//    }

    public void muteAction(ActionEvent event){
        //mute
        System.out.println("Muted");
    }
    public void unmuteAction(ActionEvent event){
        //Unmute
        System.out.println("Unmuter");
    }
}
