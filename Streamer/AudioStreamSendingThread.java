package Streamer;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class AudioStreamSendingThread implements Runnable {

    TargetDataLine targetDataLine;
    AudioFormat audioFormat;
    final int SIZE = 10000;
    Encoder encoder;
    byte tempBuffer[];
    StreamingAddress streamingAddress;
    InetAddress ip;
    int port;
    boolean terminate;
    boolean isMute;

    public AudioStreamSendingThread(StreamingAddress streamingAddress) throws LineUnavailableException, UnknownHostException {
        audioFormat = getAudioFormat();
        DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, audioFormat);

        targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);
        targetDataLine.open(audioFormat);
        targetDataLine.start();
        tempBuffer = new byte[SIZE];
        encoder = new Encoder(new Dimension(640, 480));
        this.streamingAddress = streamingAddress;
        ip = InetAddress.getByName(streamingAddress.getAddress());
        port = streamingAddress.getAudioPort();
        terminate = false;
        isMute = false;
    }

    private AudioFormat getAudioFormat() {
        float sampleRate = 8000.0F;
        int sampleInbits = 16;
        int channels = 1;
        boolean signed = true;
        boolean bigEndian = true;
        return new AudioFormat(sampleRate, sampleInbits, channels, signed, bigEndian);
    }

    public void terminateAudioStreamSendingThread(){
        System.out.println("Terminating audio sender!!");
        this.terminate = false;
    }

    public void muteAudio(){
        isMute = true;
    }

    public void unMuteAudio(){
        isMute = false;
    }

    @Override
    public void run() {
        try {
            DatagramSocket clientSocket = new DatagramSocket();

            while (!terminate) {
                int cnt = targetDataLine.read(tempBuffer, 0, tempBuffer.length);
                long time = System.currentTimeMillis();
                if (cnt > 0) {

                    //New line added
                    AudioPacket audioPacket = new AudioPacket(tempBuffer, time);

                    //Conversion
                    byte []sendData;
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    ObjectOutputStream out = null;
                    try {
                        out = new ObjectOutputStream(bos);
                        out.writeObject(audioPacket);
                        out.flush();
                        sendData = bos.toByteArray();

                    } finally {
                        try {
                            bos.close();
                        } catch (IOException ex) {
                           ex.printStackTrace();
                        }
                    }

                    if(isMute){
                        sendData = null;
                    }

                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, port);
                    clientSocket.send(sendPacket);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
