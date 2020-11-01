package MySQLQuery;

import Database.DatabaseConnection;
import User.*;

import java.sql.Connection;
import java.sql.Statement;

public class UnsubscribeToChannelSQL {

    DatabaseConnection connection  = DatabaseConnection.getInstance();
    Connection connectDB = connection.getConnection();

    public void unsubscribechannel(User user, Channel channel){

        String insert = "DELETE FROM `Subscription_table` WHERE userId='"+user.getUserId()+"' and channelId="+channel.getChannelId()+";";

        try {
            Statement insertstatement = connectDB.createStatement();
            insertstatement.executeUpdate(insert);
            insertstatement.close();
            System.out.println(user.getUserName()+" UnSubscribed"+channel.getChannelName());
        } catch (Exception E) {
            E.printStackTrace();
        }


    }
}
