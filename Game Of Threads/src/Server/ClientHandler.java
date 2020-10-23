package Server;

import Client.*;
import Database.DatabaseConnection;
import Message.Message;
import User.User;
import com.mysql.cj.log.Log;
import javafx.beans.Observable;
import javafx.collections.ObservableList;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;

public class ClientHandler implements Runnable{

    DatabaseConnection connection = DatabaseConnection.getInstance();
    Connection con = connection.getConnection();

    public static HashMap<String, ObjectOutputStream> clientList = new HashMap<String, ObjectOutputStream>();

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    private Socket socket;

    ClientHandler(Socket socket){
        this.socket = socket;
    }
    ObjectOutputStream o;
    ObjectInputStream in;

    public void run(){
        try{
             in= new ObjectInputStream(socket.getInputStream());
          o = new ObjectOutputStream(socket.getOutputStream());

            Message firstMessage = (Message)in.readObject();
            if(clientList.containsKey(firstMessage.getSendername())){
                clientList.replace(firstMessage.getSendername(), o);
            }
            else
            clientList.put(firstMessage.getSendername(), o);



            //Adding clients in clients vector
            System.out.println(o);
            System.out.println("Connected ....");

            while (socket.isConnected()){
                Object object = in.readObject();
                if(object instanceof RegisterData){
                    RegisterData registerData = (RegisterData)object;
                   Registration registration = new Registration();
                   boolean reply = registration.insertUser(registerData);
                   TFReply tfReply = TFReply.getInstance();
                   System.out.println(reply);
                   tfReply.setReply(reply);
                   tfReply.setObj(registerData);
                   o.writeObject(tfReply);
                   o.flush();
                   System.out.println("done");
                }else
                    if(object instanceof LoginData){
                        LoginData loginData = (LoginData)object;
                        Login login = new Login();
                        boolean reply = login.validateLogin(loginData.getUserName(), loginData.getPassword());
                        TFReply tfReply = TFReply.getInstance();
                        tfReply.setReply(reply);
                        tfReply.setObj(loginData);
                        o.writeObject(tfReply);
                        o.flush();
                    }
                    else
                        if(object instanceof SearchData){
                            SearchData searchData = (SearchData)object;
                            Search search = new Search();
                            Vector<User> vector = search.getSearch(searchData.getUserName());
                            SearchReply searchReply = new SearchReply();
                            searchReply.setVector(vector);
                            o.writeObject(searchReply);
                            o.flush();
                        }
                        else
                            if(object instanceof MsgData){
                                MsgData msgData = (MsgData)object;
                                SearchMsgs msgs = new SearchMsgs();
                                String reply = msgs.getMsgs(msgData.getUserName(), msgData.getFriendName());
                                MsgReply msgReply = new MsgReply();
                                msgReply.setMsgs(reply);
                                o.writeObject(msgReply);
                                System.out.println("msgDone");
                                o.flush();
                            }
                            else if(object instanceof NewMsgData){
                                NewMsgData newMsgData = (NewMsgData)object;
                                NewMsgs newMsgs = new NewMsgs();
                                Vector<Message> msgList = newMsgs.giveNewMsgs(newMsgData.getFriendName());
                                NewMsgReply reply = new NewMsgReply();
                                reply.setNewMsgList(msgList);
                                o.writeObject(reply);
                                System.out.println("new msg done");
                                o.flush();
                            }
                            else if(object instanceof Message){
                                Message message = (Message)object;
                                SendMessage sendMessage = new SendMessage();
                                sendMessage.sendMsg(message, socket,in, o);


                            }
                            else if(object instanceof FriendData){
                                FriendData friendData = (FriendData)object;
                                SearchFriend sf = new SearchFriend();
                                Vector<String > v = sf.getFriendsList(friendData.getUserName());
                                SearchFriendReply sfr = new SearchFriendReply();
                                sfr.setFriendList(v);
                                o.writeObject(sfr);
                                o.flush();
                            }
            }

        }catch(Exception e){}

    }

}
