package Server;

import Client.RegisterData;
import Database.DatabaseConnection;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientHandler implements Runnable{

    DatabaseConnection connection = DatabaseConnection.getInstance();
    Connection con = connection.getConnection();



    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    private Socket socket;

    ClientHandler(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try{
            ObjectInputStream in= new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream o = new ObjectOutputStream(socket.getOutputStream());

            //Adding clients in clients vector
            System.out.println(o);

            while (socket.isConnected()){
                Object object = in.readObject();
                if(object instanceof RegisterData){
                    RegisterData registerData = (RegisterData)object;
                   Registration registration = new Registration();
                   boolean reply = registration.insertUser(registerData);
                   TFReply tfReply = new TFReply();
                   tfReply.setReply(reply);
                   o.writeObject(tfReply);
                }
            }

        }catch(Exception e){}

    }

}
