package Response;

import Application.HomeUser;

public class HomeUserResponse {

    private String usernameQuery;

    private HomeUser homeUser;

    public void setUsernameQuery(String usernameQuery) {
        this.usernameQuery = usernameQuery;
    }

    public HomeUser getHomeUser() {
        return homeUser;
    }

    public void setHomeUser(HomeUser homeUser) {
        this.homeUser = homeUser;
    }

    public String getUsernameQuery() {
        return usernameQuery;
    }
}
