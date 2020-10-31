package MySQLQuery;

import Database.DatabaseConnection;
import User.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProfileInfo {

    DatabaseConnection connection  = DatabaseConnection.getInstance();
    Connection connectDB = connection.getConnection();

    public Streamer getProfileInfo(String userName) {
        Streamer user = new Streamer();
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
            user.setisChannel(queryResult.getBoolean("IsStreammer"));

            if (queryResult.getBoolean("IsStreammer")){

                String streammerquery = "select * from Channel_table where userId = ?";
                try{
                    PreparedStatement streammerstatement = connectDB.prepareStatement(streammerquery);
                    streammerstatement.setInt(1, user.getUserId());
                    ResultSet streammerqueryResult = streammerstatement.executeQuery();
                    streammerqueryResult.next();
                    Channel channel = new Channel();
                    channel.setChannelName(streammerqueryResult.getString("channelName"));
                    channel.setChannelId(streammerqueryResult.getInt("ChannelId"));
                    channel.setNoSubscribers(streammerqueryResult.getInt("NoofSubcribers"));

                    user.setChannel(channel);

                    System.out.println(user.getChannel().getChannelName());

                }catch (Exception E) {
                    E.printStackTrace();
                }
            }

            System.out.println(queryResult.getString("userName")+" user Created !");
            return user;
        } catch (Exception E) {
            E.printStackTrace();
        }
        return null;
    }
}