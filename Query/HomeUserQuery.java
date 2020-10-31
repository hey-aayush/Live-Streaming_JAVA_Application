package Query;

import EnumConstants.QueryCode;

import java.io.Serializable;

public class HomeUserQuery extends Query implements Serializable {

    private static final long SerialVersionUID = 1010L;

    private String userName;

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return this.userName;
    }

    public HomeUserQuery(String userName){
        setUserName(userName);
    }

    @Override
    public QueryCode getQueryCode() {
        return QueryCode.HOMEUSER_DATA;
    }
}
