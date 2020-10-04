import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

public class MicStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Starting Sound Test ..");
		AudioFormat format =  new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,44100,16,2,4,44100,false);
		
		try {
			
			DataLine.Info info = new DataLine.Info(SourceDataLine.class,format);
			final SourceDataLine sourceline = (SourceDataLine)AudioSystem.getLine(info);
			sourceline.open(format);
			
			info = new DataLine.Info(TargetDataLine.class,format);
			final TargetDataLine targetline = (TargetDataLine)AudioSystem.getLine(info);
			targetline.open();
			
			final ByteArrayOutputStream out = new ByteArrayOutputStream();
			
			Thread sourceThread = new Thread() {
				@Override public void run() {
					sourceline.start();
					while(true){
						sourceline.write(out.toByteArray(), 0, out.toByteArray().length);
					}
				}
			};	
			
			Thread targetThread = new Thread() {
				
				@Override public void run() {
					targetline.start();
					System.out.println("TargetLine Started");
					byte[] data = new byte[targetline.getBufferSize()/10];
					int readBytes;
					while(true) {

						readBytes = targetline.read(data,0,data.length);
						out.write(data,0,readBytes);
					}
				}
			};
			
			Thread thread = new Thread() {
				@Override public void run() {
					
					AudioInputStream audioStream = new AudioInputStream(targetline);
					
					File audioFile = new File("Recording3.wav");
					
					try {
						AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE,audioFile);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("Stoped Recording ...");
					try {
						audioStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			};
			
			targetThread.start();
			System.out.println("Started Recording");
			thread.start();
			Thread.sleep(3000);
			
			targetline.stop();
			targetline.close();
			
			System.out.println("Started Playback");
			sourceThread.start();
			Thread.sleep(3000);
			sourceThread.stop();
			sourceline.drain();
			sourceline.stop();
			sourceline.close();
			
			System.out.println("Ended Playback");
			
		}catch(Exception E) {
			E.printStackTrace();
		}
		
		System.out.println("I am here");
		System.exit(0);
	}

}
