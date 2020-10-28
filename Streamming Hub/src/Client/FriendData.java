package Client;

import java.io.Serializable;

public class FriendData implements Serializable {
    String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
