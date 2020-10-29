package Application;

import java.io.Serializable;

public class OtherChannels implements Serializable {
    private int ChannelId;
    private String channelName;
    private int noSubscribers;
    //Add Status Fields in OtherChannel

    public int getNoSubscribers() {
        return noSubscribers;
    }

    public void setNoSubscribers(int noSubscribers) {
        this.noSubscribers = noSubscribers;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public int getChannelId() {
        return ChannelId;
    }

    public void setChannelId(int channelId) {
        ChannelId = channelId;
    }

    public OtherChannels(int channelId,String channelName,int noSubcribers){
        this.setChannelName(channelName);
        this.setChannelId(channelId);
        this.setNoSubscribers(noSubcribers);
    }
}