package Server;

import java.io.Serializable;

public class MsgReply implements Serializable {
    private String msgs;

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    private String friend;

    public String getMsgs() {
        return msgs;
    }

    public void setMsgs(String msgs) {
        this.msgs = msgs;
    }
}
