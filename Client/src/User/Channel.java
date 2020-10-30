package User;

public class Channel {
    private String channelName;
    private String content;
    private String subscribers;
    private double rating;
    private int numberOfLiveStreams;


    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(String subscribers) {
        this.subscribers = subscribers;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumberOfLiveStreams() {
        return numberOfLiveStreams;
    }

    public void setNumberOfLiveStreams(int numberOfLiveStreams) {
        this.numberOfLiveStreams = numberOfLiveStreams;
    }


}
