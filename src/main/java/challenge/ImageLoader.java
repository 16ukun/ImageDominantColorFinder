package challenge;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader implements ImageLoaderInterface{
	@Override
	public BufferedImage loadImage(String path) throws IOException {
	    return ImageIO.read(new File(path));
	}
}
