package MySQLQuery;

import Database.DatabaseConnection;
import User.*;

import java.sql.Connection;
import java.sql.Statement;

public class SubscribeToChannelSQL {

    DatabaseConnection connection  = DatabaseConnection.getInstance();
    Connection connectDB = connection.getConnection();

    public void subscribechannel(User user, Channel channel){

        String insert = "INSERT INTO `Subscription_table` (`ReqTime`,`userId`, `ChannelId`, `status`) VALUES ('1977-07-15 16:38:48',+ "+user.getUserId()+","+channel.getChannelId()+" , 'Active');";

        try {
            Statement insertstatement = connectDB.createStatement();
            insertstatement.executeUpdate(insert);
            insertstatement.close();
            System.out.println(user.getUserName()+"Subscribed"+channel.getChannelName());
        } catch (Exception E) {
            E.printStackTrace();
        }


    }
}
