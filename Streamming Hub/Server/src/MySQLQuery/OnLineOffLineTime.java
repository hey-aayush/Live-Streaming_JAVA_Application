package MySQLQuery;

import Database.DatabaseConnection;
import User.UserStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class OnLineOffLineTime {
    public void setOnLineOfflineTime(String userName, UserStatus userStatus) throws SQLException {
        DatabaseConnection connection = DatabaseConnection.getInstance();
        Connection connectDB =  connection.getConnection();
        String query = "UPDATE user" +
                "SET userStatus = ?, onlineTiming = ?" +
                "WHERE userName = ?";
        PreparedStatement statement = connectDB.prepareStatement(query);
        if(userStatus.name().equals(UserStatus.OFFLINE.name())){
            statement.setString(1,UserStatus.OFFLINE.name());
            statement.setLong(2,new Date().getTime());
        }
        else {
            statement.setString(1,UserStatus.ONLINE.name());
            statement.setLong(3, 0L);
        }
        statement.setString(3, userName);
        statement.executeUpdate();
        statement.close();
    }
}