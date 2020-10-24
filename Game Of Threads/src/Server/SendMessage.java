package Server;

import Database.DatabaseConnection;
import Message.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class SendMessage {

    public void sendMsg(Message msg, Socket socket, ObjectInputStream in, ObjectOutputStream o) throws IOException, ClassNotFoundException, SQLException {
        DatabaseConnection connection = DatabaseConnection.getInstance();
        Connection connectDB = connection.getConnection();
        while(socket.isConnected()){
            System.out.println("Message Received: "+msg.getSendername() + msg.getReceiverName() + msg.getContent());
            String userName = msg.getSendername();
            String friendName = msg.getReceiverName();
            //Broadcasting messages

            String query = "select status from user where userName = ?";
            PreparedStatement statement = connectDB.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            String friendStatus = "OFFLINE";
            if(rs.next()){
                friendStatus = rs.getString("status");
            }

            try{
                if(friendStatus.equals("ONLINE")){
                    ObjectOutputStream msgwriter = (ObjectOutputStream) ClientHandler.clientList.get(msg.getReceiverName());
                    System.out.println(" ------ " + ClientHandler.clientList.get(msg.getReceiverName()));
                    System.out.println(msg.getReceiverName() + " " + msgwriter);
                    msgwriter.writeObject(msg);
                    System.out.println("send to client");
                }


                    String insertQuery = "INSERT INTO messages(userName, friendName, msgContent, msgStatus ) " +
                            "VALUES(?, ?, ?, ?, ?)";
                    PreparedStatement st2 = connectDB.prepareStatement(query);
                    st2.setString(1, userName);
                    st2.setString(2, friendName);
                    st2.setString(3, msg.getContent());
                    st2.setString(4, msg.getMsgStatus().name());
                    st2.execute();
            }catch(Exception e){}
        }
    }
}
