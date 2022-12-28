package week9;

import java.util.LinkedList;

public class LinkedAct2 {

	public static void main(String args[]) {

		LinkedList<Integer> list1 = new LinkedList<>();
		list1.add(1);
		list1.add(3);
		list1.add(4);
		list1.add(5);

		System.out.println("Original List: " + list1);

		System.out.println("\nAdding to the list at an index: ");
		nthIndex(list1, 1, 2);

		System.out.println("\nRemoving the last element: ");
		plates(list1);

		System.out.println("\nRemoving the first element: ");
		rollerCoaster(list1);

		System.out.println("\nDeleting an element from the list: ");
		del(list1, 7);

	}

	private static void nthIndex(LinkedList<Integer> list, int index, int data) {
		// TODO Auto-generated method stub

		LinkedList<Integer> newList = new LinkedList<>();
		int count = 0;

		for (int i = 0; i < list.size(); i++) {

			if (index == count) {
				newList.add(data);
			}

			newList.add(list.get(i));
			count++;
		}

		System.out.println(newList);

	}

	private static void plates(LinkedList<Integer> list) {
		// TODO Auto-generated method stub
		LinkedList<Integer> newList = new LinkedList<>();

		for (int i = 0; i < list.size() - 1; i++) {
			newList.add(list.get(i));
		}
		System.out.println(newList);
	}

	private static void rollerCoaster(LinkedList<Integer> list) {
		// TODO Auto-generated method stub

		LinkedList<Integer> newList = new LinkedList<>();

		for (int i = 1; i < list.size(); i++) {
			newList.add(list.get(i));
		}
		System.out.println(newList);

	}

	private static void del(LinkedList<Integer> list, int data) {
		// TODO Auto-generated method stub

		LinkedList<Integer> newList = new LinkedList<>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == data) {
				list.remove(i);
			} else {
			
				System.out.println("item cannot be removed because the item could not found");

			}			
		}

		System.out.println(list);

	}

}
