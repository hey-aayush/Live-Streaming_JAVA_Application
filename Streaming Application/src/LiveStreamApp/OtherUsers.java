package LiveStreamApp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class OtherUsers {
    private IntegerProperty userId;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty userName;
    private Button button;

    public OtherUsers(){
        this.userId = new SimpleIntegerProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.userName = new SimpleStringProperty();
        this.button = new Button("Send Request");
        this.button.setOnAction(sendRequest);

    }
// for userId :
    public int getUserId(){
        return userId.get();
    }

    public void setUserId(int id){
        this.userId.set(id);
    }

    public IntegerProperty getUsrIdProperty(){
        return userId;
    }
    // for username :
    public String getUserName(){
        return userName.get();
    }

    public void setUserName(String username){
        this.userName.set(username);
    }

    public StringProperty getusernameProperty(){
        return userName;
    }
    // for firstname :
    public String getfirstName(){
        return firstName.get();
    }

    public void setFirstName(String firstname){
        this.firstName.set(firstname);
    }

    public StringProperty getfirstnameProperty(){
        return firstName;
    }
    // for lastname :
    public String getlastName(){
        return lastName.get();
    }

    public void setlastName(String lastname){
        this.lastName.set(lastname);
    }

    public StringProperty getlastnameProperty(){
        return lastName;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public Button getButton() {
        return button;
    }
    EventHandler<ActionEvent> sendRequest = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            //SQL  statements
            System.out.println("Clicked");
        }
    };

    EventHandler<ActionEvent> CancelRequest = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            //SQL  statements
            System.out.println("Clicked");
        }
    };

    public void setbutton(ObservableList<OtherUsers> contactlist){
     for(OtherUsers otherUsers:contactlist){
         if (otherUsers.getUserId()==this.getUserId()){
             this.button = new Button("Cancel Resquest");
             this.button.setOnAction(CancelRequest);
         }
     }
    }
}
