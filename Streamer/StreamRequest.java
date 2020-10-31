package Query;

import Streamer.StreamingConstants;
import java.io.Serializable;

public class StreamRequest implements Serializable {

    private StreamingConstants command;
    private int channelID;

    public StreamRequest(int channelID, StreamingConstants command) {
        this.channelID = channelID;
        this.command = command;
    }

    public int getChannelID() {
        return channelID;
    }

    public void setChannelID(int channelID) {
        this.channelID = channelID;
    }

    public StreamingConstants getCommand() {
        return command;
    }

    public void setCommand(StreamingConstants command) {
        this.command = command;
    }
}