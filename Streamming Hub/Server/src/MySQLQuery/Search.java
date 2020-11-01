package MySQLQuery;

import Database.DatabaseConnection;
import User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Search {

    // This function will search the users from user table and it will return a list whose name are matched
    public Vector<User>  getSearch(String searchName) throws SQLException {
        DatabaseConnection connection = DatabaseConnection.getInstance();
        Connection connectDB = connection.getConnection();
        Vector<User> v = new Vector<User>();
        String query = "select * from user where username like ?";
        PreparedStatement statement = connectDB.prepareStatement(query);

        //% wildCard is used for matching so that segment of searched text came in the name of any user
        statement.setString(1,"%"+searchName+"%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            User user = new User();
            user.setUserName(resultSet.getString("userName"));
            user.setFirstName(resultSet.getString("firstName"));
            user.setLastName(resultSet.getString("lastName"));
            v.add(user);
        }
        return v;

    }
}