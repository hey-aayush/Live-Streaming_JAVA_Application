package MySQLQuery;

import Database.DatabaseConnection;
import EnumConstants.MsgStatus;
import Query.Message;
import ClientHandler.*;
import User.UserStatus;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SendMessage {

    public void sendMsg(Message msg, Socket socket, ObjectInputStream in, ObjectOutputStream o) throws IOException, ClassNotFoundException, SQLException {
        //For connecting with MYSQL database
        DatabaseConnection connection = DatabaseConnection.getInstance();
        Connection connectDB = connection.getConnection();
        //Checking if Client is connected or not with server
        if(socket.isConnected()){
            System.out.println("Message Received: "+msg.getSendername() + msg.getReceiverName() + msg.getContent());
            String userName = msg.getSendername();
            String friendName = msg.getReceiverName();

            //Line 30 - 38 for checking friend is online or not
            UserStatus friendStatus = UserStatus.ONLINE;
            String query = "select userStatus from user where userName = ?";
            PreparedStatement statement = connectDB.prepareStatement(query);
            statement.setString(1, friendName);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                friendStatus = UserStatus.valueOf(rs.getString("userStatus"));
            }

            try{
                // If friend is ONLINE then send the message through socket
                if(friendStatus.equals(UserStatus.ONLINE)){
                    System.out.println("working");
                    System.out.println(ClientHandler.listOfClient);

                    ObjectOutputStream msgwriter = (ObjectOutputStream) ClientHandler.listOfClient.get(msg.getReceiverName());
                    System.out.println(" ------ " + ClientHandler.listOfClient.get(msg.getReceiverName()));
                    System.out.println(msg.getReceiverName() + "1" + msgwriter);
                    if(msgwriter != null){
                        msgwriter.writeObject(msg);
                        msgwriter.flush();
                    }

                    System.out.println("send to client");
                }

                //Putiing the message in messages table of database
                String insertQuery = "INSERT INTO messages(userName, friendName, msgContent, msgStatus ) " +
                        "VALUES(?, ?, ?, ?)";
                PreparedStatement st2 = connectDB.prepareStatement(insertQuery);
                st2.setString(1, userName);
                st2.setString(2, friendName);
                st2.setString(3, msg.getContent());
                st2.setString(4, MsgStatus.UNSEEN.name());
                st2.execute();
                System.out.println("put into database successfully");
            }catch(Exception e){}
        }
    }
}