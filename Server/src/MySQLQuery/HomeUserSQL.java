package MySQLQuery;

import Application.HomeUser;
import Database.DatabaseConnection;
import Query.HomeUserQuery;
import Response.HomeUserResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class HomeUserSQL {
    private HomeUserResponse homeUserResponse;
    private HomeUserQuery homeUserQuery;

    DatabaseConnection connection  = DatabaseConnection.getInstance();
    Connection connectDB = connection.getConnection();

    public HomeUser createResponse(HomeUserQuery homeUserQuery){

        String usernameQuery = homeUserQuery.getUserName();

        String query = "select * from user where userName = ?";
        try {
            PreparedStatement statement = connectDB.prepareStatement(query);
            statement.setString(1,usernameQuery);
            ResultSet queryResult = statement.executeQuery();
            queryResult.next();
            HomeUser homeUser = new HomeUser();
            homeUser.setChannelId(queryResult.getInt("userId"));
            homeUser.setHomeLastname(queryResult.getString("lastName"));
            homeUser.setHomeUsername(queryResult.getString("userName"));
            return homeUser;
        } catch (Exception E) {
            E.printStackTrace();
        }
        return null;
    }

    public HomeUserResponse getHomeUserResponse() {
        return homeUserResponse;
    }

    public void setHomeUserResponse(HomeUserResponse homeUserResponse) {
        this.homeUserResponse = homeUserResponse;
    }

    public HomeUserQuery getHomeUserQuery() {
        return homeUserQuery;
    }

    public void setHomeUserQuery(HomeUserQuery homeUserQuery) {
        this.homeUserQuery = homeUserQuery;
    }
}
