package LiveStreamApp;

import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    protected String username;
    protected String firstname;
    protected String lastname;

    public String getUserName(){
        return this.username;
    }

    public String getFirstName(){
        return this.firstname;
    }
    public String getLastName(){
        return this.lastname;
    }

    User(String username){

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        String verifyLogin = "select firstname,lastname from LiveStream_user_account where username = '"+username+"';";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            queryResult.next();
            this.firstname=queryResult.getString(1);
            this.lastname=queryResult.getString(2);
            this.username=username;
        }catch (Exception E){
            E.printStackTrace();
        }

    }
    User(String username,String firstname,String lastname){
        this.username=username;
        this.lastname=lastname;
        this.username=username;
    }
}
