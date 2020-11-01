package Query;

import User.*;

import java.io.Serializable;

public class UnsubscribeTo implements Serializable {
    private User user;
    private Channel channel;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public void setRequest(User user , Channel channel){
        setChannel(channel);
        setUser(user);
    }

}
