package Application;

import ClientThread.Client;
import Query.ProfileData;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class AskProfileData {
    ObjectOutputStream objectOutputStream = Client.objectOutputStream;
    private String userName;
    public AskProfileData(String userName){
        this.userName = userName;
    }
    public void profileInfo() throws IOException {
        ProfileData data = new ProfileData();
        data.setUserName(userName);
        objectOutputStream.writeObject(data);
        objectOutputStream.flush();
        System.out.println("Asking Profile Info done");
    }
}
