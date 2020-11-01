package MySQLQuery;

import Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SearchFriend {

    //This function will give the friendList of any user which are present in chats
    public Vector<String> getFriendsList(String userName) throws SQLException {
        DatabaseConnection connection = DatabaseConnection.getInstance();
        Connection connectDB = connection.getConnection();
        System.out.println("searching");
        //vector for storing the friends userName
        Vector<String> vector= new Vector<String>();

        //line 22 - 43 querying from database
        String query = "select * from friends where userName = ?";
        PreparedStatement statement = connectDB.prepareStatement(query);
        statement.setString(1,userName);
        ResultSet rs = statement.executeQuery();
        System.out.println("qyery done");
        while (rs.next()){
            System.out.println("11");
            vector.add(rs.getString("friendName"));
        }
        System.out.println("qyery 2 done");
        String query2 = "select * from friends where friendName = ?";
        PreparedStatement statement2 = connectDB.prepareStatement(query2);
        statement2.setString(1,userName);
        ResultSet rs2 = statement2.executeQuery();
        System.out.println("qyery3 done");
        while (rs2.next()){
            System.out.println(1);
            vector.add(rs2.getString("userName"));
        }
        System.out.println(userName);
        System.out.println(vector.size());
        System.out.println("qyery 4 done");
        return vector;
    }


}