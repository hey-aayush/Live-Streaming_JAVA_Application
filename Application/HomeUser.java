package Application;

import javafx.collections.ObservableList;

public class HomeUser {
    private static int homeUserId;
    private static String homeUsername;
    private static String homeFirstname;
    private static String homeLastname;
    private static String homUserEmail;
    private static boolean isStreammer;
    private static int channelId;
    private static ObservableList<OtherChannels> SubscribedChannelList;

    public static int getHomeUserId() {
        return homeUserId;
    }

    public static void setHomeUserId(int homeUserId) {
        HomeUser.homeUserId = homeUserId;
    }

    public static String getHomeUsername() {
        return homeUsername;
    }

    public static void setHomeUsername(String homeUsername) {
        HomeUser.homeUsername = homeUsername;
    }

    public static String getHomeLastname() {
        return homeLastname;
    }

    public static void setHomeLastname(String homeLastname) {
        HomeUser.homeLastname = homeLastname;
    }

    public static String getHomUserEmail() {
        return homUserEmail;
    }

    public static void setHomUserEmail(String homUserEmail) {
        HomeUser.homUserEmail = homUserEmail;
    }

    public static boolean isIsStreammer() {
        return isStreammer;
    }

    public static void setIsStreammer(boolean isStreammer) {
        HomeUser.isStreammer = isStreammer;
    }

    public static int getChannelId() {
        return channelId;
    }

    public static void setChannelId(int channelId) {
        HomeUser.channelId = channelId;
    }

    public static ObservableList<OtherChannels> getSubscribedChannelList() {
        return SubscribedChannelList;
    }

    public static void setSubscribedChannelList(ObservableList<OtherChannels> subscribedChannelList) {
        SubscribedChannelList = subscribedChannelList;
    }
}
