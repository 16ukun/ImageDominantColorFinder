package challenge;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

class ImageDominantColorFinderTest {
	
	// Mock image for testing
	class MockImageLoader implements ImageLoaderInterface {
	    private BufferedImage testImage;

	    public MockImageLoader(BufferedImage testImage) {
	        this.testImage = testImage;
	    }

	    @Override
	    public BufferedImage loadImage(String path) {
	        return testImage;
	    }
	}

	@Test
	void test() {

        BufferedImage testImage = new BufferedImage(3, 3, BufferedImage.TYPE_INT_RGB);
        // Define pixel colors
        testImage.setRGB(0, 0, new Color(255, 0, 0).getRGB()); // Red
        testImage.setRGB(1, 0, new Color(255, 0, 0).getRGB()); // Red
        testImage.setRGB(2, 0, new Color(0, 255, 0).getRGB()); // Green

        testImage.setRGB(0, 1, new Color(0, 0, 255).getRGB()); // Blue
        testImage.setRGB(1, 1, new Color(255, 255, 0).getRGB()); // Yellow
        testImage.setRGB(2, 1, new Color(255, 255, 0).getRGB()); // Yellow

        testImage.setRGB(0, 2, new Color(0, 0, 0).getRGB()); // Black
        testImage.setRGB(1, 2, new Color(255, 255, 255).getRGB()); // White
        testImage.setRGB(2, 2, new Color(128, 128, 128).getRGB()); // Gray

        Set<String> ignoredColors = Set.of("0,255,0");
        int numberOfColors = 2;
        
        MockImageLoader mockImageLoader = new MockImageLoader(testImage);

        ImageDominantColorFinder imageDominantColorFinder = new ImageDominantColorFinder("", ignoredColors, numberOfColors, mockImageLoader);
        List<Map.Entry<String, Integer>> result = imageDominantColorFinder.findDominantColors();

		System.out.println("Top " + numberOfColors + " Dominant Colors:");
		for (Map.Entry<String, Integer> entry : result) {
			System.out.println("Color: " + entry.getKey() + ", Count: " + entry.getValue());
		}
		
        // Assert - Validate the results
        assertEquals(2, result.size());
        assertEquals("250,0,0", result.get(0).getKey()); // Red is dominant
        assertEquals("250,250,0", result.get(1).getKey()); // Yellow is second dominant

	}
}
