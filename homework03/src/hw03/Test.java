package hw03;

/**
 * 
 * Custom class to use for testing in Main
 * 
 * @author angy xajil; CS2013-05; CIN: 400304005
 *
 */

public class Test implements Comparable<Test> {
	private int number;
	private char character;
	private double numeral;

	Test(int num, char letter, double decimal) {
		number = num;
		character = letter;
		numeral = decimal;
	}

	/**
	 * needed for a comparable interface and our sort method.
	 */
	@Override
	public int compareTo(Test o) {
		// TODO Auto-generated method stub

		/**
		 * comparing Test objects
		 * o is a test object, calls the data field number. 
		 * if data field number is greater than data field number
		 * comparing same objects, same data field, different value maybe
		 */
		if (number < o.number) {
			return -1;
		} else if (number > o.number) {
			return 1;
		}
		if (character < o.character) {
			return -1;
		} else if (character > o.character) {
			return 1;
		}
		if (numeral < o.numeral) {
			return -1;
		} else if (numeral > o.numeral) {
			return 1;
		}
		return 0;

	}

	public String toString() {
		String s = "Num: " + number + ", Letter: " + character + ", Float: " + numeral;
		return s;
	}

}