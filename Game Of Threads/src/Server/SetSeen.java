package Server;

import Database.DatabaseConnection;
import Message.MsgStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SetSeen {
    public void setSeenMsgs(String userName, String friendName) throws SQLException {
        DatabaseConnection connection = DatabaseConnection.getInstance();
        Connection connectDB = connection.getConnection();
        String query = "Update messages " +
                "set msgStatus = ? where userName = ? AND friendName = ? AND msgStatus = ?";
        System.out.println("method running");
        PreparedStatement statement = connectDB.prepareStatement(query);
        statement.setString(1,MsgStatus.SEEN.name());
        statement.setString(2, userName);
        statement.setString(3, friendName);
        statement.setString(4, MsgStatus.UNSEEN.name());
        System.out.println("seen set ho gaya");
        statement.executeUpdate();
    }
}
