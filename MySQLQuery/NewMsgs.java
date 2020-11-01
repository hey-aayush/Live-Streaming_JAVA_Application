package MySQLQuery;

import Database.DatabaseConnection;
import EnumConstants.MsgStatus;
import Query.Message;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class NewMsgs {
    public Vector<Message> giveNewMsgs(String friendName) throws SQLException {
        //For getting the connection of MYSQL database
        DatabaseConnection connection = DatabaseConnection.getInstance();
        Connection connectDB = connection.getConnection();

        //This list will store the new messages came from his all friends
        Vector<Message> msgList = new Vector<Message>();

        // Line 24 - 37 Query from database for finding the new Messages
        String query = "select * from messages where friendName = ? AND msgStatus = ?";
        try{
            PreparedStatement st = connectDB.prepareStatement(query);
            st.setString(1, friendName);
            st.setString(2, MsgStatus.UNSEEN.name());
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Message message = new Message();
                message.setSendername(rs.getString("userName"));
                message.setReceiverName(rs.getString("friendName"));
                message.setTimestamp(rs.getTimestamp("msgTimeStamp"));
                msgList.add(message);
            }
            st.close();
            System.out.println("new msg query complete ho gayi");
            return msgList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }
}