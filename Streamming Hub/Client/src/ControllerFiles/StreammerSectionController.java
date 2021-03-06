package ControllerFiles;

import Query.CreateChannelQuery;
import Query.DeleteRoomRequest;
import Streamer.CameraStreamSendingThread;
import ClientThread.Client;
import Streamer.ScreenStreamSendingThread;
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
import Streamer.AudioStreamSendingThread;
import javafx.scene.layout.AnchorPane;

import javax.sound.sampled.LineUnavailableException;
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
    private Button muteBtn,unmuteBtn,createChannelBtn;

    @FXML
    private AnchorPane streammerSection,noStreammerSection;


    public static ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();

    public static CameraStreamSendingThread cameraStreamSendingThread;
    public static ScreenStreamSendingThread screenStreamSendingThread;
    public static AudioStreamSendingThread audioStreamSendingThread;

    enum StreamSource{
        WebCamera,ScreenShare;
    }

    public void setUser(User user){

        this.user=user;
        //Testing
        if (user.getisChannel()){
            this.streamer=(Streamer) user;
            Channel channel = new Channel();
            channel.setChannelId(streamer.getUserId());
            this.streamer.setChannel(channel);

        }else{
            noStreammerSection.setVisible(true);
            createChannelBtn.setVisible(true);
            streammerSection.setVisible(false);
        }
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

        streammerSection.setVisible(true);
        noStreammerSection.setVisible(false);

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

    public void StartStream(StreammerSectionController.SourceInfo sourceInfo) throws IOException, LineUnavailableException {

        if(streamingAddress==null){
            return;
        }

        StreamSource streamSource = sourceInfo.getStreamSource();
        if( streamSource == StreamSource.WebCamera){

            Webcam webcam = Webcam.getDefault();
            webcam.setViewSize(WebcamResolution.VGA.getSize());

            /* Video Sending Thread */
            cameraStreamSendingThread = new CameraStreamSendingThread(webcam, streamer, streamingAddress);
            new Thread(cameraStreamSendingThread).start();

        }else if (streamSource == StreamSource.ScreenShare){
            screenStreamSendingThread = new ScreenStreamSendingThread(streamer, streamingAddress);
            new Thread(screenStreamSendingThread).start();
        }

        /*Audio Sending Thread */
        audioStreamSendingThread = new AudioStreamSendingThread(streamingAddress);
        new Thread(audioStreamSendingThread).start();
    }

    public void StartButtonAction(ActionEvent event) throws IOException, LineUnavailableException {
        StartStream(StreamOptions.getSelectionModel().getSelectedItem());
        System.out.println(StreamOptions.getSelectionModel().getSelectedItem().srcName);
        StartButton.setDisable(true);
        StreamOptions.setDisable(true);
        StopButton.setDisable(false);
        StopButton.setDisableVisualFocus(true);
    }

    public void StopButtonAction(ActionEvent event) throws IOException {

        if (StreamOptions.getSelectionModel().getSelectedItem().getStreamSource()==StreamSource.WebCamera){
            cameraStreamSendingThread.terminateCameraStreamSendingThread();
        }else if (StreamOptions.getSelectionModel().getSelectedItem().getStreamSource()==StreamSource.ScreenShare){
            screenStreamSendingThread.terminateScreenStreamSendingThread();
        }

        audioStreamSendingThread.terminateAudioStreamSendingThread();
        DeleteRoomRequest deleteRoomRequest = new DeleteRoomRequest(streamer.getChannel().getChannelId(), streamingAddress);
        objectOutputStream.writeObject(deleteRoomRequest);
        streamingAddress = null;
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
            objectOutputStream.writeObject(new StreamRequest(streamer.getChannel().getChannelId(), StreamingConstants.REQUEST_STREAMING_ROOM));
            objectOutputStream.flush();
            System.out.println("Room Requested");
        }
    }

    public void onCreateChannelBt(ActionEvent event) throws IOException{
        CreateChannelQuery createChannelQuery = new CreateChannelQuery();
        createChannelQuery.setUser(user);
        objectOutputStream.writeObject(createChannelQuery);
        System.out.println("Please Login again....");
    }

    /* For mute */
    public void muteAction(ActionEvent event){

        audioStreamSendingThread.muteAudio();
        System.out.println("Muted");
    }

    /* For unMute */
    public void unmuteAction(ActionEvent event){

        audioStreamSendingThread.unMuteAudio();
        System.out.println("Unmuter");
    }
}