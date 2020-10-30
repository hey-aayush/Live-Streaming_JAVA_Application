package Client.Query;

import Client.EnumConstants.QueryCode;
import Message.MsgStatus;

import java.io.Serializable;

public class SetSeenData extends Query implements Serializable {
    private static final long SerialVersionUID = 1009L;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    private String userName, friendName;
    private MsgStatus msgStatus;

    public MsgStatus getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(MsgStatus msgStatus) {
        this.msgStatus = msgStatus;
    }

    @Override
    public QueryCode getQueryCode() {
        return QueryCode.SET_SEEN_DATA;
    }
}
