package LiveStreamApp;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class ChatPageController {

    @FXML
    TextArea ChatTextArea;

    @FXML
    TextField MsgField;

    public void appendMessage(String message) {
        ChatTextArea.appendText(message + "\r\n");
    }

    BufferedWriter writer = BaseStageController.writer;
    BufferedReader reader = BaseStageController.reader;

    public void sendMessage(MouseEvent event) {
        String str = MsgField.getText() ;
        System.out.println(str);
        try {
            writer.write(str);
            writer.write("\r\n");
            writer.flush();
        } catch (Exception e) {
        }
        MsgField.setText("");
    }
}
