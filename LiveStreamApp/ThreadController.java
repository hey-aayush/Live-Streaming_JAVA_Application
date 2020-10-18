package LiveStreamApp;

import javafx.application.Platform;

import java.io.BufferedReader;

public class ThreadController implements Runnable {
    ChatPageController chatPagecontroller;
    ThreadController(ChatPageController chatPagecontroller){
        this.chatPagecontroller = chatPagecontroller;
    }
    @Override
    public void run(){
        try {
            BufferedReader reader = new BaseStageController().reader;
            String msg = "";
            msg = reader.readLine();
            while (!msg.equals(null)) {
                final String temp = msg;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        //Calling appendMessage method of ClientGuiController
                        chatPagecontroller.appendMessage(temp );
                    }
                });
                msg = reader.readLine();
            }
        } catch (Exception e) {
        }
    }
}
