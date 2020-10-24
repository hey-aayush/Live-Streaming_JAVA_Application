package Server;

import User.*;
import javafx.beans.Observable;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.Vector;

public class SearchReply implements Serializable {


    private Vector<User> vector;

    public Vector<User> getVector() {
        return vector;
    }

    public void setVector(Vector<User> vector) {
        this.vector = vector;
    }
}
