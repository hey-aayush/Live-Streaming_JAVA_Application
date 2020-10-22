
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ClientGuiController implements Initializable {
    public String friend, user = "aayush";
    public DatabaseConnection connection = new DatabaseConnection();
    Connection con = connection.getConnection();

    ArrayList<String> fList = new ArrayList<String>();

    ObservableList<String>  list = FXCollections.observableArrayList("saurabh", "alok", "aayush");
    @FXML
            private ListView<String> friendListview;

    ObjectOutputStream objectOutputStream = Client.objectOutputStream;

    public void appendMessage(Message message) throws IOException{

        msgListView.getItems().add(message + "\r\n");
        System.out.println(message);

    }

    @FXML
    private ListView msgListView;

    @FXML
    private Button chosseBtn;

    @FXML
    private Button SendBtn;

    @FXML
    private TextArea textArea;
    @FXML
    private TextField search;


    public void sendMessage(ActionEvent event) throws Exception{
        String sName = user;
        String rName = friend;

        Message msg = new Message();
        msg.setSendername(sName);
        msg.setReceiverName(rName);
        msg.setContent(textArea.getText());
        msg.setStatus(0);
        msgListView.getItems().add("\t\t" + msg + "\r\n");
        textArea.setText("");
        objectOutputStream.writeObject(msg);
        objectOutputStream.flush();

    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) throws NullPointerException{
       // msgListView.getItems().add(new Message());
        friendListview.setItems(list);
        fList.add("alok");
        fList.add("saurabh");
        fList.add("aayush");
        search.setText("aayush");
    }

    public void openChats(MouseEvent mouseEvent) throws Exception{
        System.out.println(friendListview.getSelectionModel().getSelectedItem());
        friend = friendListview.getSelectionModel().getSelectedItem();
        msgListView.getItems().clear();
        PreparedStatement st = con.prepareStatement("select ConversationId from conversation where UserName = ?" +
                "AND FriendName = ? OR UserName = ? and FriendName = ?");
        System.out.println("send to client");
        st.setString(1,user);
        st.setString(2, friend);
        st.setString(4,user);
        st.setString(3, friend);
        System.out.println("Phase1");
        ResultSet rs = st.executeQuery();
        System.out.println("Phase2");
        System.out.println("Phase3");
        int cId=0;
        while (rs.next())
            cId = rs.getInt("ConversationId");
        st.close();
        String query = "select * from messages where ConversationId = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, cId);
        ResultSet r = statement.executeQuery();
        while(r.next()){
            Message msg = new Message();
            msg.setSendername(r.getString("UserName"));
            msg.setReceiverName(r.getString("FriendName"));
            msg.setContent(r.getString("MsgContent"));
            msg.setStatus(r.getInt("MsgStatus"));
            msgListView.getItems().add(msg);
        }



    }
}
