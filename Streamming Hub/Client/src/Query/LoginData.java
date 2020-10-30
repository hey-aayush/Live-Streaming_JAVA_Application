package Query;



import EnumConstants.QueryCode;

import java.io.Serializable;

public class LoginData extends Query implements Serializable {
    private static final long SerialVersionUID = 1003L;
    private String userName;
    private String password;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public QueryCode getQueryCode() {
        return QueryCode.LOGIN_DATA;
    }
}
