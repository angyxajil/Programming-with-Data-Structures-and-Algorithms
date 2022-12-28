package hw03;

/**
 * Main class demonstrating that all functionality of MyArray class works.
 * Testing is done with Strings and a custom class Test.
 * 
 * @author angy xajil; CS2013-05; CIN: 400304005
 *
 */

public class Main {

	public static void main(String[] args) {

		MyArray<String> stringArr1 = new MyArray("angy", "loves", "bunnies");
		MyArray<Integer> intArray = new MyArray(34, 234, 57, 435);
		MyArray<Double> doubleArr = new MyArray(12.3, 56.8, 234.65, 234.23, 23.65);
		MyArray<String> stringArr2 = new MyArray("angy", "loves", "bunnies");
		MyArray<Test> test = new MyArray<Test>(new Test(6, 'x', 4.5), 
				new Test(13, 'x', 3.4), new Test(6, 'x', 34.5));
		MyArray<Test> copyTest = new MyArray<Test>(new Test(6, 'x', 4.5), 
				new Test(13, 'x', 3.4),  new Test(6, 'x', 34.5));

		System.out.println("Stock arrays");
		System.out.println("String array: " + stringArr1);
		System.out.println("Integer array: " + intArray);
		System.out.println("Double array: " + doubleArr);
		System.out.println("Test array: " + test);

		System.out.println("--------------------------------");

		System.out.println("Displays element at single index");
		Comparable get1 = stringArr1.get(0);
		System.out.println("String array at index 0: " + get1.toString());
		Comparable get2 = intArray.get(3);
		System.out.println("Integer array at index 3: " + get2.toString());
		Comparable get3 = doubleArr.get(4);
		System.out.println("Double array at index 4: " + get3.toString());
		Comparable get4 = test.get(0);
		System.out.println("Data array at index 0: " + get4.toString());

		System.out.println("--------------------------------");

		System.out.println("Displays elements from chosen indexes");
		MyArray<String> tmp1 = stringArr1.get(0, 1);
		System.out.println("String array at index 0 - 1: " + tmp1);
		MyArray<Integer> tmp2 = intArray.get(1, 3);
		System.out.println("Integer array at index 1 - 3: " + tmp2);
		MyArray<Double> tmp3 = doubleArr.get(2, 4);
		System.out.println("Double array at index 2 - 4: " + tmp3);
		MyArray<Test> tmp4 = test.get(0, 1);
		System.out.println("Test array at index 0 - 1: " + tmp4);

		System.out.println("--------------------------------");

		System.out.println("Replaces multiple elements at given indexes with"
				+ "other elements");
		stringArr1.put(1, 2, "adores", "doggies");
		System.out.println("New string array: " + stringArr1);
		intArray.put(1, 2, 432, 75);
		System.out.println("New integer array: " + intArray);
		doubleArr.put(2, 4, 6.23, 11.11, 9.13);
		System.out.println("New double array: " + doubleArr);
		test.put(1, 2, new Test(1, 'a', 1.1), new Test(2, 'b', 2.2));
		System.out.println("New test array: " + test.toString());

		System.out.println("--------------------------------");

		System.out.println("\nReplaces element at given index with another elements");
		stringArr1.put(1, "hates");
		System.out.println("New string array: " + stringArr1);
		intArray.put(0, 8);
		System.out.println("New integer array: " + intArray);
		doubleArr.put(0, 8.25);
		System.out.println("New double array: " + doubleArr);
		test.put(0, new Test(6, 'x', 4.5));
		System.out.println("New test array: " + test.toString());

		System.out.println("--------------------------------");

		System.out.println("It is " + stringArr1.equals(intArray) + " that string"
				+ " array equals integer array");
		System.out.println("It is " + intArray.equals(doubleArr) + " that integer"
				+ " array equals double array");
		System.out.println("It is " + stringArr1.equals(stringArr2) + " that"
				+ " string array 1 equals string array 2");
		System.out.println("It is " + test.equals(copyTest) + " that test array"
				+ " 1 equals test array 2");

		System.out.println("--------------------------------");

		System.out.println("String array max: " + stringArr1.max());
		System.out.println("String array min: " + stringArr1.min());

		System.out.println("\nInteger array max: " + intArray.max());
		System.out.println("Integer array min: " + intArray.min());

		System.out.println("\nDouble array max: " + doubleArr.max());
		System.out.println("Double array min: " + doubleArr.min());

		System.out.println("\nTest array max: " + test.max());
		System.out.println("Test array min: " + test.min());

		System.out.println("--------------------------------");

		System.out.println("Reverses the arrays");
		stringArr1.reverse();
		System.out.println("String array reversed: " + stringArr1.toString());

		intArray.reverse();
		System.out.println("Integer array reversed: " + intArray.toString());

		doubleArr.reverse();
		System.out.println("Double array reversed: " + doubleArr.toString());

		test.reverse();
		System.out.println("Test array reversed: " + test.toString());

		System.out.println("--------------------------------");

		System.out.println("Randomly shuffles the array");
		stringArr1.shuffle();
		System.out.println("String array shuffled: " + stringArr1.toString());

		intArray.shuffle();
		System.out.println("Integer array shuffled: " + intArray.toString());

		doubleArr.shuffle();
		System.out.println("Double array shuffled: " + doubleArr.toString());

		test.shuffle();
		System.out.println("Test array shuffled: " + test.toString());

		System.out.println("--------------------------------");

		System.out.println("Shifts the array to the left by the given amount of"
				+ "indexes");
		stringArr1.leftShift(1);
		System.out.println("String array shifted left: " + stringArr1.toString());

		intArray.leftShift(3);
		System.out.println("Integer array shifted left: " + intArray.toString());

		doubleArr.leftShift(5);
		System.out.println("Double array shifted left: " + doubleArr.toString());

		test.leftShift(2);
		System.out.println("Test array shifted left: " + test.toString());

		System.out.println("--------------------------------");

		System.out.println("Shifts the array to the right by the given amount of"
				+ "indexes");
		stringArr1.rightShift(1);
		System.out.println("String array shifted right: " + stringArr1.toString());

		intArray.rightShift(3);
		System.out.println("Integer array shifted right: " + intArray.toString());

		doubleArr.rightShift(2);
		System.out.println("Double array shifted right: " + doubleArr.toString());

		test.rightShift(4);
		System.out.println("Test array shifted right: " + test.toString());

		System.out.println("--------------------------------");

		System.out.println("Returns the size of the array");
		System.out.println("Size of string array: " + stringArr1.size());
		System.out.println("Size of integer array: " + intArray.size());
		System.out.println("Size of double array: " + doubleArr.size());
		System.out.println("Size of test array: " + test.size());

		System.out.println("--------------------------------");

		System.out.println("Sorts the arrays");
		stringArr1.sort();
		System.out.println("String array sorted: " + stringArr1.toString());
		intArray.sort();
		System.out.println("Integer array sorted: " + intArray.toString());
		doubleArr.sort();
		System.out.println("Double array sorted: " + doubleArr.toString());
		test.sort();
		System.out.println("Test array sorted: " + test.toString());

	}

}
