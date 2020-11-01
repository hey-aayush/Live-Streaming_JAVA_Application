package ControllerFiles;

import ClientThread.Client;
import EnumConstants.MsgStatus;
import Query.*;
import Response.MsgReply;
import Response.NewMsgReply;
import Response.SearchFriendReply;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

/*  I am fetching the chats of a particular persone from database on
    first time of clicking and stroing it in hashMap and then
    the new chats are added in it by receiving messages through
    socket.
 */


public class ChatPageController implements Initializable {
    //Variable for checking which frined chat session is currently open
    static String whosionchat;
    //Getting the name of selected friend our userName
    public String friend, user = LoginController.myUserName;

    //hashmap to store chats after opening first time and fetching from database
    HashMap<String, String> hashMap = new HashMap<String, String>();

    //ObservableMap to store number of new Messages from a particular friend
    public static ObservableMap<String, Integer> frinedNewMsgs = FXCollections.observableHashMap();

    //ObservableList of frined from who we have done chat
    public static ObservableList<String> friendList = FXCollections.observableArrayList();

    //ListView for friends
    @FXML
    private ListView<String> friendListview;
    //TextArea for showing messages
    @FXML
    private TextArea msgtxtArea;

    @FXML
    private Button chosseBtn;

    @FXML
    private Button SendBtn;
    //TextArea for writing messages
    @FXML
    private TextArea textArea;

    ObjectOutputStream objectOutputStream = Client.objectOutputStream;

    //Method to append message received from Server
    public void appendMessage(Message message) throws IOException{

        //msgListView.getItems().add(message + "\r\n");
        String u = message.getSendername().trim();
        /* If ther persone is on chat and that person message came then show it on
            msgTextArea and add it in hashMap */
        if(whosionchat != null && whosionchat.equals(message.getSendername().trim())){
            msgtxtArea.appendText("\n" + message);
            hashMap.replace(u, hashMap.get(u) + message);
            SetSeenData setSeenData = new SetSeenData();
            setSeenData.setUserName(user);
            setSeenData.setFriendName(whosionchat);
            setSeenData.setMsgStatus(MsgStatus.SEEN);
            objectOutputStream.writeObject(setSeenData);
            objectOutputStream.flush();
            System.out.println("set seen send");
            System.out.println("phase1");

        }
        /* If the person is not in friendList before then put the message in hashMap
            and increase the number of new messages by 1*/
        else if(!hashMap.containsKey(u) && !friendList.contains(u)) {
            System.out.println("-----------");
            //loadMsg(u);
            hashMap.put(u,"");
            System.out.println("0099" + hashMap.get(u));
            hashMap.replace(u,message.toString());
            System.out.println("0----0" + hashMap.get(u));
            friendList.add(0, u);
            friendListview.setItems(friendList);
            friendListview.setCellFactory(param -> new Cell());
            frinedNewMsgs.put(u, 1);
            friendListview.setItems(friendList);
            friendListview.setCellFactory(param -> new Cell());
            //ifAction(u);
        }
        //If peroson is available in friendList but its old chats are not
        //loaded locally so firstly load its all old chats and put it
        //into hashmap and also this new message and also increase the
        //number of new Messages in frindNewMessages observableMap
        else if(!hashMap.containsKey(u) && friendList.contains(u)){
            System.out.println("new case:");
            loadMsg(u);
            System.out.println(hashMap.get(u));
            hashMap.replace(u, hashMap.get(u) + message.toString());
            frinedNewMsgs.put(u, 1);
            friendListview.setItems(friendList);
            friendListview.setCellFactory(param -> new Cell());
            System.out.println("new case run successfully");


        }
        /*If it is not available on currently chat but its old chat
          are once loaded earlier*/
        else{
            System.out.println("phase3");
            hashMap.replace(u,hashMap.get(u)  + message);
            try {
                frinedNewMsgs.put(u, frinedNewMsgs.get(u) + 1);
            }catch (NullPointerException e){
                frinedNewMsgs.put(u, 1);
                e.printStackTrace();
                System.out.println("Phase 3 running");
            }
            //ifAction(u);
            // frinedNewMsgs.put(u, frinedNewMsgs.get(u) + 1);
            friendListview.setItems(friendList);
            friendListview.setCellFactory(param -> new Cell());
            System.out.println("phase 4");

        }
        System.out.println(message);

    }

