package hw05;

import java.util.Random;

/**
 * This class is where all testing is performed. It properly demonstrate that
 * all functionality of the data structure works.
 * 
 * @author angy xajil; CS 2013-05; CIN: 400304005
 *
 */

public class Main {
	public static void main(String[] args) {

		/**
		 * Create an instance of the random class to generate random integers
		 */
		Random rand = new Random();

		/**
		 * Create a double array of integers and initialize its dimensions
		 */
		Integer[][] array2D = new Integer[4][4];

		/**
		 * Outer loop creates and traverses through rows
		 */
		for (int i = 0; i < array2D.length; i++) {
			/**
			 * inner loop that creates and traverses through columns while populating
			 * columns with random integers between 10-20
			 */
			for (int j = 0; j < array2D[0].length; j++) {
				/**
				 * create an integer with desired range
				 */
				int randInt = rand.nextInt(89) + 10;
				/**
				 * set node items to generated random integers
				 */
				array2D[i][j] = randInt;
			}
		}

		/**
		 * Create an instance of the Array2D class and load the randomly generated 2D
		 * array
		 */
		Array2D tester = new Array2D(array2D);
		System.out.println("Original 2D Linked List");
		System.out.print(tester.toString());
		System.out.println("Column tail: " + tester.colTail.getItem());
		System.out.println("Row tail: " + tester.rowTail.getItem());
		System.out.println("Head: " + tester.head.getItem());

		System.out.println("\nAdding first column");
		tester.addFirstCol(11, 11, 11, 11);
		System.out.print(tester.toString());
		System.out.println("Column tail: " + tester.colTail.getItem());
		System.out.println("Row tail: " + tester.rowTail.getItem());
		System.out.println("Head: " + tester.head.getItem());

		System.out.println("\nAdding first row");
		tester.addFirstRow("a ", "e", " i ", "o", " u ");
		System.out.print(tester.toString());
		System.out.println("Column tail: " + tester.colTail.getItem());
		System.out.println("Row tail: " + tester.rowTail.getItem());
		System.out.println("Head: " + tester.head.getItem());

		System.out.println("\nAdding last column");
		tester.addLastCol(2, 2, 2, 2, 2);
		System.out.print(tester.toString());
		System.out.println("Column tail: " + tester.colTail.getItem());
		System.out.println("Row tail: " + tester.rowTail.getItem());
		System.out.println("Head: " + tester.head.getItem());

		System.out.println("\nAdding last row");
		tester.addLastRow(13, 13, 13, 13, 13, 13);
		System.out.print(tester.toString());
		System.out.println("Column tail: " + tester.colTail.getItem());
		System.out.println("Row tail: " + tester.rowTail.getItem());
		System.out.println("Head: " + tester.head.getItem());

		System.out.println("\nInserting a column");
		tester.insertCol(2, " 13", 13, 13, 13, 13, 13);
		System.out.print(tester.toString());
		System.out.println("Column tail: " + tester.colTail.getItem());
		System.out.println("Row tail: " + tester.rowTail.getItem());
		System.out.println("Head: " + tester.head.getItem());

		System.out.println("\nInserting a row");
		tester.insertRow(1, 44, 44, 44, 44, 44, 44, 44);
		System.out.print(tester.toString());
		System.out.println("Column tail: " + tester.colTail.getItem());
		System.out.println("Row tail: " + tester.rowTail.getItem());
		System.out.println("Head: " + tester.head.getItem());

		System.out.println("\nDeleting the first column");
		tester.deleteFirstCol();
		System.out.print(tester.toString());
		System.out.println("Column tail: " + tester.colTail.getItem());
		System.out.println("Row tail: " + tester.rowTail.getItem());
		System.out.println("Head: " + tester.head.getItem());

		System.out.println("\nDeleting the first Row");
		tester.deleteFirstRow();
		System.out.print(tester.toString());
		System.out.println("Column tail: " + tester.colTail.getItem());
		System.out.println("Row tail: " + tester.rowTail.getItem());
		System.out.println("Head: " + tester.head.getItem());

		System.out.println("\nDeleting the last col");
		tester.deleteLastCol();
		System.out.print(tester.toString());
		System.out.println("Column tail: " + tester.colTail.getItem());
		System.out.println("Row tail: " + tester.rowTail.getItem());
		System.out.println("Head: " + tester.head.getItem());

		System.out.println("\nDeleting the last row");
		tester.deleteLastRow();
		System.out.print(tester.toString());
		System.out.println("Column tail: " + tester.colTail.getItem());
		System.out.println("Row tail: " + tester.rowTail.getItem());
		System.out.println("Head: " + tester.head.getItem());

		System.out.println("\nDeleting the column at index 1");
		tester.deleteCol(1);
		System.out.print(tester.toString());
		System.out.println("Column tail: " + tester.colTail.getItem());
		System.out.println("Row tail: " + tester.rowTail.getItem());
		System.out.println("Head: " + tester.head.getItem());

		System.out.println("\nDeleting the row at index 2");
		tester.deleteRow(2);
		System.out.print(tester.toString());
		System.out.println("Column tail: " + tester.colTail.getItem());
		System.out.println("Row tail: " + tester.rowTail.getItem());
		System.out.println("Head: " + tester.head.getItem());

		System.out.println("\nGet item at row 1 column 2");
		System.out.print(tester.get(1, 2));

		System.out.println("\n\nGet item at column 2");
		System.out.print(tester.getCol(2));

		System.out.println("\n\nGet item at row 2");
		System.out.print(tester.getRow(2));

		System.out.println("\n\nSet item at column 2, row 2");
		tester.set(2, 2, 33);
		System.out.print(tester.toString());

		System.out.print("\nColumn size: " + tester.colSize());
		System.out.print("\nRow size: " + tester.rowSize());

		System.out.println("\n\nTable column by column: ");
		System.out.println(tester.toStringColByCol());

	}
}