package Streamer;

import java.io.Serializable;

/**
 * Streaming Address
 * 1. Contains video and audio port
 * 2. Contains multicast ip address
 * 3. Address use
 */

public class StreamingAddress implements Serializable {

    String address;
    private int videoPort;
    private int audioPort;
    private StreamingConstants addressUse;

    public StreamingAddress(String address, int videoPort, int audioPort, StreamingConstants addressUse) {
        this.address = address;
        this.videoPort = videoPort;
        this.addressUse = addressUse;
        this.audioPort = audioPort;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getVideoPort() {
        return videoPort;
    }

    public void setVideoPort(int videoPort) {
        this.videoPort = videoPort;
    }

    public int getAudioPort() {
        return audioPort;
    }

    public void setAudioPort(int audioPort) {
        this.audioPort = audioPort;
    }

    public StreamingConstants getAddressUse() {
        return addressUse;
    }

    public void setAddressUse(StreamingConstants addressUse) {
        this.addressUse = addressUse;
    }
}
