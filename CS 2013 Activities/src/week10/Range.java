package week10;

import java.util.LinkedList;
import java.util.Queue;

public class Range {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer> q = new LinkedList<Integer>();

		q.add(3);
		q.add(8);
		q.add(1);
		q.add(6);
		q.add(2);
		q.add(9);

		LeftandRight(0, 2, q);

	}

	public static void LeftandRight(int left, int right, Queue<Integer> list) {

		System.out.println(list.toString());

		Queue<Integer> q2 = new LinkedList<Integer>();

		for (int s = 0; s < 6; s++) {
			if (s >= left && s <= right) {
				int item = list.poll();

				q2.add(item);
			}

			else {
				list.remove();
			}

		}

		System.out.println(q2);

		int sum = 0;

		for (int s = 0; s < 3; s++) {

			int item2 = q2.poll();

			sum = +item2;

		}

		System.out.println(sum);
	}

}
