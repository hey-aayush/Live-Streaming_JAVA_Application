package Streamer;

import java.awt.image.BufferedImage;

public class ImageConverter {

	  public static BufferedImage convertToType(BufferedImage sourceImage, int targetType) {
	    BufferedImage image;
	    if (sourceImage.getType() == targetType) {
			image = sourceImage;
		}
	    else {
	      image = new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), targetType);
	      image.getGraphics().drawImage(sourceImage, 0, 0, null);
	    }
	    return image;
	  }
}
