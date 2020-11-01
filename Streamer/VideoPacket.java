package Streamer;

import java.io.Serializable;

/**
 * Class for video packets
 * 1. Contains current frame sequence number
 * 2. Video data
 */

public class VideoPacket implements Serializable {

    private int seqNumber;
    private long timestamp;
    private byte[] data;
    private boolean isEncoded;

    public VideoPacket(byte[] data, int seqNumber, long timestamp){
        this.data = data;
        this.seqNumber = seqNumber;
        this.timestamp = timestamp;
        this.isEncoded = false;
    }

    public boolean isEncoded() {
        return isEncoded;
    }

    public void setEncoded(boolean encoded) {
        isEncoded = encoded;
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
