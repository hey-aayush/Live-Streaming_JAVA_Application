package Query;

import User.User;

import java.io.Serializable;

public class CreateChannelQuery implements Serializable {
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
