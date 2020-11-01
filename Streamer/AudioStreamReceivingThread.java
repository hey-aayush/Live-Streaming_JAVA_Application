package Streamer;

import javax.sound.sampled.*;
import java.io.*;
import java.net.*;

/**
 * Audio Thread for receiving stream audio
 *
 */

public class AudioStreamReceivingThread implements Runnable {

    private final int SIZE = 10500;
    private MulticastSocket audioReceivingSocket;
    private byte[] receiveData;
    private AudioInputStream inputStream;
    private SourceDataLine sourceLine;
    private Synchronizer synchronizer;
    private StreamingAddress streamingAddress;
    private boolean terminate;
    private int port;

    public AudioStreamReceivingThread(Synchronizer synchronizer, StreamingAddress streamingAddress) throws IOException {

        receiveData = new byte[SIZE];
        this.synchronizer = synchronizer;
        this.streamingAddress = streamingAddress;
        port = this.streamingAddress.getAudioPort();
        audioReceivingSocket = new MulticastSocket(port);

        //Joining multicast group
        audioReceivingSocket.joinGroup(new InetSocketAddress(streamingAddress.getAddress(), port), null);

        terminate = false;
    }

    /* Thread termination function */
    public void terminateAudioStreamReceiver(){
        System.out.println("Terminating audio receiver!!");
        this.terminate = true;
    }

    @Override
    public void run() {

        byte[] audioData = new byte[10500];
        InputStream byteInputStream = new ByteArrayInputStream(audioData);
        AudioFormat adFormat = getAudioFormat();
        inputStream = new AudioInputStream(byteInputStream, adFormat, audioData.length / adFormat.getFrameSize());
        DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, adFormat);
        try {
            sourceLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
            sourceLine.open(adFormat);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        sourceLine.start();
        synchronizer.setSourceLine(sourceLine);

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
                    if(object instanceof AudioPacket) {

                        audioPacket = (AudioPacket)object;
                        System.out.println(audioPacket.getTimestamp());
                    }
                    else {
                        continue;
                    }
                }
                else
                {
                    System.out.println("Audio Null value!");
                    continue;
                }

                synchronizer.addAudioPacket(audioPacket);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private AudioFormat getAudioFormat() {
        float sampleRate = 8000.0F;
        int sampleInbits = 16;
        int channels = 1;
        boolean signed = true;
        boolean bigEndian = true;
        return new AudioFormat(sampleRate, sampleInbits, channels, signed, bigEndian);
    }

}
