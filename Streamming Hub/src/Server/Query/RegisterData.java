package Server.Query;

import Server.EnumConstants.QueryCode;

import java.io.Serializable;

public class RegisterData extends Query implements Serializable {
    private static final long SerialVersionUID = 1006L;

private String FirstName;
private String LastName;
private String UserName;
private String Password;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public QueryCode getQueryCode() {
        return QueryCode.REGISTER_DATA;
    }


}
