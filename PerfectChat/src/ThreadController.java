import javafx.application.Platform;
import java.io.BufferedReader;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;

public class ThreadController implements Runnable {
    ClientGuiController controller;
    ThreadController(ClientGuiController controller){
        this.controller = controller;
    }
    @Override
    public void run(){
        try {
            Message msg = new Message();
            ObjectInputStream objectInputStream = Client.objectInputStream;


            try{
                if(msg!=null)
                    msg = (Message) objectInputStream.readObject();
            }catch (Exception e){
                e.printStackTrace();
            }

            while (msg != null) {
                final Message temp = msg;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        //Calling appendMessage method of ClientGuiController
                        try{
                            controller.appendMessage(temp);
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        System.out.println(1);
                    }
                });
                try{
                    msg = (Message) objectInputStream.readObject();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
        }
    }
}
