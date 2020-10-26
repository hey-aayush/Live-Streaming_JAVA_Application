package Streamer;

import java.io.Serializable;

public class StreamRequest implements Serializable {

    private StreamingConstants command;
    String username;

    public StreamRequest(String username, StreamingConstants command) {
        this.username = username;
        this.command = command;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public StreamingConstants getCommand() {
        return command;
    }

    public void setCommand(StreamingConstants command) {
        this.command = command;
    }
}
