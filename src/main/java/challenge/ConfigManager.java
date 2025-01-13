package challenge;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ConfigManager {

    private Properties properties;

    public ConfigManager(String configFilePath) throws IOException {
        this.properties = new Properties();
        try (FileInputStream fis = new FileInputStream(configFilePath)) {
            properties.load(fis);
        }
    }

    public String getImagePath() {
        return properties.getProperty("imagePath");
    }

    public Set<String> getIgnoredColors() {
        Set<String> ignoredColors = new HashSet<>();
        String ignoreColorsInput = properties.getProperty("ignoreColors", "");
        if (!ignoreColorsInput.isEmpty()) {
            String[] colors = ignoreColorsInput.split(" ");
            for (String color : colors) {
                ignoredColors.add(color.trim());
            }
        }
        System.err.println(ignoredColors);
        return ignoredColors;
    }

    public int getNumberOfColors() {
        return Integer.parseInt(properties.getProperty("numberOfColors", "1"));
    }
}
