package ClientThread;

import Streamer.*;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.*;

public class StreamReceivingThread implements Runnable{

    static Synchronizer synchronizer;
    static AudioRec audioRec;
    private StreamingAddress streamingAddress;
    private boolean terminate;
    private MulticastSocket receivingSocket;
    private InetAddress ip;
    private int port;

    public StreamReceivingThread(StreamingAddress streamingAddress) throws IOException {

        this.streamingAddress = streamingAddress;
        terminate = false;
        ip = InetAddress.getByName(streamingAddress.getAddress());
        port = streamingAddress.getVideoPort();
        receivingSocket = new MulticastSocket(port);
        receivingSocket.joinGroup(new InetSocketAddress(streamingAddress.getAddress(), port), null);

    }

    @Override
    public void run() {
        try {
            viewStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void viewStream() throws Exception {


        synchronizer = new Synchronizer();
        new Thread(synchronizer).start();
        audioRec = new AudioRec(synchronizer, streamingAddress);
        new Thread(audioRec).start();

        while(!terminate){

            byte[] buf = new byte[8000];
            DatagramPacket dp = new DatagramPacket(buf, 8000);
            receivingSocket.receive(dp);

            buf = dp.getData();
            Object o = null;

            ByteArrayInputStream bis = new ByteArrayInputStream(buf);
            ObjectInput in = null;
            try {
                in = new ObjectInputStream(bis);
                o = in.readObject();

            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(o!=null)
            {
                if(o instanceof VideoPacket)
                {
                    //System.out.println("Video Packet received!!");
                    //System.out.println(((VideoPacket) o).getSeqNumber());
                }
                else
                {
                    //System.out.println("Something corrupted!");
                    continue;
                }
            }
            else
            {
                System.out.println("Video Null value!");
                continue;
            }

            VideoPacket encodedImage = ((VideoPacket)o);
            synchronizer.addVideoPacket(encodedImage);
        }
    }
}
