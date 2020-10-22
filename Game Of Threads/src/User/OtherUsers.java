package User;

import ControllerFiles.HomePageController;
import Database.DatabaseConnection;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.Statement;

public class OtherUsers extends HomePageController {
    private int homeUserId;
    private IntegerProperty userId;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty userName;
    private StringProperty button;
    public Boolean isContact;

    public OtherUsers(){
        this.userId = new SimpleIntegerProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.userName = new SimpleStringProperty();
        this.button = new SimpleStringProperty();
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

    public void setButton(String value) {
        this.button.set(value);
    }

    public StringProperty getButtonProperty() {
        return button;
    }

    public String getButton() {
        return button.getValue();
    }

    public int getHomeUserId(){
        return this.homeUserId;
    }
    public void setHomeUserId(int id){
        this.homeUserId =id ;
    }

    public void SendSQLRequest(){

        DatabaseConnection connection = DatabaseConnection.getInstance();
        Connection connectDB = connection.getConnection();


        String requestQuery = "insert into follow_request_table (sender_user_id,reciever_user_id,curr_status) values("+this.getHomeUserId()+","+this.getUserId()+",'active');";
        System.out.println(this.getHomeUserId());

        try {
            Statement statement = connectDB.createStatement();
            int count = statement.executeUpdate(requestQuery);
            System.out.println(count);
            super.homeUser.setContactlist(super.homeUser.fetchContact());

            //super.search();
            //System.out.println(this.user_id);
        }catch (Exception E){
            E.printStackTrace();
        }


    }


    public void cancelSQLRequest(){

        DatabaseConnection connection = DatabaseConnection.getInstance();
        Connection connectDB = connection.getConnection();

        String requestQuery = "update follow_request_table set curr_status = 'inactive' where sender_user_id = "+this.getHomeUserId()+" and reciever_user_id="+this.getUserId()+";";
        System.out.println(this.getHomeUserId());

        try {
            Statement statement = connectDB.createStatement();
            int count = statement.executeUpdate(requestQuery);
            System.out.println(count);
            super.homeUser.setContactlist(super.homeUser.fetchContact());
            //System.out.println(this.user_id);
        }catch (Exception E){
            E.printStackTrace();
        }


    }

    public void setbutton(ObservableList<OtherUsers> contactlist){

        this.isContact =false;
        this.setButton("Send Request");

        for(OtherUsers otherUsers:contactlist){
            if (otherUsers.getUserId()==this.getUserId()){
                this.isContact = true;
                this.setButton("Cancel Request");

            }
        }

    }
}
