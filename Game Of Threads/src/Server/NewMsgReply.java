package Server;

import Message.Message;

import java.io.Serializable;
import java.util.Vector;

public class NewMsgReply implements Serializable {
    public Vector<Message> getNewMsgList() {
        return newMsgList;
    }

    public void setNewMsgList(Vector<Message> newMsgList) {
        this.newMsgList = newMsgList;
    }

    private Vector<Message> newMsgList;
}
