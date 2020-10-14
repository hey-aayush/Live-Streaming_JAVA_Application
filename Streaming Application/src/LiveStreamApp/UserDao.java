package LiveStreamApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
//ek bar access modifier check krna hai !!
public class UserDao {

    public static ObservableList<OtherUsers> getOtherUserObjects(ResultSet rsSet){
        try{
            ObservableList<OtherUsers> otheruserslist = FXCollections.observableArrayList();
            while (rsSet.next()){
                OtherUsers otherUser = new OtherUsers();
                //ek constructor m bna dena
                otherUser.setUserId(rsSet.getInt("account_id"));
                otherUser.setFirstName(rsSet.getString("firstname"));
                otherUser.setlastName(rsSet.getString("lastname"));
                otherUser.setUserName(rsSet.getString("username"));
                System.out.println(otherUser.getUserName());
                otheruserslist.add(otherUser);
            }
            return otheruserslist;
        }catch (Exception E){
            E.printStackTrace();
        }
        return null;
    }

}
