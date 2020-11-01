package MySQLQuery;

import Database.DatabaseConnection;
import EnumConstants.MsgStatus;

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
        statement.setString(1, MsgStatus.SEEN.name());
        statement.setString(2, friendName);
        statement.setString(3, userName);
        statement.setString(4, MsgStatus.UNSEEN.name());
        /*statement.setString(5, friendName);
        statement.setString(6, userName);
        statement.setString(7, MsgStatus.UNSEEN.name());*/


        statement.executeUpdate();
        System.out.println("seen set ho gaya");
    }
}
