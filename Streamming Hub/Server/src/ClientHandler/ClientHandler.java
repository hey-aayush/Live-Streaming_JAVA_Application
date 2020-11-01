package ClientHandler;

import EnumConstants.QueryCode;
import Query.*;
import Database.DatabaseConnection;

import MySQLQuery.*;
import Response.*;


import MySQLQuery.SetSeen;
import User.*;
import Streamer.*;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

public class ClientHandler implements Runnable{

    StreamingRoomManager streamingRoomManager;

    public ObjectInputStream in=null;
    public ObjectOutputStream o=null;
    //Getting connection of database
    DatabaseConnection connection = DatabaseConnection.getInstance();
    Connection con = connection.getConnection();

    // hashMap to store the objectOutputStream with key userName
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

    //Thread alloted for each client
    public void run(){
        try{
            streamingRoomManager = new StreamingRoomManager();

            in= new ObjectInputStream(socket.getInputStream());
            o = new ObjectOutputStream(socket.getOutputStream());

            /*
            Message firstMessage = (Message)in.readObject();
            System.out.println(firstMessage.getContent());
             */
            System.out.println("Connected ....");

            while (true){
                System.out.println(in);
                //Reading the serialized object
                Object object = in.readObject();

                System.out.println(object.getClass());
                System.out.println(object);

                if(object instanceof RegisterData){
                    //Typecasting to RegisterData
                    RegisterData registerData = (RegisterData)object;
                    Registration registration = new Registration();

                    //Calling function of insertUser of RegisterData
                    boolean reply = registration.insertUser(registerData);

                    //object of TFReply
                    TFReply tfReply = new TFReply();
                    System.out.println(reply);
                    tfReply.setReply(reply);
                    tfReply.setObj(registerData);
                    //Writing the reply
                    o.writeObject(tfReply);
                    o.flush();
                    System.out.println("done");
                }else
                if(object instanceof LoginData){
                    //Typecasting to LoginData
                    LoginData loginData = (LoginData)object;
                    System.out.println("LoginData" + loginData);
                    Login login = new Login();
                    boolean reply = login.validateLogin(loginData.getUserName(), loginData.getPassword());
                    //If successful store the objectOutputStream in listOfClient Hashmap
                    if(reply){
                            /*
                              If present in listOfClient HashMap then replace it
                              else
                              put in hashMap
                             */
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
                    // Typecasting to SearchData
                    SearchData searchData = (SearchData)object;
                    Search search = new Search();
                    //Storing the searchResult in Vector
                    Vector<User> vector = search.getSearch(searchData.getUserName());
                    System.out.println("----");
                    SearchReply searchReply = new SearchReply();
                    searchReply.setVector(vector);
                    System.out.println(searchReply);
                    //if vector not empty
                    if(searchReply.getVector().size() != 0) {
                        o.writeObject(searchReply);
                        System.out.println("ye reply hai" + searchReply.getVector().get(0));
                        o.flush();
                    }
                    System.out.println("SearchReply done");
                }
                else
                if(object instanceof MsgData){
                    //Typecasting to Message Data
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
                    //TypeCasting to NewMsgData
                    NewMsgData newMsgData = (NewMsgData)object;
                    NewMsgs newMsgs = new NewMsgs();
                    //Storing the messages in vector
                    Vector<Message> msgList = newMsgs.giveNewMsgs(newMsgData.getFriendName());
                    NewMsgReply reply = new NewMsgReply();
                    reply.setNewMsgList(msgList);
                    o.writeObject(reply);
                    System.out.println("new msg done");
                    o.flush();
                }
                else if(object instanceof Message){
                    //Typecasting to Message
                    Message message = (Message)object;
                    SendMessage sendMessage = new SendMessage();
                    System.out.println(listOfClient.get(message.getReceiverName()) + "got it" + message.getReceiverName().trim());
                    sendMessage.sendMsg(message, socket,in, o);


                }
                else if(object instanceof FriendData){
                    System.out.println("friend query aa gayi hai");
                    //Typecasting to friendData
                    FriendData friendData = (FriendData)object;
                    SearchFriend sf = new SearchFriend();
                    //Storing the list of ChatFriends in vector
                    Vector<String > v = sf.getFriendsList(friendData.getUserName());
                    SearchFriendReply sfr = new SearchFriendReply();
                    sfr.setFriendList(v);
                    System.out.println("start searching");
                    //If friendList is not empty
                    if(v.size() != 0){
                        o.writeObject(sfr);
                        o.flush();
                        System.out.println(sfr.getFriendList().get(0));
                    }
                    System.out.println("all done");

                }
                else if(object instanceof SetSeenData){
                    //Typecsting to SetSeenData
                    SetSeenData setSeenData = (SetSeenData)object;
                    SetSeen setSeen = new SetSeen();
                    System.out.println("calling method");
                    setSeen.setSeenMsgs(setSeenData.getUserName(), setSeenData.getFriendName());
                    System.out.println("work done");

                }
                else if(object instanceof AddFriendData){
                    //Typecasting to AddFriendData
                    AddFriendData data = (AddFriendData)object;
                    AddFriend addFriend = new AddFriend();
                    addFriend.addFriend(data.getUserName(),data.getFriendName());

                }
                else if(object instanceof ProfileData){
                    //TypeCasting to ProfileData
                    ProfileData data = (ProfileData)object;
                    ProfileInfo profileInfo = new ProfileInfo();
                    //Getting the user profile info
                    System.out.println("Profile Data Recieved");
                    Streamer user = profileInfo.getProfileInfo(data.getUserName());
                    ProfileReply reply = new ProfileReply();
                    reply.setUser(user);
                    reply.setServerCurrTime(new Date().getTime());
                    System.out.println(reply);
                    o.writeObject(reply);
                    o.flush();
                    System.out.println("ProfileInfo Reply sent");
                }
                else if(object instanceof OnlineOfflineData){
                    //TypeCasting to onlineOfflineData
                    OnlineOfflineData onlineOfflineData = (OnlineOfflineData)object;
                    OnLineOffLineTime offLineTime = new OnLineOffLineTime();
                    offLineTime.setOnLineOfflineTime(onlineOfflineData.getUserName(), onlineOfflineData.getUserStatus());

                }else if (object instanceof SearchChannelQuery){
                        SearchChannelQuery searchChannelQuery = (SearchChannelQuery)object;
                        System.out.println("Query received: "+searchChannelQuery.getQueryChannel());
                        SearchChannelResponse searchChannelResponse = new SearchChannelResponse();
                        searchChannelResponse.setSearchChannelList(new SearchChannelSQL().setResponse(searchChannelQuery));
                        o.writeObject(searchChannelResponse);
                    }
                    else if(object instanceof StreamRequest){

                        System.out.println("StreamRequest received!!");
                        StreamRequest streamRequest = (StreamRequest)object;
                        System.out.println(streamRequest);
                        StreamingAddress streamingAddress = streamingRoomManager.getStreamingAddress(streamRequest);
                        System.out.println(streamingAddress);
                        if(streamingAddress!=null) {
                            System.out.println("In client handler, streaming use: " + streamingAddress.getAddressUse());
                            System.out.println("Audio port: " + streamingAddress.getAudioPort());
                            o.writeObject(streamingAddress);
                            o.flush();
                            o.reset();
                        }
                        else{
                            System.out.println("Null streaming address!!");
                        }
                    }
                    else if(object instanceof DeleteRoomRequest){

                        DeleteRoomRequest request = (DeleteRoomRequest) object;
                        streamingRoomManager.removeActiveRoom(request);
                    }
                    else if(object instanceof CreateChannelQuery){

                        System.out.println("Create Channel Request Recieved");

                        CreateChannelQuery request = (CreateChannelQuery) object;
                        CreateChannelSQL createChannelSQL = new CreateChannelSQL();
                        createChannelSQL.createChannel(request.getUser());
                        System.out.println("Created Channel");
                    }else if(object instanceof SubscribeTo){

                    System.out.println("Channel Subscribe Request Recieved");
                    SubscribeTo request = (SubscribeTo) object;

                    SubscribeToChannelSQL subscribeToChannelSQL = new SubscribeToChannelSQL();
                    subscribeToChannelSQL.subscribechannel(request.getUser(), request.getChannel());

                    System.out.println("Subscribed Channel");
                }else if(object instanceof UnsubscribeTo){

                    System.out.println("Channel UnSubscribe Request Recieved");
                    UnsubscribeTo request = (UnsubscribeTo) object;

                    UnsubscribeToChannelSQL unsubscribeToChannelSQL = new UnsubscribeToChannelSQL();
                    unsubscribeToChannelSQL.unsubscribechannel(request.getUser(), request.getChannel());

                    System.out.println("Subscribed Channel");
                }
                    else {
                        System.out.println("Unknown Data recieved !");
                    }
                            /*
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
