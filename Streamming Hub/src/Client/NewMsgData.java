package Client;

import Message.MsgStatus;

import java.io.Serializable;

public class NewMsgData implements Serializable {
    private String friendName;
    private MsgStatus msgStatus;

    public MsgStatus getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(MsgStatus msgStatus) {
        this.msgStatus = msgStatus;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }
}
