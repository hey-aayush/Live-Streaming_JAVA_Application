package Server;

import java.io.Serializable;
import java.util.Vector;

public class SearchFriendReply implements Serializable {
    private Vector<String> friendList;

    public Vector<String> getFriendList() {
        return friendList;
    }

    public void setFriendList(Vector<String> friendList) {
        this.friendList = friendList;
    }
}
