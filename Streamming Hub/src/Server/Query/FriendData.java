package Server.Query;

import Server.EnumConstants.QueryCode;

import java.io.Serializable;

public class FriendData extends Query implements Serializable {
    private static final long SerialVersionUID = 1002L;
    String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public QueryCode getQueryCode() {
        return QueryCode.FRIEND_DATA;
    }
}
