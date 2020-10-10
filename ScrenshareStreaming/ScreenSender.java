import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.*;

public class ScreenSender {

    public static void main(String args[]) throws IOException {

        InetAddress group = InetAddress.getByName("224.0.0.0");
        int port = Integer.parseInt("1234");
        MulticastSocket socket = new MulticastSocket(port);


        try {
            while(true)
            {
                //Robot class of awt package used to capture the pixels of screen
                Robot r = new Robot();

                Rectangle capture =
                        new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                //createScreenCapture() method used to capture the screen
                BufferedImage Image = r.createScreenCapture(capture);
                int type = Image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB
                        : Image.getType();
                //Used to resize image
                BufferedImage resizedImage = resizeImage(Image, type);

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ImageIO.write(resizedImage, "jpg", bos );
                bos.flush();
                byte [] data = bos.toByteArray();

                bos.close();

                System.out.println(data.length);
                // Creating new UDP packet with data
                DatagramPacket dp = new DatagramPacket(data, data.length, group, port);
                long nanoTime = System.nanoTime();
                socket.send(dp);

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    private static BufferedImage resizeImage(BufferedImage originalImage, int type) {
        int IMG_WIDTH = 768;
        int IMG_HEIGHT = 512;
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT,
                type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();
        return resizedImage;
    }
}