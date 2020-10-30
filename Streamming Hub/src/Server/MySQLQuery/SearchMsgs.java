package Server.MySQLQuery;

import Server.Database.DatabaseConnection;
import Server.Server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchMsgs {

    public String getMsgs(String user, String friend) throws SQLException {
        DatabaseConnection connection = DatabaseConnection.getInstance();
        Connection connectDB = connection.getConnection();
        String msgs = new String();
        String query = "select * from messages where userName = ? AND friendName = ? OR userName = ? and friendName = ?";
        PreparedStatement statement = connectDB.prepareStatement(query);
        statement.setString(1, user);
        statement.setString(2, friend);
        statement.setString(3, friend);
        statement.setString(4, user);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            msgs = msgs + rs.getString("userName") + "\n";
            msgs = msgs + rs.getString("friendName") + "\n";
            msgs = msgs + rs.getString("msgContent") + "\n";
            msgs = msgs + rs.getString("msgStatus") + "\n";
            msgs = msgs + rs.getString("msgTimeStamp") + "\n";
        }
        return msgs;
    }
}
