import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.BufferedReader;
import java.io.BufferedWriter;
public class ClientGuiController {

    @FXML
    TextField msgtxt;
    @FXML
    TextArea textArea;

    public void appendMessage(String message) {
        textArea.appendText(message + "\r\n");
    }

     BufferedWriter writer = Client.writer;
     BufferedReader reader = Client.reader;

    public void sendMessage(ActionEvent event) {
        String str = msgtxt.getText() ;
        System.out.println(str);
        try {
            writer.write(str);
            writer.write("\r\n");
            writer.flush();
        } catch (Exception e) {
        }
        msgtxt.setText("");
    }
}
