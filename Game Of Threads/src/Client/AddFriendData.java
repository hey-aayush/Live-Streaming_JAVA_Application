package Client;

import java.io.Serializable;

public class AddFriendData implements Serializable {
    private String userName;
    private String friendName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }
}
