package Streamer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.*;

public class VideoStreamReceivingThread implements Runnable{

    private Synchronizer synchronizer;
    private StreamingAddress streamingAddress;
    private boolean terminate;
    private MulticastSocket receivingSocket;
    private InetAddress ip;
    private int port;

    public VideoStreamReceivingThread(Synchronizer synchronizer, StreamingAddress streamingAddress) throws IOException {

        this.synchronizer = synchronizer;
        this.streamingAddress = streamingAddress;
        terminate = false;
        ip = InetAddress.getByName(streamingAddress.getAddress());
        port = streamingAddress.getVideoPort();
        receivingSocket = new MulticastSocket(port);
        receivingSocket.joinGroup(new InetSocketAddress(streamingAddress.getAddress(), port), null);

    }

    public void terminateVideoStreamThread(){
        terminate = true;
        System.out.println("Terminating video receiver!");
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

        while(!terminate){

            byte[] buf = new byte[50000];
            DatagramPacket dp = new DatagramPacket(buf, 50000);
            receivingSocket.receive(dp);

            VideoPacket videoPacket;

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
                    videoPacket = (VideoPacket)o;
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

            synchronizer.addVideoPacket(videoPacket);
        }
    }
}
