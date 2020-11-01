package Query;

import Streamer.StreamingAddress;

public class DeleteRoomRequest {

    private StreamingAddress streamingAddress;
    private int channelID;

    public DeleteRoomRequest(int channelID, StreamingAddress streamingAddress) {
        this.streamingAddress = streamingAddress;
        this.channelID = channelID;
    }

    public StreamingAddress getStreamingAddress() {
        return streamingAddress;
    }

    public void setStreamingAddress(StreamingAddress streamingAddress) {
        this.streamingAddress = streamingAddress;
    }

    public int getChannelID() {
        return channelID;
    }

    public void setChannelID(int channelID) {
        this.channelID = channelID;
    }
}
