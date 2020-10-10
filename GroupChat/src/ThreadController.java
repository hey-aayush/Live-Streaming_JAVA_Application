import javafx.application.Platform;
import java.io.BufferedReader;

public class ThreadController implements Runnable{
    ClientGuiController controller;
    ThreadController(ClientGuiController controller){
        this.controller = controller;
    }
    @Override
    public void run(){
        try {
            BufferedReader reader = new Client().reader;
            String msg = "";
            msg = reader.readLine();
            while (!msg.equals(null)) {
                final String temp = msg;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        //Calling appendMessage method of ClientGuiController
                        controller.appendMessage(temp );
                    }
                });
                msg = reader.readLine();
            }
        } catch (Exception e) {
        }
    }
}
