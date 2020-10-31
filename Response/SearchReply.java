package Response;

import User.*;

import java.io.Serializable;
import java.util.Vector;

public class SearchReply implements Serializable {

    private static final long SerialVersionUID = 2L;
    private Vector<User> vector;

    public Vector<User> getVector() {
        return vector;
    }

    public void setVector(Vector<User> vector) {
        this.vector = vector;
    }
}
