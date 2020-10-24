package ControllerFiles;
import Client.*;
import Database.DatabaseConnection;
import Message.*;
import Server.MsgReply;
import Server.NewMsgReply;
import Server.SearchFriendReply;
import User.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class ChatPageController implements Initializable {
    static String whosionchat;
    public String friend, user = new BaseStageController().getUser().getUserName();
    DatabaseConnection connection = DatabaseConnection.getInstance();
    Connection con = connection.getConnection();

    ArrayList<String> fList = new ArrayList<String>();
    HashMap<String, String> hashMap = new HashMap<String, String>();
    HashMap<String, Integer> frinedNewMsgs = new HashMap<String, Integer>();

    ObservableList<String> friendList = FXCollections.observableArrayList();

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

    ObjectOutputStream objectOutputStream = Client.objectOutputStream;

    public void appendMessage(Message message) throws IOException{

        //msgListView.getItems().add(message + "\r\n");
        String u = message.getSendername();
        hashMap.replace(u,hashMap.get(u) + "\n" + message);
        ifAction(u);
        if(whosionchat == message.getSendername())
           msgtxtArea.appendText("\n" + message);
        else if(!hashMap.containsKey(u)) {
            hashMap.put(u, "");
            friendListview.getItems().add(0, u);
            frinedNewMsgs.put(u, frinedNewMsgs.get(u) + 1);
        }
        else{
                frinedNewMsgs.put(u, frinedNewMsgs.get(u) + 1 );
            }
        System.out.println(message);

    }

    public void ifAction(String friend){
        int move = friendList.indexOf(friend);
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
        ifAction(friend);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) throws NullPointerException{
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openChats(MouseEvent mouseEvent) throws Exception{

        friend = friendListview.getSelectionModel().getSelectedItem();
        whosionchat = friend;


                msgtxtArea.setText("");

        String getMsg = hashMap.get(friend);
        if(getMsg == null){
            MsgData msgData = new MsgData();
            msgData.setUserName(user);
            msgData.setFriendName(friend);
            objectOutputStream.writeObject(msgData);
            objectOutputStream.flush();
        }else {
              msgtxtArea.setText(hashMap.get(friend));
        }

    }

    public void appendConversationReply(MsgReply msgReply) {
        msgtxtArea.setText(msgReply.getMsgs());
    }


    public void appendNewMsgs(NewMsgReply newMsgReply) {
       for(int i=0; i<newMsgReply.getNewMsgList().size(); i++){
           String u = newMsgReply.getNewMsgList().get(i).getSendername();
           if(hashMap.containsKey(u)){
               frinedNewMsgs.replace(u, frinedNewMsgs.get(u) + 1);
           }
           else
           {
               hashMap.put(u,"");
               friendListview.getItems().add(0,u);
               frinedNewMsgs.replace(u, frinedNewMsgs.get(u) +1);
           }
           ifAction(u);
       }
    }

    public void appendFriendList(SearchFriendReply sfr) {
        for(int i=0; i<sfr.getFriendList().size(); i++){
            friendList.add(sfr.getFriendList().get(i));
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
                System.out.println(name +  "===----");
                label.setText(name+ " ");
                label2.setText(new ChatPageController().frinedNewMsgs.get(name) + "");
                setGraphic(hBox);
            }
        }
    }
}
