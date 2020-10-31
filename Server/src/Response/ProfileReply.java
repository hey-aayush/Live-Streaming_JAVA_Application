package Response;

import User.*;

import java.io.Serializable;

public class ProfileReply implements Serializable {

    private static final long SerialVersionUID = 2000L;
    private Streamer user;

    public long getServerCurrTime() {
        return serverCurrTime;
    }

    public void setServerCurrTime(long serverCurrTime) {
        this.serverCurrTime = serverCurrTime;
    }

    private long serverCurrTime;


    public User getUser() {
        return user;
    }

    public void setUser(Streamer user) {
        this.user = user;
    }
}
