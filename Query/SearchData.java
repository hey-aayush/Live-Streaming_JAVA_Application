package Query;

import EnumConstants.QueryCode;

import java.io.Serializable;

public class SearchData extends Query implements Serializable {
    private static final long SerialVersionUID = 1008L;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public QueryCode getQueryCode() {
        return QueryCode.SEARCH_DATA;
    }


}
