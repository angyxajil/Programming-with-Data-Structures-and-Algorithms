package hw03;

/**
 * 
 * Array class using generics and adding additional features not available to
 * normal arrays.
 * 
 * @author angy xajil; CS2013-05; CIN: 400304005
 *
 */

public class MyArray<E extends Comparable<E>> {
	// No other data fields necessary.
	private E[] data;

	@SuppressWarnings("unchecked")
	public MyArray(int size) {
		this.data = (E[]) (new Comparable[size]);
	}

	// This constructor can accept an array or a comma-separated list of values.
	@SuppressWarnings("unchecked")
	public MyArray(E... elements) {
		this.data = (E[]) (new Comparable[elements.length]);
		// Make a deep copy to prevent shared references.
		System.arraycopy(elements, 0, this.data, 0, elements.length);
	}

	// Add other methods.\

	/**
	 * This method returns data array of comparable type at given index
	 */
	public E get(int index) {
		return data[index];
	}

	/**
	 * This method takes two integer parameters start and end and returns a new
	 * MyArray object with values between indices start and end inclusive.
	 * 
	 * @param start: is the integer at which the user wants to begin retrieving data
	 * @param end:   is the integer at which the user wants to stop retrieving data
	 * @return newArray: a new MyArray object populated with values between indices
	 *         start and end inclusive.
	 */
	public MyArray<E> get(int start, int end) {

		if (start < 0 || start > end || ((end + 1) - start) > data.length ||
				end > data.length) {

			throw new IndexOutOfBoundsException("WRONG OUT OF BOUNDS");

		} else {

			MyArray<E> newArray = new MyArray<E>((end + 1) - start);

			for (int i = start; i <= end; i++) {

				int j = i - start;
				newArray.data[j] = data[i];
			}

			return newArray;
		}

	}

	/**
	 * This method takes an integer index and a comparable value and places the
	 * value at the given index.
	 * 
	 * @param index: is an integer to represent the index the user wants to use
	 * @param value: is the comparable type value the user wants to put in the
	 *               chosen index
	 */
	public void put(int index, E value) {

		if (index > data.length || index < 0) {
			throw new IndexOutOfBoundsException("index out of bounds");
		} else {
			data[index] = value;
		}

	}

	/**
	 * This method takes comparable values from the user and replaces the values
	 * between the chosen start index position and the chosen end index position
	 * (inclusive).
	 * 
	 * @param start:    is the integer at which the user wants to begin replacing
	 *                  data
	 * @param end:      is the integer at which the user wants to stop replacing
	 *                  data
	 * @param elements: is the comparable type values the user wants to place in
	 * 					the array
	 * 
	 */
	public void put(int start, int end, E... elements) {

		int count = 0;

		if (start < 0 || start > end || ((end + 1) - start) > data.length ||
				end > data.length) {
			throw new IndexOutOfBoundsException("index out of bounds");
		} else {

			for (int i = start; i <= end; i++) {
				/**
				 * loop through indexes and replace with elements of E
				 */
				data[i] = elements[count];
				count++;
			}
		}

	}

	/**
	 * @Override Override the equals method. This method takes a single MyArray
	 *           object as input and return whether or not this MyArray object is
	 *           equal to the parameter MyArray object. Two my array objects are
	 *           equal if they have the same number of elements, all with the same
	 *           data type, in the exact same order without needing to be sorted.
	 */
	@Override
	public boolean equals(Object arr) {

		boolean result = false;
		/**
		 * instanceof returns a boolean if the object parameter (arr) is an
		 * instance of (class/sub-class/interface) MyArray
		 */
		if (arr instanceof MyArray) {
			/**
			 * casting Object arr to a MyArray object
			 */
			MyArray array = (MyArray) arr;
			/**
			 * check whether array and data are the same length
			 */
			if (array.data.length == this.data.length) {
				/**
				 * if they are equal length, it then check whether elements at
				 * the same index are equal
				 */
				for (int i = 0; i < data.length; i++) {
					if ((array.get(i).compareTo(data[i])) == 0) {
						/**
						 * if they have the same ASCII value, the result is true
						 */
						result = true;
					} else {
						result = false;
					}
				}
			}

			/**
			 * if line 135 condition is not met, return false
			 */
		} else {
			throw new IllegalArgumentException("Object not of comparable type");
		}
		return result;
	}

