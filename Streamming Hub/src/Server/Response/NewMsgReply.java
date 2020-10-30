package Server.Response;

import Message.Message;

import java.io.Serializable;
import java.util.Vector;

public class NewMsgReply implements Serializable {
    private static final long SerialVersionUID = 5L;
    public Vector<Message> getNewMsgList() {
        return newMsgList;
    }

    public void setNewMsgList(Vector<Message> newMsgList) {
        this.newMsgList = newMsgList;
    }

    private Vector<Message> newMsgList;
}
