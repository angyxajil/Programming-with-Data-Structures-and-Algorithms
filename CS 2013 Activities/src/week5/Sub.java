package week5;

import java.util.Arrays;

public class Sub {

	// Driver Code
	public static void main(String args[]) {
		String str1 = "geeksforgeeks", str2 = "geeks";
		System.out.println(countSubstrig(str1, str2));

		str1 = "hikakashi";
		str2 = "hi";
		System.out.println(countSubstrig(str1, str2));

		String Str = new String("Welcome to geeksforgeeks");

		// using substring() to extract substring
		// returns (whiteSpace)geeksforgeeks

		System.out.print("The extracted substring is : ");
		System.out.println(Str.substring(10));

		int arr[] = { 0, 0, 1 };
		int sum = calculateSum(arr, arr.length);

		System.out.println(sum);

	}

	static int countSubstrig(String str1, String str2) {
		int n1 = str1.length();
		int n2 = str2.length();

		// Base Case
		if (n1 == 0 || n1 < n2)
			return 0;

		// Recursive Case
		// Checking if the first
		// substring matches
		if (str1.substring(0, n2).equals(str2)) {

			return countSubstrig(str1.substring(n2 - 1), str2) + 1;
		}

		// Otherwise, return the count
		// from the remaining index
		return countSubstrig(str1.substring(n2 - 1), str2);
	}

	private static int calculateSum(int arr[], int n) {

		System.out.println(Arrays.toString(arr));
		// base or terminating condition
		if (n <= 0) {
			return 0;
		}

		// Calling method recursively
		for (int i = 0; i < arr.length; i++) {
			int j = arr[i];
			System.out.print(j);
		}
		
		System.out.println();
		return calculateSum(arr, n - 1) + arr[n - 1];
		
	}

}
