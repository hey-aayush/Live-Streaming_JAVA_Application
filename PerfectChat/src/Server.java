
import java.net.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class Server implements Runnable{

    DatabaseConnection connection = new DatabaseConnection();
    Connection con = connection.getConnection();

    static HashMap<String, ObjectOutputStream> listOfClient = new HashMap<String, ObjectOutputStream>();

    Socket socket;
    public static Vector clients = new Vector();

    public Server(Socket socket){
        try{
            this.socket = socket;
        }catch(Exception e){}
    }

    public void run(){
        try{
            ObjectInputStream in= new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream o = new ObjectOutputStream(socket.getOutputStream());

            //Adding clients in clients vector
            System.out.println(o);

            Message firstMessage = (Message)in.readObject();

            listOfClient.put(firstMessage.getSendername(), o);
            System.out.println(listOfClient.get(firstMessage.getSendername()));
            System.out.println(firstMessage);

            while(socket.isConnected()){
                //Reading message from client
                Message msg = (Message) in.readObject();
                System.out.println("Message Received: "+msg.getSendername() + msg.getReceiverName() + msg.getContent());
                String userName = msg.getSendername();
                String friendName = msg.getReceiverName();
                //Broadcasting message to all the clients

                try{
                    ObjectOutputStream msgwriter = (ObjectOutputStream)listOfClient.get(msg.getReceiverName());
                    System.out.println(" ------ " + listOfClient.get(msg.getReceiverName()));
                    System.out.println(msg.getReceiverName() + " " +msgwriter);
                    msgwriter.writeObject(msg);
                    PreparedStatement st = con.prepareStatement("select ConversationId from conversation where UserName = ?" +
                            "AND FriendName = ? OR UserName = ? and FriendName = ?");
                    System.out.println("send to client");
                    st.setString(1,userName);
                    st.setString(2, friendName);
                    st.setString(4,userName);
                    st.setString(3, friendName);
                    System.out.println("Phase1");
                    ResultSet rs = st.executeQuery();
                    System.out.println("Phase2");
                    System.out.println("Phase2");
                    String cId="";
                    while (rs.next())
                     cId = rs.getString("ConversationId");
                    st.close();
                    System.out.println("Phase3");
                    System.out.println("cId: " + cId);
                    String query = "INSERT INTO messages(UserName, FriendName, ConversationId, MsgContent, MsgStatus ) " +
                            "VALUES(?, ?, ?, ?, ?)";
                    PreparedStatement st2 = con.prepareStatement(query);
                    st2.setString(1,userName);
                    st2.setString(2,friendName);
                    st2.setInt(3, Integer.parseInt(cId));
                    st2.setString(4, msg.getContent());
                    st2.setInt(5, msg.getStatus());
                    st2.execute();

                }catch(Exception e){}
            }
        }catch(Exception e){}

    }


    public static void main(String[] args) throws Exception{
        //starting server
        ServerSocket serverSocket = new ServerSocket(5781);
        //waiting for the client to ping
        while(true){
            Socket socket = serverSocket.accept();   //client accepted
            System.out.println(socket.getRemoteSocketAddress());
            //Providing a new thread for communicating  with that client
            Thread t = new Thread(new Server(socket));
            t.start();
        }
    }
}