package Streaming;

import Server.Query.StreamingAddress;

import javax.sound.sampled.*;
import java.io.*;
import java.net.*;

//Audio Receiver End
public class AudioRec implements Runnable {

    private final int SIZE = 10500;
    private MulticastSocket audioReceivingSocket;
    private byte[] receiveData;
    private AudioInputStream inputStream;
    private SourceDataLine sourceLine;
    private Synchronizer synchronizer;
    private StreamingAddress streamingAddress;
    boolean terminate;


    public AudioRec(Synchronizer synchronizer, StreamingAddress streamingAddress) throws IOException {

        receiveData = new byte[SIZE];
        this.synchronizer = synchronizer;
        this.streamingAddress = streamingAddress;
        audioReceivingSocket = new MulticastSocket(9278);
        audioReceivingSocket.joinGroup(new InetSocketAddress(streamingAddress.getAddress(), 9278), null);
        terminate = false;

    }

    public void terminateAudioRec(){
        System.out.println("Terminating audio receiver!!");
        this.terminate = true;
    }

    @Override
    public void run() {

    while (!terminate) {

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            try {
                audioReceivingSocket.receive(receivePacket);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            try {
                byte[] buf = receivePacket.getData();

                //Conversion
                Object object = null;
                ByteArrayInputStream bais = new ByteArrayInputStream(buf);
                ObjectInput in = null;
                try {
                    in = new ObjectInputStream(bais);
                    object = in.readObject();

                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    try {
                        if (in != null) {
                            in.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                AudioPacket audioPacket;
                if(object!=null)
                {
                    if(object instanceof AudioPacket)
                    {
                        audioPacket = (AudioPacket)object;
                        System.out.println(audioPacket.getTimestamp());
                    }
                    else
                    {
                        continue;
                    }
                }
                else
                {
                    System.out.println("Audio Null value!");
                    continue;
                }

                byte[] audioData = audioPacket.getData();

                InputStream byteInputStream = new ByteArrayInputStream(audioData);
                AudioFormat adFormat = AudioSen.getAudioFormat();
                inputStream = new AudioInputStream(byteInputStream, adFormat, audioData.length / adFormat.getFrameSize());
                DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, adFormat);
                sourceLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
                sourceLine.open(adFormat);
                sourceLine.start();

                synchronizer.setSourceLine(sourceLine);

                if(audioPacket!=null)
                synchronizer.addAudioPacket(audioPacket);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
