# Image Dominant Color Finder

The application identifies the top dominant colors of a given image by loading the image, reading the image's pixel data and calculating the most frequent colors.

## Project Overview

The project consists of the following key components:

- **ImageLoader**: Responsible for loading an image from a specified file path.
- **ImageDominantColorFinder**: Analyses the image and identifies the dominant colors based on the configuration.
- **ConfigManager**: Reads configuration data, including the image file path from a `.properties` file.
- **ImageDominantColorApplication**: Main entry point for the application, which brings everything together and prints the top dominant colors to the console.

## Features

- Load and process an image.
- Identify and display the most frequent colors (dominant colors) from the image.
- Configurable number of colors and ignored colors via a `config.properties` file.
- Run via command line with support for custom configuration files.

## Requirements

- Java 11 or higher
- Maven

## Setup

### 1. Clone the Repository

Clone this repository to your local machine:

```
git clone https://github.com/16ukun/ImageDominantColorFinder.git
cd ImageDominantColorFinder
```

### 2. Build the Project

This project uses Maven for building and managing dependencies. To build the project, run the following command:

```
mvn clean install
```

### 3. Create the Configuration File

Create a 'config.properties' file in the root of the project (or specify its path when running the JAR).

Below is an example of the configuration:
There is a default configuration in /src/main/resources/config.properties

```
properties
# Path to the image file
imagePath=/path/to/your/image.jpg
# Colors to ignore e.g. black
ignoredColors=0,0,0
# Number of top colors to display
numberOfColors=3
```

### 4. Run the Application

To run the application, execute the following command, specifying the path to your config.properties file:

```
java -jar target/FXDigitalCodingChallenge-0.0.1-SNAPSHOT.jar config.properties
```

### 5. Expected output

The application will output the top dominant colors in the image in the RGB format:

```
Top 3 Dominant Colors:
Color: 230,10,0, Count: 1347
Color: 110,190,20, Count: 1253
Color: 100,90,40, Count: 1225
```

### Troubleshooting

Unable to load the image: Ensure the image path specified in config.properties is correct and the file exists.

Invalid config.properties format: Ensure the file is correctly formatted with valid key-value pairs (e.g., imagePath, ignoredColors, numberOfColors)

### References:
Extracting Pixel from an image:
https://www.tutorialspoint.com/how-to-get-pixels-rgb-values-of-an-image-using-java-opencv-library#:~:text=Retrieving%20the%20pixel%20contents%20(ARGB%20values)%20of%20an%20image%20%E2%88%92&text=Get%20the%20pixel%20value%20at,and%20getBlue()%20methods%20respectively.

https://www.rapidtables.com/convert/color/rgb-to-hex.html?r=140&g=210&b=70