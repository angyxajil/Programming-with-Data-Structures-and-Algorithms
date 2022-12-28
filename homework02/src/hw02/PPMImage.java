package hw02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Reads the file chosen by the user byte by byte, applies the effect chosen by
 * the user by manipulating each pixel's color channels, and writes it to a new
 * file with the name the user has chosen.
 * 
 * @author angy xajil; CIN: 400304005; CS 2013-05
 *
 */

public class PPMImage {

	/**
	 * a String to store the magic number.
	 */
	private String magicNumber;

	/**
	 * an integer value for the width of the picture.
	 */
	private int width;

	/**
	 * an integer value for the height of the picture.
	 */
	private int height;

	/**
	 * an integer value for the maxColorValue value.
	 */
	private int maxColorValue;

	/**
	 * a 1D char array to hold all the data from the file
	 */
	private char[] raster;

	/**
	 * Takes a String that is the name of a PPM image and calls the private
	 * readImage method.
	 * 
	 * @param imageFileName is the name of the file the user wants to use
	 */
	public PPMImage(String imageFileName) {
		readImage(imageFileName);
	}

	/**
	 * This method reads the image data byte by byte and converts each byte to a
	 * char in order to store the data correctly. These chars are then concatenated
	 * into a string which is then converted into an integer using the
	 * Integer.parseInt parsing method.
	 * 
	 * @param imageFileName is the name of the file the user wants to use
	 */
	private void readImage(String imageFileName) {

		try {

			BufferedInputStream bis = new BufferedInputStream
					(new FileInputStream(imageFileName));

			/**
			 * Reading the magic number from the ppm image file
			 */

			/**
			 * Creates an array of bytes holding 2 elements
			 */
			byte[] magicBytes = new byte[2];

			/**
			 * reads file and inputs what it read into the byte array magicBytes
			 */
			bis.read(magicBytes);

			/**
			 * initiates magicNumber string variable with the elements stored in
			 * byte array magicBytes turned into a string
			 */
			magicNumber = new String(magicBytes);
// -----------------------------------------------------------------------------
			/**
			 * skips the next byte because it is a \n
			 */
			bis.read();

			/**
			 * Reading the width from the ppm image file
			 */

			/**
			 * String to store values of width
			 */
			String widthValues = "";

			/**
			 * while loop iterates when the read byte is not a space and adds
			 * the character to string widthValues
			 * 
			 * NOTE: each byte was converted to a char in order to store that
			 * data correctly
			 */
			int reader = 0;
			while ((char) (reader = bis.read()) != ' ') {
				widthValues += (char)reader;
			}

			/**
			 * String holding all chars is converted into an integer with the
			 * parsing method
			 */
			width = Integer.parseInt(widthValues);
// -----------------------------------------------------------------------------

			/**
			 * repeat the same process to extract the height and maxColorValue
			 * values from the file
			 */
			String heightValues = "";

			while ((char) (reader = bis.read()) != '\n') {
				heightValues += (char)reader;
			}
			
			height = Integer.parseInt(heightValues);
// -----------------------------------------------------------------------------

			String maxHolder = "";

			while ((char) (reader = bis.read()) != '\n') {
				maxHolder += (char)reader;
			}
			
			maxColorValue = Integer.parseInt(maxHolder);
// -----------------------------------------------------------------------------
			
			/**
			 * computing the size of the array since each pixel is made up of 3
			 * color channels: Red, Green, Blue.
			 */
			int arraySize = (width * height * 3);
			raster = new char[arraySize];

			/**
			 * iterating through the image data and adding it our raster array
			 */
			int j = 0;
			while ((reader = bis.read()) != -1) {
				raster[j] = (char)reader;
				j++;
			}

			bis.close();

		}

		catch (FileNotFoundException e) {
			System.out.println("The image you have entered could not be found."
						+ "\nIncorrect file name.");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method takes a String which is the name of the file the user has chosen
	 * to write the image data to. It creates a new file with the given name and
	 * writes all of the image data into the file.
	 * 
	 * @param outputFileImageName is the file the user want to write to
	 */
	public void writeImage(String outputFileImageName) {

		try {
			BufferedOutputStream bos = new BufferedOutputStream
					(new FileOutputStream(outputFileImageName));

			/**
			 * writes the data we just read into a string, creating a new line
			 * and space to match the format of the original file
			 */
			String headerInfo = magicNumber + '\n' + width + ' ' + height + '\n'
					+ maxColorValue + '\n';

			try {
				/**
				 * iterate through that string byte by byte and writes each byte
				 * into the output image file
				 */
				for (int i = 0; i < headerInfo.length(); i++) {
					bos.write(headerInfo.charAt(i));
				}

				/**
				 * loop through the rest of the file to read the rest of the data
				 */
				for (int j = 0; j < raster.length; j++) {
					bos.write(raster[j]);
				}

				bos.flush();
				bos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method alters the data of each pixel using the given formula to turn
	 * the image from color to grayscale.
	 */
	public void grayscale() {

		/**
		 * each pixel is made up of 3 color channels Red, Green, Blue so the loop
		 * will group the next 3 pixels
		 */
		for (int i = 0; i < raster.length; i += 3) {
			char red = raster[i];
			char green = raster[i + 1];
			char blue = raster[i + 2];

			/**
			 * given formula to alter the data
			 */
			raster[i] = (char) ((red * .299) + (green * .587) + (blue * .114));
			raster[i + 1] = (char) ((red * .299) + (green * .587) + (blue * .114));
			raster[i + 2] = (char) ((red * .299) + (green * .587) + (blue * .114));
		}

		System.out.println("Image changed to grey scale\n");
	}

	/**
	 * This method alters the data of each pixel using the given formula to turn
	 * the image from color to sepia.
	 */
	public void sepia() {

		/**
		 * each pixel is made up of 3 color channels Red, Green, Blue so we the
		 * loop will group the next 3 pixels
		 */
		for (int i = 0; i < raster.length; i += 3) {
			char red = raster[i];
			char green = raster[i + 1];
			char blue = raster[i + 2];

			/**
			 * given formula to alter the data
			 */
			raster[i] = (char) ((red * .393) + (green * .769) + (blue * .189));
			raster[i + 1] = (char) ((red * .349) + (green * .686) + (blue * .168));
			raster[i + 2] = (char) ((red * .272) + (green * .534) + (blue * .131));

			/**
			 * If a resulting value is greater than 255, we just set it to be 255.
			 */
			if ((raster[i] > 255) || (raster[i + 1] > 255) || (raster[i + 2] > 255)) {
				raster[i] = (char) 255;
				raster[i + 1] = (char) 255;
				raster[i + 2] = (char) 255;
			}

		}

		System.out.println("Image changed to sepia\n");

	}

	/**
	 * This method alters the data of each pixel using the given formula to turn
	 * the image from color to negative().
	 */
	public void negative() {

		/**
		 * each pixel is made up of 3 color channels Red, Green, Blue so we the
		 * loop will group the next 3 pixels
		 */
		for (int i = 0; i < raster.length; i += 3) {
			char red = raster[i];
			char green = raster[i + 1];
			char blue = raster[i + 2];

			/**
			 * given formula to alter the data
			 */
			raster[i] = (char) (255 - red);
			raster[i + 1] = (char) (255 - green);
			raster[i + 2] = (char) (255 - blue);
		}

		System.out.println("Image changed to negative\n");

	}

}
