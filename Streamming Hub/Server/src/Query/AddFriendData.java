package Query;

import EnumConstants.QueryCode;

import java.io.Serializable;

public class AddFriendData extends Query implements Serializable {
    private static final long SerialVersionUID = 1001L;
    private String userName;
    private String friendName;

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

    @Override
    public QueryCode getQueryCode() {
        return QueryCode.ADD_FRIEND_DATA;
    }


}
