package Streamer;

import java.io.Serializable;

/**
 * Class responsible for carrying audio data and related information
 * 1. Timestamp
 * 2. Audio data bytes
 */

public class AudioPacket implements Serializable {

    private long timestamp;
    private byte[] data;

    public AudioPacket(byte []data, long timestamp){
        this.data = data;
        this.timestamp = timestamp;
    }

    public long getTimestamp(){
        return timestamp;
    }

    public byte[] getData(){
        return data;
    }

    public void setTimestamp(long timestamp){
        this.timestamp = timestamp;
    }

    public void setData(byte[] data){
        this.data = data;
    }
}
