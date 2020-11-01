package Query;

import java.io.Serializable;

public class ProfileData implements Serializable {
    private static final long SerialVersionUID = 1011L;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
