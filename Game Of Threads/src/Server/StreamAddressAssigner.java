package Server;

import Streamer.StreamingAddress;
import Streamer.StreamingConstants;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class StreamAddressAssigner {

    private String inetAddress;
    private int port;

    public StreamAddressAssigner() throws UnknownHostException {
        this.inetAddress = ("224.0.0.1");
        port = 1234;
    }

    public StreamingAddress getStreamingAddress(){
        port++;
        return new StreamingAddress(inetAddress, port, StreamingConstants.FOR_STREAMING);
    }
}
