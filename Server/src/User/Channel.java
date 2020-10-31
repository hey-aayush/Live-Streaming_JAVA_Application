package User;

import java.io.Serializable;

public class Channel implements Serializable {
    private int channelId;
    private String channelName;
    private String content;
    private int noSubscribers;
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


    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getNoSubscribers() {
        return noSubscribers;
    }

    public void setNoSubscribers(int noSubscribers) {
        this.noSubscribers = noSubscribers;
    }
}
