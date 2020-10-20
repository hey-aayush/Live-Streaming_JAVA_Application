package Server;

import java.io.Serializable;

public class TFReply implements Serializable {
    public boolean getReply() {
        return reply;
    }

    public void setReply(boolean reply) {
        this.reply = reply;
    }

    private boolean reply;
}
