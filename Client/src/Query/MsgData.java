package Query;


import EnumConstants.QueryCode;

import java.io.Serializable;

public class MsgData extends Query implements Serializable {
    private static final long SerialVersionUID = 1004L;
    private String friendName;
    private String userName;

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public QueryCode getQueryCode() {
        return QueryCode.LOGIN_DATA;
    }
}
