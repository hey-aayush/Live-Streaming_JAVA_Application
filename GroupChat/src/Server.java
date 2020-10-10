import java.net.*;
import java.io.*;
import java.util.*;

public class Server implements Runnable{

    Socket socket;
    public static Vector clients = new Vector();

    public Server(Socket socket){
        try{
            this.socket = socket;
        }catch(Exception e){}
    }

    public void run(){
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            //Adding clients in clients vector
            clients.add(writer);
            while(true){
                //Reading message from client
                String data = reader.readLine().trim();
                System.out.println("Message Received: "+data);

                //Broadcasting message to all the clients
                for(int i = 0; i < clients.size(); i++){
                    try{
                        BufferedWriter msgWriter = (BufferedWriter)clients.get(i);
                        msgWriter.write(data + "\r\n");
                        msgWriter.flush();
                    }catch(Exception e){}
                }

            }
        }catch(Exception e){}

    }


    public static void main(String[] args) throws Exception{
        //starting server
        ServerSocket serverSocket = new ServerSocket(5436);
        //waiting for the client to ping
        while(true){
            Socket socket = serverSocket.accept();    //client accepted
            //Providing a new thread for communicating  with that client
            Thread t = new Thread(new Server(socket));
            t.start();
        }
    }
}