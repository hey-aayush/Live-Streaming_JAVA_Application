package Client.ControllerFiles;
import Client.*;
import Server.Database.DatabaseConnection;
import Message.*;
import Server.MsgReply;
import Server.NewMsgReply;
import Server.SearchFriendReply;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.util.*;

public class ChatPageController implements Initializable {
    static String whosionchat;
    public String friend, user = "w";
    DatabaseConnection connection = DatabaseConnection.getInstance();
    Connection con = connection.getConnection();


    HashMap<String, String> hashMap = new HashMap<String, String>();
    //public static HashMap<String, Integer> frinedNewMsgs = new HashMap<String, Integer>();

   public static ObservableMap<String, Integer> frinedNewMsgs = FXCollections.observableHashMap();

    public static ObservableList<String> friendList = FXCollections.observableArrayList();

    //ListView for friends
    @FXML
    private ListView<String> friendListview;

    @FXML
    private TextArea msgtxtArea;
    @FXML
    private Button chosseBtn;

    @FXML
    private Button SendBtn;

    @FXML
    private TextArea textArea;
    @FXML
    private TextField search;

    ObjectOutputStream objectOutputStream = ClientThread.objectOutputStream;

    public void appendMessage(Message message) throws IOException{

        //msgListView.getItems().add(message + "\r\n");
        String u = message.getSendername();


        if(whosionchat != null && whosionchat.equals(message.getSendername().trim())){
            msgtxtArea.appendText("\n" + message);
            hashMap.replace(u, hashMap.get(u) + message);
            //ifAction(u);
            //frinedNewMsgs.put(u, frinedNewMsgs.get(u) + 1 );
            //friendListview.setItems(friendList);
           // friendListview.setCellFactory(param -> new Cell());
            SetSeenData setSeenData = new SetSeenData();
            setSeenData.setUserName(user);
            setSeenData.setFriendName(whosionchat);
            setSeenData.setMsgStatus(MsgStatus.SEEN);
            objectOutputStream.writeObject(setSeenData);
            objectOutputStream.flush();
            System.out.println("set seen send");
            System.out.println("phase1");



        }

        else if(!hashMap.containsKey(u)) {
            System.out.println("-----------");
            hashMap.put(u, message + "");
            friendList.add(0, u);
            friendListview.setItems(friendList);
            friendListview.setCellFactory(param -> new Cell());
            frinedNewMsgs.put(u, 1);
            friendListview.setItems(friendList);
            friendListview.setCellFactory(param -> new Cell());
            //ifAction(u);

        }
        else{
            System.out.println("phase3");
            hashMap.replace(u,hashMap.get(u)  + message);
            try {
                frinedNewMsgs.put(u, frinedNewMsgs.get(u) + 1);
            }catch (NullPointerException e){
                frinedNewMsgs.put(u, 1);
                e.printStackTrace();
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

    public void sendMessage(ActionEvent event) throws Exception{

        Message msg = new Message();
        msg.setSendername(user);
        msg.setReceiverName(friend);
        msg.setContent(textArea.getText());
        msg.setMsgStatus(MsgStatus.UNSEEN);
        objectOutputStream.writeObject(msg);
        objectOutputStream.flush();
        textArea.setText("");
        msgtxtArea.appendText(msg.getSendername() + "\n" + msg.getReceiverName() + "\n"+ msg.getContent() + "\n" + msg.getMsgStatus() +"\n");
        hashMap.replace(friend,hashMap.get(friend.trim()) + msg.getSendername() + "\n" + msg.getReceiverName() + "\n"+ msg.getContent() + "\n"
        +msg.getMsgStatus() + "\n");
        //ifAction(friend);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) throws NullPointerException{
       // friendList.clear();
        friendListview.getItems().clear();
        //Remove karna hai isse
        //friendListview.setItems(friendList);
        System.out.println("ye initalize wala hai");
       // friendListview.setCellFactory(param -> new Cell());
        FriendData friendData = new FriendData();
        friendData.setUserName(user);
        try {
            objectOutputStream.writeObject(friendData);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    public void openChats(MouseEvent mouseEvent) throws Exception{

        friend = friendListview.getSelectionModel().getSelectedItem().trim();
        whosionchat = friend;
        msgtxtArea.setText("");
        frinedNewMsgs.replace(friend, 0);

        SetSeenData setSeenData = new SetSeenData();
        setSeenData.setUserName(user);
        setSeenData.setFriendName(friend);
        setSeenData.setMsgStatus(MsgStatus.SEEN);
        objectOutputStream.writeObject(setSeenData);
        objectOutputStream.flush();
        System.out.println("set seen send");


        String getMsg = hashMap.get(friend);
        if(getMsg == null){
            System.out.println("database chala hai");
            MsgData msgData = new MsgData();
            msgData.setUserName(user);
            msgData.setFriendName(friend);
            objectOutputStream.writeObject(msgData);
            objectOutputStream.flush();
        }else {
               System.out.println("locally chala hai");
              msgtxtArea.setText(hashMap.get(friend));
        }

    }

    public void appendConversationReply(MsgReply msgReply) {
        msgtxtArea.setText(msgReply.getMsgs());
        hashMap.put(msgReply.getFriend(), msgReply.getMsgs());

    }


    public void appendNewMsgs(NewMsgReply newMsgReply) {
        System.out.println("new messages reached");
       for(int i=0; i<newMsgReply.getNewMsgList().size(); i++){
           String u = newMsgReply.getNewMsgList().get(i).getSendername();
           System.out.println(u);

           if(hashMap.containsKey(u)){
                frinedNewMsgs.replace(u, frinedNewMsgs.get(u) + 1);

           }
           else
           {
               frinedNewMsgs.put(u,1);
              /* hashMap.put(u,"");
               friendListview.getItems().add(0,u);
               friendListview.setCellFactory(param -> new Cell());
               frinedNewMsgs.replace(u, frinedNewMsgs.get(u) +1);*/
           }
          // ifAction(u);
       }
    }

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
                     s= frinedNewMsgs.get(name).toString();
                }
                label2.setText(s);
                setGraphic(hBox);
            }
        }

    }

}
