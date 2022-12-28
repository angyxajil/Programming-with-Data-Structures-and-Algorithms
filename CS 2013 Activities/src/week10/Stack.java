package week10;

public class Stack {

	public static void main(String[] args) {

	}

	private class Node {
		public int data;
		public Node next;

		public Node() {
			next = null;
		}
	}

	Node head;

	public Stack() {
		head = null;
	}

	public void Push(int data) {
		// 1. Create a new node.
		Node n1 = new Node();
		// 2. Store the data in the new node.
		n1.data = data;
		// 3. Set the new node's reference to the current head.
		n1.next = head;
		// 4. Set the head reference to the new node.
		head = n1;
	}

	public int Pop() {
		// 1. Special Case: Head is null.
		int data = 0;
		// Hint: See Peek.
		if (head != null) {
			// 2. Store the data from the current head.
			data = head.data;
			// 3. Set the head reference to the current head's next reference.
			head = head.next;
		}
		// 4. Return the data.
		return data;
	}
	
	public int Min() {
		
		int min = 0;
		
		return min;
		
	}
}