	/**
	 * This method take no parameters, finds, returns the maximum value in the
	 * array.
	 * 
	 * @return maxElt: the maximum element in the array (based on ASCII code)
	 */
	public E max() {

		/**
		 * holds element at index 0
		 */
		E maxElt = data[0];

		for (int i = 1; i < data.length; i++) {
			/**
			 * compares the element being iterated through and compares it to
			 * the element at index 0
			 */
			if ((maxElt.compareTo(data[i])) < 0) {
				/**
				 * updates maxElt if element at i is larger
				 */
				maxElt = data[i];
			}
		}

		return maxElt;

	}

	/**
	 * This method takes no parameters, finds, returns the minimum value in the
	 * array.
	 * 
	 * @return minElt: the minimum element in the array (based on ASCII code)
	 */
	public E min() {

		/**
		 * holds element at index 0
		 */
		E minElt = data[0];

		for (int i = 1; i < data.length; i++) {
			/**
			 * compares the element being iterated through and compares it to
			 * the element at index 0
			 */
			if ((minElt.compareTo(data[i])) > 0) {
				/**
				 * updates minElt if element at i is smaller
				 */
				minElt = data[i];
			}
		}

		return minElt;

	}

	/**
	 * This method takes no parameters and reverses the array. NOTE: It does not
	 * return a new array that is the reverse, it simply reverses the existing
	 * array.
	 */
	public void reverse() {

		/**
		 * iterating through half the array
		 */
		for (int i = 0; i < data.length / 2; i++) {
			/**
			 * integer to hold the opposing element, i
			 */
			int j = data.length - i - 1;
			E swap = data[i];
			data[i] = data[j];
			data[j] = swap;
		}

	}

	/**
	 * This method randomly shuffles the array. NOTE: It does not return a new
	 * array, it shuffles the existing array.
	 */
	public void shuffle() {

		for (int i = 0; i < data.length; i++) {
			/**
			 * hold element an index 0
			 */
			E tmp = data[0];
			/**
			 * picks a random index from array data
			 */
			int randIndex = (int) (Math.random() * (data.length - 1));
			/**
			 * stores data at i into tmp
			 */
			tmp = data[i];
			/**
			 * replaces data at i with the random element
			 */
			data[i] = data[randIndex];
			/**
			 * puts data at i into data at randIndex 
			 */
			data[randIndex] = tmp;
		}

	}

	/**
	 * This method takes an integer value as a parameter and left shift the
	 * elements in the array by the given number of positions. This is a circular
	 * shift so the beginning should wrap around to the end.
	 * NOTE: This method does not return a new MyArray.
	 * 
	 * @param shiftDistance: is the amount of indexes the user wants to shift
	 */
	public void leftShift(int shiftDistance) {

		while (shiftDistance > 0) {
			/**
			 * tmp value of comparable type E that holds data at index 0
			 */
			E tmp = data[0];

			for (int i = 0; i < data.length - 1; i++) {
				data[i] = data[i + 1];
			}
			data[data.length - 1] = tmp;
			shiftDistance--;
		}
	}

	/**
	 * This method shall take an integer value as a parameter and right shift the
	 * elements in the array by the given number of positions. This is a circular
	 * shift so the end should wrap around to the beginning. NOTE: This method does
	 * not return a new MyArray.
	 */
	public void rightShift(int shiftDistance) {
		while (shiftDistance > 0) {

			E tmp = data[data.length - 1];

			for (int i = data.length - 1; i >= 1; i--) {
				data[i] = data[i - 1];
			}
			data[0] = tmp;
			shiftDistance--;
		}

	}

	/**
	 * This method returns the current size of the array.
	 * @return the array size
	 */
	public int size() {
		return data.length;
	}

	/**
	 * Implement the toString() method so that it will print a String
	 * representation of the array, displaying each value of the array on one
	 * line and should and separating them with a comma and one space.
	 */
	public String toString() {

		String arrayRep = "";

		for (int i = 0; i < data.length; i++) {
			arrayRep += data[i];

			if (i != data.length - 1) {
				arrayRep += ", ";
			}
		}

		return arrayRep;

	}

	/**
	 * This method sorts the array. NOTE: This method does not return a new array,
	 * just sorts the existing array.
	 */
	public void sort() {

		boolean sorted = false;
		E temp;

		/**
		 * while the list is not sorted, !sorted is true when sorted == false
		 */
		while (!sorted) {
			sorted = true;
			/**
			 * for each adjacent pair of items
			 */
			for (int i = 0; i < data.length - 1; i++) {
				/**
				 * if the pair of items are out of order
				 */
				if (data[i].compareTo(data[i + 1]) > 0) {
					/**
					 * swap the pair of items
					 */
					temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;

					sorted = false;
				}
				
			}			
		}
	}
}