package Server;

import Server.EnumConstants.QueryCode;
import Server.Query.*;
import Server.Database.DatabaseConnection;
import Message.Message;
import Server.MySQLQuery.*;
import Server.Response.*;


import Streaming.StreamAddressAssigner;
import Streaming.StreamRequest;
import Server.Query.StreamingAddress;
import Streaming.StreamingConstants;
import User.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Vector;

public class ClientHandler implements Runnable{

    public static ObjectInputStream in=null;
    public static ObjectOutputStream o=null;

    DatabaseConnection connection = DatabaseConnection.getInstance();
    Connection con = connection.getConnection();
    public static HashMap<String, ObjectOutputStream> listOfClient = new HashMap<String, ObjectOutputStream>();

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


    public void run(){
        try{
            in= new ObjectInputStream(socket.getInputStream());
            o = new ObjectOutputStream(socket.getOutputStream());

            Message firstMessage = (Message)in.readObject();

            if(listOfClient.containsKey(firstMessage.getSendername())){
                listOfClient.replace(firstMessage.getSendername(), o);
            }
            else
            listOfClient.put(firstMessage.getSendername(), o);

            System.out.println(firstMessage.getContent());
            System.out.println(listOfClient.get(firstMessage.getSendername()));
            //Object for assigning addresses
            StreamAddressAssigner streamAddressAssigner = new StreamAddressAssigner();


            //Adding clients in clients vector
            System.out.println(o);
            System.out.println("Connected ....");

            while (true){
                Query query = null;
                Object object = in.readObject();
                System.out.println(object.getClass());
                LoginData loginDat = (LoginData)object;
                System.out.println(loginDat);
                 query = (Query)object;
                System.out.println(query);
                System.out.println(object);



                if(query.getQueryCode().equals(QueryCode.REGISTER_DATA)){

                    RegisterData registerData = (RegisterData)object;
                   Registration registration = new Registration();

                   boolean reply = registration.insertUser(registerData);
                   TFReply tfReply = new TFReply();
                   System.out.println(reply);
                   tfReply.setReply(reply);
                   tfReply.setObj(registerData);
                   o.writeObject(tfReply);
                   o.flush();
                   System.out.println("done");
                }else
                    if(query.getQueryCode().equals(QueryCode.LOGIN_DATA)){
                        System.out.println("Its a login data");
                        LoginData loginData = (LoginData)object;
                        System.out.println("LoginData" + loginData);
                        Login login = new Login();
                        System.out.println(listOfClient.get(loginData.getUserName())+"kkkkkkkkk" + listOfClient.get(loginData.getUserName()));
                        boolean reply = login.validateLogin(loginData.getUserName(), loginData.getPassword());
                        TFReply tfReply = new TFReply();
                        tfReply.setReply(reply);
                        tfReply.setObj(loginData);
                        o.writeObject(tfReply);
                        o.flush();
                    }
                    else
                        if(query.getQueryCode().equals(QueryCode.SEARCH_DATA)){
                            System.out.println("qurey aa gayi");
                            SearchData searchData = (SearchData)object;
                            Search search = new Search();
                            Vector<User> vector = search.getSearch(searchData.getUserName());
                            System.out.println("----");
                            SearchReply searchReply = new SearchReply();
                            searchReply.setVector(vector);
                            System.out.println(searchReply);
                            if(searchReply.getVector().size() != 0) {
                                o.writeObject(searchReply);
                                System.out.println("ye reply hai" + searchReply.getVector().get(0));
                                o.flush();
                            }
                            System.out.println("all done");
                        }
                        else
                            if(query.getQueryCode().equals(QueryCode.MSG_DATA)){
                                MsgData msgData = (MsgData)object;
                                SearchMsgs msgs = new SearchMsgs();
                                String reply = msgs.getMsgs(msgData.getUserName(), msgData.getFriendName());
                                MsgReply msgReply = new MsgReply();
                                msgReply.setMsgs(reply);
                                msgReply.setFriend(msgData.getFriendName());
                                o.writeObject(msgReply);
                                System.out.println("msgDone");
                                o.flush();
                            }
                            else if(query.getQueryCode().equals(QueryCode.NEW_MSG_DATA)){
                                NewMsgData newMsgData = (NewMsgData)object;
                                NewMsgs newMsgs = new NewMsgs();
                                Vector<Message> msgList = newMsgs.giveNewMsgs(newMsgData.getFriendName());
                                NewMsgReply reply = new NewMsgReply();
                                reply.setNewMsgList(msgList);
                                o.writeObject(reply);
                                System.out.println("new msg done");
                                o.flush();
                            }
                            else if(query.getQueryCode().equals(QueryCode.MSG_DATA)){
                                Message message = (Message)object;
                                SendMessage sendMessage = new SendMessage();
                                System.out.println(listOfClient.get(message.getReceiverName()) + "got it" + message.getReceiverName().trim());
                                sendMessage.sendMsg(message, socket,in, o);


                            }
                            else if(query.getQueryCode().equals(QueryCode.FRIEND_DATA)){
                                System.out.println("friend query aa gayi hai");
                                FriendData friendData = (FriendData)object;
                                SearchFriend sf = new SearchFriend();
                                Vector<String > v = sf.getFriendsList(friendData.getUserName());
                                SearchFriendReply sfr = new SearchFriendReply();
                                sfr.setFriendList(v);
                                System.out.println("start searching");
                                if(v.size() != 0){
                                    o.writeObject(sfr);
                                    o.flush();
                                    System.out.println(sfr.getFriendList().get(0));
                                }
                                System.out.println("all done");

                            }
                            else if(query.getQueryCode().equals(QueryCode.SET_SEEN_DATA)){
                                 SetSeenData setSeenData = (SetSeenData)object;
                                 SetSeen setSeen = new SetSeen();
                                 System.out.println("calling method");
                                 setSeen.setSeenMsgs(setSeenData.getUserName(), setSeenData.getFriendName());
                                 System.out.println("work done");

                            }
                            else if(query.getQueryCode().equals(QueryCode.ADD_FRIEND_DATA)){
                                  AddFriendData data = (AddFriendData)object;
                                  AddFriend addFriend = new AddFriend();
                                  addFriend.addFriend(data.getUserName(),data.getFriendName());

                            }
                            else if(query.getQueryCode().equals(QueryCode.STREAMING_ADDRESS)){
                                StreamRequest streamRequest = (StreamRequest)object;

                                if(streamRequest.getCommand()== StreamingConstants.REQUEST_STREAMING_GROUP) {
                                    StreamingAddress streamingAddress = streamAddressAssigner.getStreamingAddress();

                                    System.out.println("Streaming address: " + streamingAddress.getAddress() +  ", " + streamingAddress.getPort());

                                    o.writeObject(streamingAddress);
                                    o.flush();
                                }
                            }
                            else if (query.getQueryCode().equals(QueryCode.SEARCH_CHANNEL_QUERY)){
                                SearchChannelQuery searchChannelQuery = (SearchChannelQuery)object;
                                System.out.println("Query received: "+searchChannelQuery.getQueryChannel());
                                SearchChannelResponse searchChannelResponse = new SearchChannelResponse();
                                searchChannelResponse.setResponse(searchChannelQuery);
                            }
                            else {

                                System.out.println("Not proper query");
                            }

            }

        }catch(Exception e){}

    }

}
