package lab3;

public class Lab3 {

	public static void main(String[] args) {

		/**
		 * add instructions here >.<
		 */
		
		//arrays the method will use
		Integer[] intArray = { 234, 3456, 56 };
		String[] strArray = { "angy", "doggie", "kitty" };
		Double[] doubleArray = { 12.34, 24.3, 3.4 };

		Lab3.<Integer>printArray(intArray);
		Lab3.<String>printArray(strArray);
		Lab3.<Double>printArray(doubleArray);

		sort(intArray);
		sort(strArray);
		sort(doubleArray);
	}

	//prints arrays
	public static <E> void printArray(E[] list) {

		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}

		System.out.println();

	}
	
	//sorts arrays
	public static <E extends Comparable<E>> void sort(E[] list) {
		E min;
		int indexOfMin;

		for (int i = 0; i < list.length; i++) {
			min = list[i];
			indexOfMin = i;

			for (int j = i + 1; j < list.length; j++) {
				if (min.compareTo(list[j]) > 0) {
					min = list[j];
					indexOfMin = j;
				}
			}

			if (indexOfMin != i) {
				list[indexOfMin] = list[i];
				list[i] = min;

			}

		}

		System.out.println();

		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " " + "\n");
		}

	}

}