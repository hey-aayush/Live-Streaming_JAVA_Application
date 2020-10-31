package Streamer;

import Query.StreamRequest;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class StreamingRoomManager {

    private final String address;
    private final Queue<Integer> availablePorts;
    private final Map<Integer, StreamingAddress> activeRooms;

    public StreamingRoomManager() {

        activeRooms = new HashMap<Integer, StreamingAddress>();
        this.address = ("224.0.0.1");
        availablePorts = new LinkedList<>();
        for(int i=1025;i<2026;i++){
            availablePorts.add(i);
        }
    }

    public StreamingAddress getStreamingAddress(StreamRequest streamRequest){
       if(streamRequest.getCommand()==StreamingConstants.REQUEST_STREAMING_ROOM){
           return generateNewStreamingRoomAddress(streamRequest);
       }
       else if(streamRequest.getCommand() == StreamingConstants.REQUEST_JOIN_GROUP){
           return getRunningStreamingRoomAddress(streamRequest);
       }
       return null;
    }

    private StreamingAddress getRunningStreamingRoomAddress(StreamRequest streamRequest) {

        System.out.println("In RunningStreamingRoomManager: channelID: " + streamRequest.getChannelID());

        if(activeRooms.containsKey(streamRequest.getChannelID())){
            StreamingAddress streamingAddress = activeRooms.get(streamRequest.getChannelID());
            streamingAddress.setAddressUse(StreamingConstants.FOR_JOINING);

            System.out.println("Running address for: " + streamingAddress.getAddressUse());
            return streamingAddress;
        }
        return null;
    }

    private StreamingAddress generateNewStreamingRoomAddress(StreamRequest streamRequest){
        int videoPort = getPort();
        int audioPort = getPort();

        if(videoPort==0 || audioPort==0) {
            return null;
        }

        StreamingAddress streamingAddress = new StreamingAddress(address, videoPort, audioPort, StreamingConstants.FOR_STREAMING);
        activeRooms.put(streamRequest.getChannelID(), streamingAddress);
        return streamingAddress;
    }

    private int getPort(){

        if(availablePorts.isEmpty()) {
            return 0;
        }

        int port = availablePorts.peek();
        availablePorts.remove();
        return port;
    }

}
