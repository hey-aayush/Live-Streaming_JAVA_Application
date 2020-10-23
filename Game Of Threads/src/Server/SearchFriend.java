package Server;

import Client.Client;
import Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SearchFriend {
    public Vector<String> getFriendsList(String userName) throws SQLException {
        DatabaseConnection connection = DatabaseConnection.getInstance();
        Connection connectDB = connection.getConnection();

        Vector<String> vector= new Vector<String>();
        String query = "select * from friends where userName = ?";
        PreparedStatement statement = connectDB.prepareStatement(query);
        statement.setString(1,userName);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            vector.add(rs.getString("friendName"));
        }

        String query2 = "select * from friends where friendName = ?";
        PreparedStatement statement2 = connectDB.prepareStatement(query);
        statement.setString(1,userName);
        ResultSet rs2 = statement.executeQuery();
        while (rs.next()){
            vector.add(rs.getString("userName"));
        }
        return vector;
    }



}
