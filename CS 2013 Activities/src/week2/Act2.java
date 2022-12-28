package lab2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Act2 {

	public static void main(String[] args) {

		problem1();

		problem2();

		problem3();
	}

	/**
	 * Transposing a text file
	 */
	public static void problem1() {

		try {
			
			//Reading the file
			String filename = "src/act2/CS2013ActWk2_SampleText1.txt";
			FileInputStream file = new FileInputStream(filename);
			
			//read each line of the file
			//put each line into an array
			//separate each word when the reader encounters a space
			//put those words into an array
			//create an array for each line
			
			//create a new file and print elements with a for loop
			//for loop through each array and print index 0 for all
				//then print all of index 1 in the array
				//so on until it reaches the end of the file
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method takes a file inputted from the user and copies the contents.
	 * It renames the file and places in a different location
	 */
	public static void problem2() {

		try {

//			Scanner scan = new Scanner(System.in);
//			
//			System.out.println("Enter the name of the file you would like to copy: ");
//			
//			//user also need to enter the path ???
//			
//			String tmp = scan.nextLine();
//			
//			String filePath = "src/" + tmp;

			String fileName = "src/actFile/CS2013ActWk2_SampleText1.txt";

			FileInputStream file = new FileInputStream(fileName);

			String newFilename = "src/newFile";
			FileOutputStream fileOs = new FileOutputStream(newFilename);

			int data = file.read();
			while (data != -1) {
				fileOs.write((char) data);
				data = file.read();
			}

			file.close();
			fileOs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 * not sure how to do with user input since I would need the path
		 */

	}

	/**
	 * Appending text to a file take in a dat file and add additional text to it
	 * (could be anything). Be sure to save it as a dat file and a text file. Also
	 * make sure to print out the path of the files and check the text file to be
	 * sure that the additional text you inputted is correct.
	 */
	public static void problem3() {

		try {

			FileOutputStream fos = new FileOutputStream(new File("src/output.dat"));

			fos.write(114);
			fos.write(34);
			fos.write(127);
			fos.write(732);

			fos.flush();
			fos.close();

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}

		catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
