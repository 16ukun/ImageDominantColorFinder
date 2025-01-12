package challenge;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface ImageLoaderInterface {
    BufferedImage loadImage(String path) throws IOException;
}
