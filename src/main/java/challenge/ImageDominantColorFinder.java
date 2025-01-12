package challenge;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImageDominantColorFinder {

	private String imagePath;
	private Set<String> ignoredColors;
	private int numberOfColors;
	private ImageLoaderInterface imageLoader;

	public ImageDominantColorFinder(String imagePath, Set<String> ignoredColors, int numberOfColors, ImageLoaderInterface imageLoader) {
		super();
		this.imagePath = imagePath;
		this.ignoredColors = ignoredColors;
		this.numberOfColors = numberOfColors;
		this.imageLoader = imageLoader;
	}

	public List<Map.Entry<String, Integer>> findDominantColors() {
        List<Map.Entry<String, Integer>> topNColors = new ArrayList<>();

		try {

			BufferedImage image = imageLoader.loadImage(this.imagePath);

			Map<String, Integer> colorCount = new HashMap<>();

			// Iterate over each pixel in the image
			for (int y = 0; y < image.getHeight(); y++) {
				for (int x = 0; x < image.getWidth(); x++) {

					Color color = new Color(image.getRGB(x, y));

					// Simplify the color space by rounding RGB values
					int red = (color.getRed() / 10) * 10;
					int green = (color.getGreen() / 10) * 10;
					int blue = (color.getBlue() / 10) * 10;

					// string representation of the simplified color
					String simplifiedColor = red + "," + green + "," + blue;

					// Skip ignored colors
					if (ignoredColors.contains(simplifiedColor)) {
						continue;
					}

					// Count the occurrence of this color
					colorCount.put(simplifiedColor, colorCount.getOrDefault(simplifiedColor, 0) + 1);
				}
			}

			List<Map.Entry<String, Integer>> sortedColors = new ArrayList<>(colorCount.entrySet());
			sortedColors.sort((a, b) -> b.getValue() - a.getValue());

			topNColors = sortedColors.subList(0, Math.min(numberOfColors, sortedColors.size()));
			
		} catch (IOException e) {
			System.out.println("Error: Unable to load the image. Please check the file path.");
			e.printStackTrace();
		}
		return topNColors ;
	}
	
}
