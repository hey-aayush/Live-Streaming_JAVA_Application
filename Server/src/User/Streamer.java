package User;

import java.io.Serializable;

public class Streamer extends User implements Serializable {
    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
