package Server;

import Server.Database.DatabaseConnection;
import User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Search {

    public Vector<User>  getSearch(String searchName) throws SQLException {
        DatabaseConnection connection = DatabaseConnection.getInstance();
        Connection connectDB = connection.getConnection();
        Vector<User> v = new Vector<User>();
        String query = "select * from user where username like ?";
        PreparedStatement statement = connectDB.prepareStatement(query);
        statement.setString(1,"%"+searchName+"%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            User user = new User();
            user.setUserName(resultSet.getString("userName"));
            user.setFirstName(resultSet.getString("firstName"));
            user.setLastName(resultSet.getString("lastName"));
            user.setStatus(resultSet.getString("status"));
            v.add(user);
        }
        return v;

    }
}
