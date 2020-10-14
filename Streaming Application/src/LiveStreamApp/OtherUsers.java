package LiveStreamApp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class OtherUsers {
    private IntegerProperty userId;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty userName;

    public OtherUsers(){
        this.userId = new SimpleIntegerProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.userName = new SimpleStringProperty();

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
    
}
