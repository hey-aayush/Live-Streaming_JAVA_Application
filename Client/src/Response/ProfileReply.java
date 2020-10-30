package Response;

import User.User;

import java.io.Serializable;

public class ProfileReply implements Serializable {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
