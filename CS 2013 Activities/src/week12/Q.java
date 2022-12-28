package week12;

import java.util.LinkedList;
import java.util.Queue;

public class Q {

	public static void main(String[] args) {

		Queue<String> q = new LinkedList<String>();
		q.add("purple");
		q.add("herbs");

		unique(q);
	}

	public static int unique(Queue<String> list) {

		int index = 0;

		for (String elem : list) {
			// System.out.println(elem);
			
			

			for (int i = 0; i < elem.length(); i++) {
				// System.out.println(elem.charAt(i));

				for (int j = i + 1; j < elem.length(); j++) {
					// System.out.println(elem.charAt(j));

					if (elem.charAt(i) == elem.charAt(j)) {

						System.out.println(elem.charAt(i));
					}
				}
			}
		}

		return index;
	}

}
