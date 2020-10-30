package Server.Query;

import Server.EnumConstants.QueryCode;
import Message.MsgStatus;

import java.io.Serializable;

public class NewMsgData extends Query implements Serializable {
    private static final long SerialVersionUID = 1005L;
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

    @Override
    public QueryCode getQueryCode() {
        return QueryCode.NEW_MSG_DATA;
    }

}
