package tilePuzzle;

import java.util.Scanner;

/**
 * This class outputs a menu for the user to select which puzzle they would like
 * to solve and calls the appropriate method
 * 
 * @author angy xajil CS2013-05; CIN: 400304005
 *
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * declaring a TileSet object
		 */
		TileSet ts = null;

		System.out.println("Which puzzle would you like to solve?" + "\nA: tileset1-1.txt" + "\nB: tileset2-1.txt"
				+ "\nC: tileset3-1.txt");

		Scanner scan = new Scanner(System.in);

		/**
		 * String read by the scanner
		 */
		String choice = scan.nextLine();

		/**
		 * declaring a new string option
		 */
		String option;

		/**
		 * Chosen input is converted to lower case to ensure choice can still be read
		 * despite the case type (upper or lower)
		 */
		option = choice.toLowerCase();

		/**
		 * determines output based on chosen file
		 */
		switch (option) {

		case "a":
			/**
			 * instantiating the TileSet object with chosen file
			 */
			ts = TileSet.LoadTiles("src/txtfiles/tileset1-1.txt");
			/**
			 * boolean true allows all solutions to be printed
			 */
			ts.Solve(true);
			break;
		case "b":
			ts = TileSet.LoadTiles("src/txtfiles/tileset2-1.txt");
			System.out.println("Please wait patiently while the number of solutions are found...");
			/**
			 * boolean value false ensures solutions are not printed (too many!)
			 */
			ts.Solve(false);
			break;
		case "c":
			ts = TileSet.LoadTiles("src/txtfiles/tileset3-1.txt");
			System.out.println("Working...");
			ts.Solve(true);
			break;
		default:
			System.out.println("Something went wrong, please try again!");
			System.exit(0);
		}

		scan.close();

	}

}
