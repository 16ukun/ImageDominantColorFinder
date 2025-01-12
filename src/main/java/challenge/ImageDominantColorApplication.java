package challenge;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImageDominantColorApplication {

	public static void main(String[] args) {

		try {
			// Initialize ConfigManager to read configuration - in order to set config file path on command line
			String configFilePath = args.length > 0 ? args[0] : "src/main/resources/config.properties";
			ConfigManager configManager = new ConfigManager(configFilePath);

			String imagePath = configManager.getImagePath();
			Set<String> ignoredColors = configManager.getIgnoredColors();
			int numberOfColors = configManager.getNumberOfColors();
			
			ImageLoader imageLoader = new ImageLoader();

			// Initialize DominantColorFinder with configuration values
			ImageDominantColorFinder imageDominantColorFinder = new ImageDominantColorFinder(imagePath, ignoredColors, numberOfColors, imageLoader);

			// Find and display dominant colors
			List<Map.Entry<String, Integer>> topNColors = imageDominantColorFinder.findDominantColors();
			
			System.out.println("Top " + numberOfColors + " Dominant Colors:");
			for (Map.Entry<String, Integer> entry : topNColors) {
				System.out.println("Color: " + entry.getKey() + ", Count: " + entry.getValue());
			}

		} catch (IOException e) {
			System.out.println("Error: Unable to load the config file.");
			e.printStackTrace();
		}
	}


}
