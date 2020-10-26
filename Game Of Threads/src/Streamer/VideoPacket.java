package Streamer;

import java.io.Serializable;

public class VideoPacket implements Serializable {

    private int seqNumber;
    private long timestamp;
    private byte[] data;

    public VideoPacket(byte[] data, int seqNumber, long timestamp){
        this.data = data;
        this.seqNumber = seqNumber;
        this.timestamp = timestamp;
    }

    public int getSeqNumber() {
        return seqNumber;
    }

    public byte[] getData(){
        return data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setSeqNumber(int seqNumber) {
        this.seqNumber = seqNumber;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
