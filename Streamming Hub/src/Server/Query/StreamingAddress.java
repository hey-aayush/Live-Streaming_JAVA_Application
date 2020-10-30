package Server.Query;

import Server.EnumConstants.QueryCode;
import Streaming.StreamingConstants;

import java.io.Serializable;

public class StreamingAddress extends Query implements Serializable {

    String address;
    private int port;
    private StreamingConstants addressUse;

    public StreamingAddress(String address, int port, StreamingConstants addressUse) {
        this.address = address;
        this.port = port;
        this.addressUse = addressUse;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public StreamingConstants getAddressUse() {
        return addressUse;
    }

    public void setAddressUse(StreamingConstants addressUse) {
        this.addressUse = addressUse;
    }


    @Override
    public QueryCode getQueryCode() {
        return QueryCode.STREAMING_ADDRESS;
    }
}
