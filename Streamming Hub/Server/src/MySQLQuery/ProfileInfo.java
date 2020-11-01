package MySQLQuery;

import Database.DatabaseConnection;
import User.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
            user.setEmail(queryResult.getString("Email"));
            System.out.println(queryResult.getString("userStatus"));
            user.setUserStatus(UserStatus.valueOf(queryResult.getString("userStatus")));
            user.setLastActiveTime(queryResult.getLong("onlineTiming"));

            statement.close();

            if (user.getisChannel()){

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
                    streammerstatement.close();

                }catch (Exception E) {
                    E.printStackTrace();
                }

            }

            String channelquery = "select Channel_table.ChannelId,Channel_table.ChannelName,Channel_table.Curr_status,Channel_table.NoofSubcribers from Subscription_table join Channel_table on Subscription_table.ChannelId=Channel_table.ChannelId where Subscription_table.userId=?;";
            try{
                List<Channel> subscribedchannelList = new ArrayList<Channel>();
                PreparedStatement subscribedChannelquery = connectDB.prepareStatement(channelquery);
                subscribedChannelquery.setInt(1, user.getUserId());
                System.out.println(user.getUserId()+" : Channel List :");
                ResultSet subscribequeryResult = subscribedChannelquery.executeQuery();
                while(subscribequeryResult.next()){
                    Channel subsChannel = new Channel();
                    subsChannel.setChannelName(subscribequeryResult.getString("Channel_table.ChannelName"));
                    subsChannel.setChannelId(subscribequeryResult.getInt("Channel_table.ChannelId"));
                    subsChannel.setNoSubscribers(subscribequeryResult.getInt("Channel_table.NoofSubcribers"));
                    subscribedchannelList.add(subsChannel);
                }
                user.setSubcribedChannel(subscribedchannelList);
                subscribedChannelquery.close();
            }catch (Exception e){
                e.printStackTrace();
            }

            System.out.println(user.getUserName()+" user Created !");
            return user;
        } catch (Exception E) {
            E.printStackTrace();
        }
        return null;
    }
}