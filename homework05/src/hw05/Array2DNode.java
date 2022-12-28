package hw05;

/**
 * This is a generic class that represents the LinkedList nodes. It hold
 * directional references and stores the items within those nodes.
 * 
 * @author angy xajil; CS 2010-05; CIN: 400304005;
 *
 * @param <E>
 */
public class Array2DNode<E> {

	/**
	 * Data Fields: item: store the data here. This data field is private and should
	 * have an appropriate getter and setter if necessary. NOTE: You may make this
	 * data field protected so that your other class can access it more easily.
	 */

	private E item;

	/**
	 * nextCol and nextRow: these are your directional references to traverse your
	 * data structure. These references each point to the next node in sequence. If
	 * there is no node in a direction, the value of that reference should be null.
	 * These data fields should be protected in order to make accessing them from
	 * the Array2D class easier. These data fields should NOT have a getter or
	 * setter. No other data fields are allowed.
	 */
	protected Array2DNode<E> nextCol;
	protected Array2DNode<E> nextRow;

	/**
	 * Constructor which takes an item of any type and initializes the item data
	 * field. No other constructors are allowed.
	 */

	/**
	 * default constructor
	 */
	public Array2DNode() {

	}

	public Array2DNode(E item) {

		this.item = item;
		nextCol = null;
		nextRow = null;
	}

	/**
	 * appropriate getter and setter for data field item
	 * 
	 * @return
	 */
	public E getItem() {
		return item;
	}

	public void setItem(E data) {
		item = data;
	}
}