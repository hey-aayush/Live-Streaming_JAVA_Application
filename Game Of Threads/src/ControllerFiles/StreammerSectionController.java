package ControllerFiles;

import Client.CameraStreamThread;
import Client.ScreenStreamThread;
import com.github.sarxos.webcam.Webcam;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class StreammerSectionController implements Initializable {

    @FXML
    private ImageView VideoFeed;

    @FXML
    private JFXComboBox<SourceInfo> StreamOptions;

    @FXML
    private JFXButton StopButton,StartButton;

    public static ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();

    public static Thread streamThread;
    public static CameraStreamThread cameraStreamThread;
    public static ScreenStreamThread screenStreamThread;

    enum StreamSource{
        WebCamera,ScreenShare;
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

    public void StartStream(StreammerSectionController.SourceInfo sourceInfo) {
        StreamSource streamSource = sourceInfo.getStreamSource();
        if( streamSource == StreamSource.WebCamera){
            cameraStreamThread = new CameraStreamThread(Webcam.getDefault());
            streamThread = new Thread(cameraStreamThread);
            streamThread.start();
        }else if (streamSource == StreamSource.ScreenShare){
            screenStreamThread = new ScreenStreamThread();
            streamThread = new Thread(screenStreamThread);
            streamThread.start();
        }
    }

    public void StartButtonAction(ActionEvent event){
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

}
