package Server;

import Server.Database.DatabaseConnection;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;

public class Server {

    DatabaseConnection connection = DatabaseConnection.getInstance();
    Connection con = connection.getConnection();

    public static void main(String[] args) throws Exception{
        //starting server
        ServerSocket serverSocket = new ServerSocket(5781);
        //waiting for the client to ping
        while(true){
            Socket socket = serverSocket.accept();   //client accepted
            System.out.println(socket.getRemoteSocketAddress());
            //Providing a new thread for communicating  with that client
            Thread t = new Thread(new ClientHandler(socket));
            t.start();
        }
    }

}
