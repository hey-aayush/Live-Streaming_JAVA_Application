package Server;

import java.io.Serializable;

public class MsgReply implements Serializable {
    private String msgs;

    public String getMsgs() {
        return msgs;
    }

    public void setMsgs(String msgs) {
        this.msgs = msgs;
    }
}
