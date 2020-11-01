package MySQLQuery;

import Application.HomeUser;
import Database.DatabaseConnection;
import User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateChannelSQL {

    DatabaseConnection connection  = DatabaseConnection.getInstance();
    Connection connectDB = connection.getConnection();

    public void createChannel(User user){
        int userId = user.getUserId();

        String update = "update user set isStreammer=1 where userId='"+userId+"';";
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(update);
            statement.close();
        } catch (Exception E) {
            E.printStackTrace();
        }
        String insert = "insert into `Channel_table` (`channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES ('"+user.getUserName()+"Vlogs"+"', "+user.getUserId()+", 0, 'NotStreamming');\n";
        try {
            Statement insertstatement = connectDB.createStatement();
            insertstatement.executeUpdate(insert);
            insertstatement.close();
        } catch (Exception E) {
            E.printStackTrace();
        }

    }

}
