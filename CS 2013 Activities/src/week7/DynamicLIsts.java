package week7;

import java.util.ArrayList;

public class DynamicLIsts {

	public static void main(String[] args) {

		// runtime is O(n^2)
		twoSum();

		System.out.println();

		ArrayList<String> str = new ArrayList<String>();
		str.add("angy");
		str.add("loves");
		primVsMod(str);

		String[] strArr = { "i", "love", "puppies", "and", "cotton", "candy" };
		// primVsMod(str);
		musicBot(strArr);

	}

	public static void twoSum() {

		// Given an array of integers
		int[] intArray = { 1, 6, 9, 3 };

		// and an int n
		int n = 4;

		// return indeces of 2 numbers in the array that add up to n
		for (int i = 0; i < intArray.length; i++) {
			for (int j = 0; i < intArray.length; i++) {
				if (intArray[i] + intArray[j] == n) {

					// intArray[0] = i;
					// intArray[1] = j;

					System.out.println("The two indexes that add to equal " + n + " are: ");

					System.out.println(i + " and " + j);

				}
			}
		}
	}

	public static void primVsMod(ArrayList<String> string) {

		// add to the array
		System.out.println("Adding to the array: ");
		string.add("corgis");
		string.add("and");
		string.add("chow chows");

		for (int i = 0; i < string.size(); i++) {
			System.out.println(string.get(i));
		}

		System.out.println();

		// remove from the array
		System.out.println("Removing from the array: ");

		string.remove(3);
		string.remove(3);

		for (int i = 0; i < string.size(); i++) {
			System.out.println(string.get(i));
		}

		// returning the size
		int s = string.size();
		System.out.println("\nSize of the array: " + s);

	}

	public static void musicBot(String[] str) {

		for (int i = 0; i < str.length; i++) {
			/**
			 * hold element an index 0
			 */
			String tmp = str[0];
			/**
			 * picks a random index from array data
			 */
			int randIndex = (int) (Math.random() * (str.length - 1));
			/**
			 * stores data at i into tmp
			 */
			tmp = str[i];
			/**
			 * replaces data at i with the random element
			 */
			str[i] = str[randIndex];
			/**
			 * puts data at i into data at randIndex
			 */
			str[randIndex] = tmp;
		}

		System.out.println("\nString array shuffled: ");

		for (int i = 0; i < str.length; i++) {
			String index = str[i];
			System.out.print(index + " ");
		}
	}
}
