package Streamer;

import javax.sound.sampled.*;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//Audio Receiver End

public class AudioRec implements Runnable {

    private final int SIZE = 10500;
    private DatagramSocket serverSocket;
    private byte[] receiveData;
    private AudioInputStream inputStream;
    private SourceDataLine sourceLine;
    private Synchronizer synchronizer;


    public AudioRec(Synchronizer synchronizer) throws SocketException {
        serverSocket = new DatagramSocket(9786);
        receiveData = new byte[SIZE];
        this.synchronizer = synchronizer;
    }

    @Override
    public void run() {



        while (true) {

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            try {
                serverSocket.receive(receivePacket);
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
                        System.out.println("Audio Packet received!");
                        System.out.println(audioPacket.getTimestamp());
                    }
                    else
                    {
                        System.out.println("Not an audio packet!");
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
                System.exit(0);
            }
        }
    }

}
