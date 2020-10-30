package User;

import java.io.Serializable;

public class User implements Serializable {
    private static final long SerialVersionUID = 2001L;

    //Value of x,y relative to Scene required to drag window
    private double xOffset = 0;
    private double yOffset = 0;

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private UserStatus userStatus;
    private Long lastActiveTime;
    private int userId;

    public Long getLastActiveTime() {
        return lastActiveTime;
    }

    public void setLastActiveTime(Long lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public User(){}

    public User(String userName,String firstName,String lastName,String email,UserStatus userStatus,Long lastActiveTime){

        setFirstName(firstName);
        setLastName(lastName);
        setUserName(userName);
        setEmail(email);
        setLastActiveTime(lastActiveTime);
        setUserStatus(userStatus);

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
