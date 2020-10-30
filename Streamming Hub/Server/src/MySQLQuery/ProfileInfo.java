package MySQLQuery;

import Database.DatabaseConnection;
import User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProfileInfo {

    DatabaseConnection connection  = DatabaseConnection.getInstance();
    Connection connectDB = connection.getConnection();

    public User getProfileInfo(String userName) {
        User user = new User();
        String query = "select * from user where userName = ?";
        try {
            PreparedStatement statement = connectDB.prepareStatement(query);
            statement.setString(1, userName);
            ResultSet queryResult = statement.executeQuery();
            queryResult.next();

            user.setUserId(queryResult.getInt("userId"));
            user.setLastName(queryResult.getString("lastName"));
            user.setFirstName(queryResult.getString("firstName"));
            user.setUserName(queryResult.getString("userName"));

            System.out.println(queryResult.getString("userName")+" user Created !");
            return user;
        } catch (Exception E) {
            E.printStackTrace();
        }
        return null;
    }
}