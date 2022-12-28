package week8;

import java.util.LinkedList;

public class LinkedActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Adding 2 Linked Lists: ");
		addition();
		
		System.out.println("\nRemoving duplicates from a linked list: ");
		removeDup();
		
		System.out.println("\nCounting the number of times a  number appears in a linked list: ");
		LinkedList<Integer> inst = new LinkedList<>();
		inst.add(2);
		inst.add(5);
		inst.add(3);
		inst.add(5);
		inst.add(2);
		inst.add(3);
		inst.add(3);
		inst.add(7);
		System.out.println("Data Set: " + inst);
		countInst(inst, 3);
		countInst(inst, 2);
		countInst(inst, 5);
		countInst(inst, 7);
		countInst(inst, 11);

	}

	public static void addition() {

		LinkedList<Integer> list1 = new LinkedList<>();
		list1.add(1);
		list1.add(4);
		list1.add(5);
		System.out.println("list 1: " + list1);

		LinkedList<Integer> list2 = new LinkedList<>();
		list2.add(6);
		list2.add(2);
		list2.add(3);
		System.out.println("list 2: " + list2);

		LinkedList<Integer> fList = new LinkedList<>();

		for (int i = 0; i < 3; i++) {

			int data1;
			data1 = list1.get(i);
			// System.out.println(data1);

			int data2;
			data2 = list2.get(i);
			// System.out.println(data2);

			fList.add(data1 + data2);
		}

		System.out.println("Added List: " + fList);

	}

	public static void removeDup() {

		LinkedList<Integer> dupe = new LinkedList<>();
		dupe.add(2);
		dupe.add(7);
		dupe.add(3);
		dupe.add(5);
		dupe.add(2);
		dupe.add(3);
		
		System.out.println(dupe);

		LinkedList<Integer> newList = new LinkedList<>();
		
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 5; j++) {

				int og = dupe.get(i);
				//System.out.println(og);
				
				int dub = dupe.get(j);
				//System.out.println(dub);

				if (og == dub) {
					newList.add(og);
				}
			}
		}

		System.out.println(newList);
	}

	public static void countInst(LinkedList<Integer> inst, int digit) {
		
		int count = 0;
		
		for (int i = 0 ; i < 8; i++) {
			int data = inst.get(i);
			
			if (digit == data) {
				count++;
			}
		}
		
		System.out.println("The number " + digit + " appears in the linked list " + count + " time(s)");
	}
}
