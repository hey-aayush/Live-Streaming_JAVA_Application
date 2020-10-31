package Response;

import java.io.Serializable;

public class ServerTimeReply implements Serializable {
    private long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}