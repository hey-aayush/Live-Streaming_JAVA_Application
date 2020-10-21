package LiveStreamApp;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

import com.github.sarxos.webcam.Webcam;


/**
 * This is controller for WebCamPreview FXML.
 *
 * @author Rakesh Bhatt (rakeshbhatt10)
 */
public class ChannelSectionController implements Initializable {

    @FXML
    Button btnStartCamera;

    @FXML
    Button btnStopCamera;

    @FXML
    Button btnDisposeCamera;

    @FXML
    ComboBox<SourceInfo> cbCameraOptions;

    @FXML
    BorderPane bpWebCamPaneHolder;

    @FXML
    FlowPane fpBottomPane;

    @FXML
    ImageView imgWebCamCapturedImage;

    private class SourceInfo{
        private String srcName;
        private int srcIndex;

        public String getsrcName() {
            return srcName;
        }

        public void setsrcName(String srcName) {
            this.srcName = srcName;
        }

        public int getsrcIndex() {
            return srcIndex;
        }

        public void setsrcIndex(int srcIndex) {
            this.srcIndex = srcIndex;
        }

        @Override
        public String toString() {
            return srcName;
        }
    }

    private BufferedImage grabbedImage;

    enum StreamSource{
        WebCamera,ScreenShare;
    }

    private Robot setScreen = null;
    private Webcam setWebcam = null;

    private Enum<StreamSource> setsrc = null;

    private boolean stopsrc = false;

    private ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();

    private String srcPromptText = "Choose Source";

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        fpBottomPane.setDisable(true);
        ObservableList<SourceInfo> options = FXCollections.observableArrayList();

        Webcam webcam = Webcam.getDefault();
        SourceInfo srcInfo = new SourceInfo();
        srcInfo.setsrcIndex(0);
        srcInfo.setsrcName(webcam.getName());
        options.add(srcInfo);

        srcInfo = new SourceInfo();
        srcInfo.setsrcIndex(1);
        srcInfo.setsrcName("Whole Screen Share");
        options.add(srcInfo);


        cbCameraOptions.setItems(options);
        cbCameraOptions.setPromptText(srcPromptText);
        cbCameraOptions.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<SourceInfo>() {

            @Override
            public void changed(ObservableValue<? extends SourceInfo> arg0, SourceInfo arg1, SourceInfo arg2) {
                if (arg2 != null) {
                    System.out.println("WebCam Index: " + arg2.getsrcIndex() + ": WebCam Name:" + arg2.getsrcName());
                    initializeStreamSrc(arg2.getsrcIndex());
                }
            }
        });
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                setImageViewSize();
            }
        });

    }

    protected void setImageViewSize() {

        double height = 300;
        double width = 250;
        imgWebCamCapturedImage.setFitHeight(height);
        imgWebCamCapturedImage.setFitWidth(width);
        imgWebCamCapturedImage.prefHeight(height);
        imgWebCamCapturedImage.prefWidth(width);
        imgWebCamCapturedImage.setPreserveRatio(true);

    }

    protected void initializeStreamSrc(final int srcIndex) {

        Task<Void> srcIntilizer = new Task<Void>() {

            @Override
            protected Void call() throws Exception {

                if (srcIndex==0){

                    if (setsrc == null ) {
                        setsrc=StreamSource.WebCamera;
                        setWebcam = Webcam.getWebcams().get(srcIndex);
                        setScreen =null;
                        setWebcam.open();
                    }else if (setsrc == StreamSource.WebCamera){
                        setWebcam.close();
                        setScreen =null;
                        setWebcam = Webcam.getWebcams().get(srcIndex);
                        setWebcam.open();
                    }else if (setsrc == StreamSource.ScreenShare){
                        setScreen =null;
                        setsrc=StreamSource.WebCamera;
                        setWebcam = Webcam.getWebcams().get(srcIndex);
                        setWebcam.open();
                    }
                }else if (srcIndex == 1){
                    if (setsrc == null) {
                        setsrc=StreamSource.ScreenShare;
                        setScreen = new Robot();
                        Rectangle capture =  new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                    }else if (setsrc == StreamSource.ScreenShare) {
                        setScreen = new Robot();
                        Rectangle capture =  new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                    }else if (setsrc == StreamSource.WebCamera) {
                        System.out.println("Webcame --> Screen");
                        setWebcam.close();
                        setsrc=StreamSource.ScreenShare;
                        setWebcam=null;
                        setScreen = new Robot();
                        Rectangle capture =  new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                    }
                }

                startscrStream();
                return null;
            }

        };

        Thread sourceInrilizerThread = new Thread(srcIntilizer);
        sourceInrilizerThread.start();
        fpBottomPane.setDisable(false);
        btnStartCamera.setDisable(true);
    }

    protected void startscrStream() {

        stopsrc = false;
        Task<Void> task = new Task<Void>() {

            @Override
            protected Void call() throws Exception {

                while (!stopsrc) {
                    try {
                        if (setsrc==StreamSource.WebCamera){

                            if ((grabbedImage =  setWebcam.getImage()) != null) {

                                Platform.runLater(new Runnable() {

                                    @Override
                                    public void run() {
                                        final Image mainiamge = SwingFXUtils.toFXImage(grabbedImage, null);
                                        imageProperty.set(mainiamge);
                                    }
                                });

                                grabbedImage.flush();

                            }

                        }else if(setsrc==StreamSource.ScreenShare){

                            Rectangle  capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                            grabbedImage = setScreen.createScreenCapture(capture);
                            if (grabbedImage != null) {

                                Platform.runLater(new Runnable() {

                                    @Override
                                    public void run() {
                                        final Image mainiamge = SwingFXUtils.toFXImage(grabbedImage, null);
                                        imageProperty.set(mainiamge);
                                    }
                                });

                                grabbedImage.flush();

                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                return null;
            }

        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
        imgWebCamCapturedImage.imageProperty().bind(imageProperty);

    }

    private void closeStream() {
        if (setsrc == StreamSource.WebCamera) {
            setWebcam.close();
        }
    }

    public void stopCamera(ActionEvent event) {
//        stopCamera = true;
//        btnStartCamera.setDisable(false);
//        btnStopCamera.setDisable(true);
    }

    public void startCamera(ActionEvent event) {
//        stopCamera = false;
//        startWebCamStream();
//        btnStartCamera.setDisable(true);
//        btnStopCamera.setDisable(false);
    }

    public void disposeCamera(ActionEvent event) {
//        stopCamera = true;
//        closeCamera();
//        btnStopCamera.setDisable(true);
//        btnStartCamera.setDisable(true);
    }
}