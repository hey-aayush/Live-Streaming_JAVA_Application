package MySQLQuery;

import Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class AddFriend {
    public void addFriend(String userName, String friendName) throws SQLException {
        // Adding the friend in frinds table
        DatabaseConnection connection = DatabaseConnection.getInstance();
        Connection connectDB = connection.getConnection();
        String query = "insert into friends (userName, friendName) values (?,?)";
        PreparedStatement statement = connectDB.prepareStatement(query);
        statement.setString(1, userName);
        statement.setString(2, friendName);
        statement.executeUpdate();
        System.out.println("friend added");
    }
}