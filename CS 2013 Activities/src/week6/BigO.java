package week6;

public class BigO {

	public static void main(String[] args) {

		// Runtime is O(n)
		System.out.println("even position of the array is made an exponent of itself");
		changesEven();

		System.out.println("\n\nRemoving the decimals in the array");

		
		// Runtime is O(n)
		// Given an array of doubles...
		double[] dec = { 1.3, 8.25, 6.23, 9.13, 11.11 };
		changeValues(dec);

		// print out the result of the modified array
		System.out.println("\nArray without decimals: ");
		for (Double current : dec) {
			System.out.println(current);
		}

	}

	public static void changesEven() {
		// Given an array of integers,
		int[] nums = { 4, 2, 3, 3, 0, 4 };

		System.out.println("Original array: ");

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ", ");
		}

		/**
		 * Create an algorithm where every element in the even position is made an
		 * exponent of itself
		 */
		for (int i = 1; i < nums.length; i++) {
			if (!(i % 2 == 0)) {
				nums[i] = (int) Math.pow(nums[i], nums[i]);
			}
		}

		/**
		 * Printing the updated array
		 */
		System.out.println("\nChanged array: ");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ", ");
		}

	}


	public static void changeValues(double[] vals) {
		
		/**
		 * {2.0, 4.25, 7.125} could be {“20 * 10^-1”, “425 * 10^-2”, “7125 * 10^-3”} ---
		 * note the use of strings. What is the runtime of the algorithm you’ve created?
		 * Can you improve the runtime efficiency?
		 */

		// Given an array of doubles,
		Double[] dec = { 1.3, 8.25, 6.23, 9.13, 11.11 };

		System.out.println("Array with decimals: ");

		for (int i = 0; i < dec.length; i++) {
			System.out.print(dec[i] + ", ");
		}

		/**
		 * Create an algorithm that would remove the decimal from the double assume
		 * we’re just converting the double to a string and we don’t need to convert
		 * back)
		 */
		
		// loop through each of the values
		for (int i = 0; i < vals.length; i++) {
			// save the current value as a string
			String currentValue = Double.toString(vals[i]);

			// replace all periods with a blank, 3.0 becomes 30
			currentValue = currentValue.replaceAll("[.]", "");

			// save value as an integer
			int value = Integer.parseInt(currentValue);

			// execute the actual math here
			value = value * 10;
			double replacement = Math.pow(value, (i + 1));
			vals[i] = value;
			
			/**
			 * i think the math is wrong ):
			 */
		}
	}

}
