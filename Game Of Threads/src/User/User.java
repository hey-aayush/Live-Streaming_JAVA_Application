package User;

import Database.DatabaseConnection;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class User implements Serializable {
    public User(){

    }

    private int user_id;
    private String username;
    private String firstname;
    private String lastname;
    private String status;
    private ObservableList<OtherUsers> contactlist;

    public ObservableList<OtherUsers> getContactlist() {
        return contactlist;
    }
    public void setContactlist(ObservableList<OtherUsers> contactlist) {
        this.contactlist = contactlist;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    //Value of x,y relative to Scene required to drag window
    private double xOffset = 0;
    private double yOffset = 0;

    public int getUser_id() {
        return user_id;
    }

    public String getUserName() {
        return username;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return this.lastname;
    }

    private void setUser_id(int id) {
        this.user_id = id;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    //private static User user ;

    public User(String username) {

        DatabaseConnection connection = DatabaseConnection.getInstance();
        Connection connectDB = connection.getConnection();

        String verifyLogin = "select userId,firstName,lastName from user where userName = '" + username + "';";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            queryResult.next();
            this.user_id = queryResult.getInt("userId");
            this.firstname = queryResult.getString("firstName");
            this.lastname = queryResult.getString("lastName");
            this.username = username;
          //  this.contactlist = fetchContact();
            //System.out.println(this.user_id);
        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    User(String username, String firstname, String lastname) {
        this.username = username;
        this.lastname = lastname;
        this.username = username;
    }

    public ObservableList<OtherUsers> fetchContact() {
        DatabaseConnection connection = DatabaseConnection.getInstance();
        Connection connectDB = connection.getConnection();

        String searchQuery = "select user.userName,user.userId,user.firstName,user.lastName from user join follow_request_table where (follow_request_table.sender_user_id = users_account_details.user_id  and follow_request_table.reciever_user_id =? and follow_request_table.curr_status = 'active') or (follow_request_table.reciever_user_id = users_account_details.user_id  and follow_request_table.sender_user_id =? and follow_request_table.curr_status = 'active');";
        // Limit to length of search result---
        try {
            PreparedStatement statement = connectDB.prepareStatement(searchQuery);
            statement.setInt(1, this.getUser_id());
            statement.setInt(2, this.getUser_id());
            ResultSet queryResult = statement.executeQuery();
            ObservableList<OtherUsers> otherUsersList = UserDao.getContactUserObjects(queryResult);
            return otherUsersList;

        } catch (Exception E) {
            E.printStackTrace();
        }
        return null;
    }
}
