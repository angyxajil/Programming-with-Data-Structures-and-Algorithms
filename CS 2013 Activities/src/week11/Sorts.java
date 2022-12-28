package week11;

/**
 * Creating sorting algorithms
 * 
 * @author angyxajil
 *
 */

public class Sorts {

	public static void main(String[] args) {

		/**
		 * unsorted array
		 */
		int arr[] = { 56, 78, 12, 43, 7 };

		System.out.println("Unsorted array: ");

		/**
		 * printing the unsorted array
		 */
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}

		System.out.println("\n");

		/**
		 * calling sorting algorithms
		 */
		selectionSort(arr);
		insertionSort(arr);
	}

	public static void selectionSort(int array[]) {

		/**
		 * looping through the entire array
		 */
		for (int i = 0; i < array.length - 1; i++) {
			/**
			 * setting index i as the minimum
			 */
			int min = i;
			/**
			 * looping through the array starting at index 1
			 */
			for (int j = i + 1; j < array.length; j++)
				/**
				 * if the value at index j is smaller than the value at index 0
				 */
				if (array[j] < array[min])
					/**
					 * update the minimum
					 */
					min = j;
			/**
			 * temp variable to store the minimum value
			 */
			int temp = array[min];
			/**
			 * swap the value at index min with the value at index i
			 */
			array[min] = array[i];
			array[i] = temp;
		}

		System.out.println("Selection Sort: ");

		/**
		 * printing the sorted array
		 */
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}

		System.out.println("\n");
	}

	public static void insertionSort(int array[]) {

		/**
		 * looping through the entire array
		 */
		for (int i = 1; i < array.length; ++i) {
			/**
			 * integer to hold value at index i
			 */
			int split = array[i];
			/**
			 * integer j to be one less than i
			 */
			int j = i - 1;

			/**
			 * loop to compare value at index j with value at index i
			 */
			while (j >= 0 && array[j] > split) {
				/**
				 * move the value at j on index to the right
				 */
				array[j + 1] = array[j];
				/**
				 * decrement j
				 */
				j--;
			}
			array[j + 1] = split;
		}

		System.out.println("Insertion Sort: ");

		/**
		 * printing the sorted array
		 */
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}

	}

	public static void dataStructure() {

	}

}
