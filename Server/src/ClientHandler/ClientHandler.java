package ClientHandler;

import EnumConstants.QueryCode;
import Query.*;
import Database.DatabaseConnection;

import MySQLQuery.*;
import Response.*;


import MySQLQuery.SetSeen;
import User.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Vector;

public class ClientHandler implements Runnable{

    public ObjectInputStream in=null;
    public ObjectOutputStream o=null;

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

    public ClientHandler(Socket socket){
        this.socket = socket;
    }


    public void run(){
        try{
            in= new ObjectInputStream(socket.getInputStream());
            o = new ObjectOutputStream(socket.getOutputStream());

            Message firstMessage = (Message)in.readObject();


            System.out.println(firstMessage.getContent());

            System.out.println("Connected ....");

            while (true){
                System.out.println(in);
                Object object = in.readObject();
                System.out.println(object.getClass());

                System.out.println(object);



                if(object instanceof RegisterData){

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
                    if(object instanceof LoginData){
                        System.out.println("Its a login data");
                        LoginData loginData = (LoginData)object;
                        System.out.println("LoginData" + loginData);
                        Login login = new Login();

                        boolean reply = login.validateLogin(loginData.getUserName(), loginData.getPassword());
                        if(reply){
                            if(listOfClient.containsKey(loginData.getUserName())){
                                listOfClient.replace(loginData.getUserName(), o);
                            }
                            else
                                listOfClient.put(loginData.getUserName(), o);
                        }
                        System.out.println(listOfClient.get(loginData.getUserName())+"kkkkkkkkk" + listOfClient.get(loginData.getUserName()));
                        System.out.println(listOfClient);
                        TFReply tfReply = new TFReply();
                        tfReply.setReply(reply);
                        tfReply.setObj(loginData);
                        o.writeObject(tfReply);
                        o.flush();
                    }
                    else
                        if(object instanceof SearchData){
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
                            System.out.println("SearchReply done");
                        }
                        else
                            if(object instanceof MsgData){
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
                                System.out.println(listOfClient.get(message.getReceiverName()) + "got it" + message.getReceiverName().trim());
                                sendMessage.sendMsg(message, socket,in, o);


                            }
                            else if(object instanceof FriendData){
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
                            else if(object instanceof SetSeenData){
                                 SetSeenData setSeenData = (SetSeenData)object;
                                 SetSeen setSeen = new SetSeen();
                                 System.out.println("calling method");
                                 setSeen.setSeenMsgs(setSeenData.getUserName(), setSeenData.getFriendName());
                                 System.out.println("work done");

                            }
                            else if(object instanceof AddFriendData){
                                  AddFriendData data = (AddFriendData)object;
                                  AddFriend addFriend = new AddFriend();
                                  addFriend.addFriend(data.getUserName(),data.getFriendName());

                            }/*
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
                            }  */

            }

        }catch(Exception e){}

    }

}
