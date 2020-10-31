package Application;

public class HomeStreammer extends HomeUser {
    private static int ChannelId;
    private static String channelName;
    private static int noSubscribers;
    private static String[] tags;

    public static int getChannelId() {
        return ChannelId;
    }

    public static void setChannelId(int channelId) {
        ChannelId = channelId;
    }

    public static String getChannelName() {
        return channelName;
    }

    public static void setChannelName(String channelName) {
        HomeStreammer.channelName = channelName;
    }

    public static int getNoSubscribers() {
        return noSubscribers;
    }

    public static void setNoSubscribers(int noSubscribers) {
        HomeStreammer.noSubscribers = noSubscribers;
    }

    public static String[] getTags() {
        return tags;
    }

    public static void setTags(String[] tags) {
        HomeStreammer.tags = tags;
    }
}
