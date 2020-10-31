package Response;

import User.*;

import java.io.Serializable;

public class ProfileReply implements Serializable {

    private static final long SerialVersionUID = 2000L;
    private Streamer user;



    public User getUser() {
        return user;
    }

    public void setUser(Streamer user) {
        this.user = user;
    }
}
