import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class ScreenReceiver {

    public static void main(String[] args) throws Exception {

        InetAddress group = InetAddress.getByName("224.0.0.0");
        int port = Integer.parseInt("1234");
        MulticastSocket socket = new MulticastSocket(port);

        JLabel label = new JLabel();
        JFrame frame = new JFrame("ServerSide");

        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        label.setSize(640, 480);
        label.setVisible(true);

        frame.add(label);
        frame.setVisible(true);

        socket.joinGroup(group);


        while (true) {
            byte[] buf = new byte[50000];
            DatagramPacket dp = new DatagramPacket(buf, 50000);
            long nanoTime = System.nanoTime();
            socket.receive(dp);

            buf = dp.getData();

            BufferedImage imag = ImageIO.read(new ByteArrayInputStream(buf));
            ImageIcon ic = new ImageIcon(imag);
            label.setIcon(ic);
            long diff = System.nanoTime() - nanoTime;
            System.out.println("Time takes: " + diff);
        }
    }

}
