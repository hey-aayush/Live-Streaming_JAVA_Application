package LiveStreamApp;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class ReturnView {

    private Pane view;

    public Pane getPage(String fxmlfile){
        try{
            view = new FXMLLoader().load(getClass().getResource(fxmlfile));
            return view;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