    public void ifAction(String friend){
        int move = friendList.indexOf(friend);
        if(move>0 && move<friendList.size())
            friendList.remove(move);
        friendList.add(0,friend);
    }
    //Function for sending the message
    public void sendMessage(ActionEvent event) throws Exception{

        Message msg = new Message();
        msg.setSendername(user);
        msg.setReceiverName(friend);
        msg.setContent(textArea.getText());
        msg.setMsgStatus(MsgStatus.UNSEEN);
        objectOutputStream.writeObject(msg);
        objectOutputStream.flush();
        System.out.println("message send");
        textArea.setText("");
        msgtxtArea.appendText(msg.getSendername() + "\n" + msg.getReceiverName() + "\n"+ msg.getContent() + "\n" + msg.getMsgStatus() +"\n");
        hashMap.replace(friend,hashMap.get(friend.trim()) + msg.getSendername() + "\n" + msg.getReceiverName() + "\n"+ msg.getContent() + "\n"
                +msg.getMsgStatus() + "\n");

        //ifAction(friend);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) throws NullPointerException{
        System.out.println("user: " + user);
        //Firsly I will clear the friendListView
        friendListview.getItems().clear();
        System.out.println("ye initalize wala hai");
        //Loading the new friendList
        FriendData friendData = new FriendData();
        friendData.setUserName(user);
        try {
            objectOutputStream.writeObject(friendData);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //On opening, requesting for the number of New messages
        NewMsgData newMsgData = new NewMsgData();
        newMsgData.setFriendName(user);
        newMsgData.setMsgStatus(MsgStatus.UNSEEN);
        try {
            objectOutputStream.writeObject(newMsgData);
            objectOutputStream.flush();
            System.out.println("new message on demand");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //For opening the chats of a particular friend
    public void openChats(MouseEvent mouseEvent) throws Exception{

        friend = friendListview.getSelectionModel().getSelectedItem().trim();
        //on slecting any friend set the friend as whosisonchat
        whosionchat = friend;
        msgtxtArea.setText("");
        frinedNewMsgs.replace(friend, 0);

        //Setting all the messages seen which came by our friend
        SetSeenData setSeenData = new SetSeenData();
        setSeenData.setUserName(user);
        setSeenData.setFriendName(friend);
        setSeenData.setMsgStatus(MsgStatus.SEEN);
        objectOutputStream.writeObject(setSeenData);
        objectOutputStream.flush();
        System.out.println("set seen send");
        //loading the chats
        loadMsg(friend);



    }
    //Function for loading the chats of a particular friend
    public void loadMsg(String friends) throws IOException {
        String getMsg =  hashMap.get(friends);
        System.out.println("LoadMsg:" + getMsg);
        //If chats are not locally available
        if(getMsg == null){
            System.out.println("database chala hai");
            MsgData msgData = new MsgData();
            msgData.setUserName(user);
            msgData.setFriendName(friends);
            objectOutputStream.writeObject(msgData);
            objectOutputStream.flush();
            //If chats are locally available
        }else {
            System.out.println("locally chala hai");
            msgtxtArea.setText(hashMap.get(friends));
        }
    }
    //Function for printing the message in textArea
    public void appendConversationReply(MsgReply msgReply) {
        msgtxtArea.setText(msgReply.getMsgs());
        hashMap.put(msgReply.getFriend(), msgReply.getMsgs());

    }
    /*Functionf for counting the no. of new messages came of each friend and
      put in the friendNewMsgs hashMap and show beside of their name
     */
    public void appendNewMsgs(NewMsgReply newMsgReply) {
        System.out.println("new messages reached");
        for(int i=0; i<newMsgReply.getNewMsgList().size(); i++){
            String u = newMsgReply.getNewMsgList().get(i).getSendername();
            System.out.println(u);

            // If hashMap contains user earlier
            if(hashMap.containsKey(u)){
                frinedNewMsgs.replace(u, frinedNewMsgs.get(u) + 1);
            }
            else
            { frinedNewMsgs.put(u,1);
              /* hashMap.put(u,"");
               friendListview.getItems().add(0,u);
               friendListview.setCellFactory(param -> new Cell());
               frinedNewMsgs.replace(u, frinedNewMsgs.get(u) +1);*/
            }
            // ifAction(u);
        }
    }
    //Function for printing the friend list in listView
    public void appendFriendList(SearchFriendReply sfr) {
        System.out.println("friendlist aa gayi");
        if(friendList.size() == 0){
            for(int i=0; i<sfr.getFriendList().size(); i++){
                friendList.add(sfr.getFriendList().get(i));
                System.out.println(2);
            }
        }
        friendListview.setItems(friendList);
        friendListview.setCellFactory(param -> new Cell());
    }
    //For customised listview we are adding a particular cell in an item of a listView
    static class Cell extends ListCell<String> {
        HBox hBox= new HBox();
        Label label = new Label();
        Label label2 = new Label();


        public Cell(){
            super();
            hBox.getChildren().addAll(label,label2 );
        }
        public void updateItem(String name, boolean empty){
            super.updateItem(name, empty);
            setText(null);
            setGraphic(null);

            if(name != null && !empty){
                //System.out.println(name +  "===----");
                label.setText(name+ " ");
                String s = "";

                if(frinedNewMsgs.containsKey(name)){
                    if(frinedNewMsgs.get(name) ==  0)
                        s="";
                    else
                        s= frinedNewMsgs.get(name).toString();
                }
                label2.setText(s);
                label2.setTextFill(Color.RED);
                setGraphic(hBox);
            }
        }

    }

}