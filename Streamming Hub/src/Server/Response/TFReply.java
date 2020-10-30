package Server.Response;

import java.io.Serializable;

public class TFReply implements Serializable {
    private static final long SerialVersionUID = 1L;
    transient static TFReply singleTFReply = null;


    public boolean getReply() {
        return reply;
    }

    public void setReply(boolean reply) {
        this.reply = reply;
    }

    private boolean reply;
    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
