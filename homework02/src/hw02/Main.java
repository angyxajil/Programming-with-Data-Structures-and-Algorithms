package hw02;

import java.util.Scanner;

/**
 * Creates a nice console menu which allows the user to do the following: Choose
 * an image to manipulate, change the image to sepia, greyscale, or negative,
 * and save the new image with a user chosen file name
 * 
 * @author angy xajil; CIN: 400304005; CS 2013-05
 */

public class Main {

	public static void main(String[] args) {

		System.out.println("Which image would you like to manipulate?");

		Scanner scan = new Scanner(System.in);

		String nameOfFile = scan.nextLine();

		/**
		 * Chosen image input is converted to lower case to ensure file can
		 * still be used despite the case type (upper, lower, or both)
		 */
		nameOfFile.toLowerCase();

		/**
		 * Validates the given file is of type .ppm. If not, it prints an error
		 * message on line 74
		 */
		if (nameOfFile.endsWith(".ppm")) {
			
			System.out.println("You chose " + nameOfFile);

			/**
			 * The chosen file gets passed to the PPMImage object and is directed
			 * through a relative path
			 */
			PPMImage ppm = new PPMImage("src/ppm_images/" + nameOfFile);

			System.out.println();
			System.out.println("Would you like to change it to sepia, grayscale,"
					+ " or negative?");

			/**
			 * String to hold the user input
			 */
			String effect = scan.nextLine();

			/**
			 * Switch case to to select one effect to be executed. NOTE: user
			 * input is converted to lower case to ensure the effect chosen
			 * still gets applied despite the case type (upper, lower, or both)
			 */
			switch (effect) {

			case "sepia":
				effect.toLowerCase();
				ppm.sepia();
				break;

			case "grayscale":
				effect.toLowerCase();
				ppm.grayscale();
				break;

			case "negative":
				effect.toLowerCase();
				ppm.negative();
				break;
				
			case "none":
				break;
				
			default:
				System.out.println("Something went wrong, please check your"
						+ " spelling and try again!");
				System.exit(0);
			}

			System.out.print("Enter your new file name: ");

			/**
			 * String to hold the new file name inputed by the user
			 */
			String newFile = scan.nextLine();

			scan.close();

			/**
			 * Adds the extension type in case the user failed to do so. This also
			 * helps to ignore other file extension types the user may have used
			 */
			if (!newFile.endsWith(".ppm")) {
				newFile += ".ppm";
			}

			ppm.writeImage(newFile);

			System.out.println();
			System.out.println("Your new file " + newFile + " has been created");

		} else {
			System.out.println("The image you have entered could not be found."
					+ "\nMissing '.ppm' extension.");
		}

		/**
		 * exits the program
		 */
		System.exit(0);

	}

}
