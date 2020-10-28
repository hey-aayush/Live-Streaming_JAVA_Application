package Server;

import java.io.Serializable;

public class TFReply implements Serializable {
    transient static TFReply singleTFReply = null;

    private TFReply(){}

    public static TFReply getInstance(){
        if(singleTFReply == null)
            singleTFReply = new TFReply();
        return singleTFReply;
    }
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
