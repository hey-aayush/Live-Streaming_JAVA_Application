package Server;

import Database.DatabaseConnection;
import Message.Message;
import Message.MsgStatus;
import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class NewMsgs {
    public Vector<Message> giveNewMsgs(String friendName) throws SQLException {
        DatabaseConnection connection = DatabaseConnection.getInstance();
        Connection connectDB = connection.getConnection();
        Vector<Message> msgList = new Vector<Message>();
        String query = "select * from messages where friendName = ? AND msgStatus = ?";
        try{
            PreparedStatement st = connectDB.prepareStatement(query);
            st.setString(1, friendName);
            st.setString(2, MsgStatus.UNSEEN.name());
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Message message = new Message();
                message.setSendername(rs.getString("friendName"));
                message.setReceiverName(rs.getString("userName"));
                message.setTimestamp(rs.getTimestamp("msgTimeStamp"));
               msgList.add(message);
            }
            return msgList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }
}
