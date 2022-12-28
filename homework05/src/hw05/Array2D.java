package hw05;

import java.util.ArrayList;

/**
 * This is a generic class that contains the methods to manipulate the 2D Linked
 * List
 * 
 * @author angy xajil; CS 2013-05; CIN: 400304005
 *
 * @param <E>
 */

public class Array2D<E> {

	/**
	 * The number of rows.
	 */
	private int rowSize;

	/**
	 * The number of columns.
	 */
	private int colSize;

	/**
	 * This is an Array2DNode reference, which refers to the node at position (0,0)
	 * in the array.
	 */
	protected Array2DNode<E> head;

	/**
	 * rThis is a Array2DNode reference, which points to the node at the beginning
	 * of the last row. This reference will help to make implementing some of the
	 * methods easier.
	 */
	protected Array2DNode<E> rowTail;

	/**
	 * This is a Array2DNode reference, which points to the node at the beginning of
	 * the last column.
	 */
	protected Array2DNode<E> colTail;

	/**
	 * Default constructor which has 0 rows and 0 columns. The head and tail
	 * references start at null. The Array2D at this point has no nodes in it.
	 */
	public Array2D() {
		rowSize = 0;
		colSize = 0;
		head = null;
		rowTail = null;
		colTail = null;
	}

	/**
	 * Constructor which takes a normal 2D array as an argument and uses the
	 * dimensions of the 2D array to create the linked structure, while at the same
	 * time copying the values from the E[][] array into the linked array.
	 */
	public Array2D(E[][] values) {
		/**
		 * head points to the first element in the 2D array
		 */
		head = new Array2DNode(values[0][0]);

		/**
		 * Because there is only one element, that element is also the row and column
		 * tail
		 */
		rowTail = head;
		colTail = head;

		/**
		 * we now have one column and one row
		 */
		colSize++;
		rowSize++;

		/**
		 * populating the 2D Linked List with the values from the 2D Array
		 */
		for (int i = 1; i < values[0].length; i++) {
			/**
			 * adding elements column by column, left to right
			 */
			addLastCol(values[0][i]);
		}

		for (int i = 1; i < values.length; i++) {
			/**
			 * adding elements row by row, top to bottom
			 */
			addLastRow(values[i]);
		}
	}

	/**
	 * This method adds a new column of nodes, populated with data from the values
	 * parameter, to the beginning of the data structure. All the nodes in the new
	 * column are connected to each other vertically, as well as to the existing
	 * first column horizontally. It is verified that the number of values passed
	 * into the method parameter, matches the current number of rows. If not, an
	 * IllegalArgumentException is thrown.
	 * 
	 * @param values are generic type being added
	 */
	public void addFirstCol(E... values) {
		/**
		 * if the 2D linked list has the correct number of rows
		 */
		if (values.length == rowSize) {
			/**
			 * create a variable to track the current head node
			 */
			Array2DNode currentNode = head;
			/**
			 * create a variable to track the new nodes being added
			 */
			Array2DNode newNode = new Array2DNode(values[0]);
			/**
			 * changing the head to the new head
			 */
			head = newNode;
			/**
			 * linking the new head to the old head
			 */
			head.nextCol = currentNode;

			/**
			 * traversing through rows to add each element in the new column
			 */
			for (int i = 1; i < rowSize; i++) {
				/**
				 * moving to the next row
				 */
				currentNode = currentNode.nextRow;
				/**
				 * create a variable to track the value at i in the new column
				 */
				Array2DNode currentValue = new Array2DNode(values[i]);
				/*
				 * moving to the next row in the column we are adding
				 */
				newNode.nextRow = currentValue;
				/**
				 * linking the elements in the the column being added to the entire next column
				 */
				currentValue.nextCol = currentNode;
				/**
				 * updating the nodes to move downward accordingly
				 */
				newNode = currentValue;
			}

			/**
			 * update the rowTail
			 */
			rowTail = newNode;
			/**
			 * increase the column size
			 */
			colSize++;

			/**
			 * in case the number of values does not match the number of rows
			 */
		} else {
			throw new IllegalArgumentException("The number of values does not match the current number of rows");
		}

	}

	/**
	 * This method adds a new row of nodes, populated with data from the values
	 * parameter, to the beginning of the data structure. All the nodes in the new
	 * row are connected to each other horizontally, as well as to the existing
	 * first row vertically. It is verified that the number of values passed into
	 * the method parameter, matches the current number of columns. If not, then an
	 * IllegalArgumentException is thrown.
	 * 
	 * @param values are generic type being added
	 */
	public void addFirstRow(E... values) {
		/**
		 * if the 2D Linked List has the correct number of columns
		 */
		if (values.length == colSize) {
			/**
			 * node to track the current head
			 */
			Array2DNode currentNode = head;
			/**
			 * tracking the first element of the row being added
			 */
			Array2DNode newNode = new Array2DNode(values[0]);
			/**
			 * updating the head node
			 */
			head = newNode;
			/**
			 * linking the new head to the old head
			 */
			head.nextRow = currentNode;
			/**
			 * traversing through the columns to add each element in the new row
			 */
			for (int i = 1; i < colSize; i++) {
				/**
				 * moving to the next column
				 */
				currentNode = currentNode.nextCol;
				/**
				 * variable to track the current value at i in the new row
				 */
				Array2DNode currentValue = new Array2DNode(values[i]);
				/**
				 * linking the next column to the value at i
				 */
				newNode.nextCol = currentValue;
				/**
				 * linking the elements being added to the element below it
				 */
				currentValue.nextRow = currentNode;
				/**
				 * updating the new nodes to value at i to move to the right accordingly
				 */
				newNode = currentValue;
			}
			/**
			 * updating the column tail to the last added row node
			 */
			colTail = newNode;

			/**
			 * incrementing the number of rows
			 */
			rowSize++;
		} else {
			throw new IllegalArgumentException("The number of values does not match the current number of columns");
		}

	}

	/**
	 * This method adds a new column to the end of the list. This method has the
	 * same requirements as addFirstCol(), but instead of adding to the beginning,
	 * it is adding to the end.
	 * 
	 * @param values are generic type being added
	 */
	public void addLastCol(E... values) {

		/**
		 * if the 2D Linked List has the correct number of rows
		 */
		if (values.length == rowSize) {
			/**
			 * node to track the beginning of the last column
			 */
			Array2DNode currentNode = colTail;
			/**
			 * tracking the first element of the values being added
			 */
			Array2DNode newNode = new Array2DNode(values[0]);
			/**
			 * linking the current column tail to the new node
			 */
			colTail.nextCol = newNode;
			/**
			 * updating the column tail to the beginning of the last column being added
			 */
			colTail = newNode;
			/**
			 * traversing through the rows to add each element in the new column
			 */
			for (int i = 1; i < rowSize; i++) {
				/**
				 * moving to the next row
				 */
				currentNode = currentNode.nextRow;
				/**
				 * variable to track the current value at i in the new row
				 */
				Array2DNode currentValue = new Array2DNode(values[i]);
				/**
				 * linking the next row to the value at i
				 */
				newNode.nextRow = currentValue;
				/**
				 * linking the elements being added to the element next to it
				 */
				currentNode.nextCol = currentValue;
				/**
				 * updating the new nodes to value at i to move downward accordingly
				 */
				newNode = currentValue;
			}

			/**
			 * incrementing the column size
			 */
			colSize++;

		} else {
			throw new IllegalArgumentException("The number of values does not match the current number of rows.");
		}
	}

	/**
	 * This method adds a new row to the end of the list. This method has the same
	 * requirements as addFirstRow(), but instead of adding to the beginning, it is
	 * adding to the end.
	 * 
	 * @param values are generic type being added
	 */
	public void addLastRow(E... values) {
		/**
		 * if the 2D Linked List has the correct number of columns
		 */
		if (values.length == colSize) {
			/**
			 * node to track the current row tail
			 */
			Array2DNode currentNode = rowTail;
			/**
			 * tracking the first element of the row being added
			 */
			Array2DNode newNode = new Array2DNode(values[0]);
			/**
			 * linking the element under the row tail to the first value being added in the
			 * new row
			 */
			rowTail.nextRow = newNode;
			/**
			 * updating the row tail
			 */
			rowTail = newNode;
			/**
			 * incrementing the number of rows
			 */
			rowSize++;
			/**
			 * traversing through the columns to add each element in the new row
			 */
			for (int i = 1; i < colSize; i++) {
				/**
				 * moving to the next column
				 */
				currentNode = currentNode.nextCol;
				/**
				 * variable to track the current value at i in the new row
				 */
				Array2DNode currentValue = new Array2DNode(values[i]);
				/**
				 * linking the next column to the value at i
				 */
				newNode.nextCol = currentValue;
				/**
				 * linking the elements being added to the element below it
				 */
				currentNode.nextRow = currentValue;
				/**
				 * updating the new nodes to value at i to move to the right accordingly
				 */
				newNode = currentValue;
			}

		} else {
			throw new IllegalArgumentException("The number of values does not match the current number of columns");
		}
	}

	/**
	 * This method inserts a column of values at the given index. This method does
	 * not replace an existing column, but performs an insertion where it makes room
	 * for the new column. The new column contains the given values. The nodes of
	 * the new column are connected to each other vertically as well as horizontally
	 * to the columns on either side of it. Three special cases are considered: when
	 * it is inserted at index 0, insert anywhere in the middle, or insert at the
	 * end. It is verified that the number of values passed into the values
	 * parameter, matches the current number of rows. If not, then an
	 * IllegalArgumentException is thrown. It is also verified that the index is
	 * within bounds of the column indexes. If not, then an IllegalArgumentException
	 * is thrown.
	 * 
	 * @param index  the insertion point
	 * @param values are generic type being added
	 */
	public void insertCol(int index, E... values) {
		/**
		 * if the index is out of bounds, an IllegalArgumentException is thrown.
		 */
		if (index < 0 || index > colSize) {
			throw new IndexOutOfBoundsException(
					"Index " + index + "is out of bounds. Index must be between 0 and " + colSize);
		}
		/**
		 * if the chosen index is the last column
		 */
		else if (index == colSize) {
			/**
			 * call the add lost column method
			 */
			addLastCol(values);
			/**
			 * or if the chosen index is 0
			 */
		} else if (index == 0) {
			/**
			 * call the add first column method
			 */
			addFirstCol(values);
			/**
			 * if the chosen index is neither of these
			 */
		} else {
			/**
			 * create a node that starts at the head
			 */
			Array2DNode bIndex = head;
			/**
			 * tracking the first element of the col being added
			 */
			Array2DNode newNode = new Array2DNode(values[0]);
			/**
			 * traversing through columns until we get to the one before the chosen index
			 */
			for (int i = 0; i < index - 1; i++) {
				/**
				 * moving to the next column
				 */
				bIndex = bIndex.nextCol;
			}
			/**
			 * create a second node that is currently at the index chosen to insert
			 */
			Array2DNode aIndex = bIndex.nextCol;
			/**
			 * linking the column at index - 1 to the new column
			 */
			bIndex.nextCol = newNode;
			/**
			 * linking the new column to the column previously at that index
			 */
			newNode.nextCol = aIndex;
			/**
			 * increment the column size
			 */
			colSize++;
			/**
			 * traversing through the elements of the new column
			 */
			for (int i = 1; i < values.length; i++) {
				/**
				 * moving to the next row in column at index - 1
				 */
				bIndex = bIndex.nextRow;
				/**
				 * moving to the next row in column at index
				 */
				aIndex = aIndex.nextRow;
				/**
				 * variable to track the current value at i in the new column
				 */
				Array2DNode currentValue = new Array2DNode(values[i]);
				/**
				 * linking the next row to the value at i
				 */
				newNode.nextRow = currentValue;
				/**
				 * linking the elements being added to the element next to it
				 */
				bIndex.nextCol = currentValue;
				/**
				 * linking the element to the the element in column at index + 1
				 */
				currentValue.nextCol = aIndex;
				/**
				 * updating the new nodes to value at i to move downward accordingly
				 */
				newNode = currentValue;
			}
		}
	}

	/**
	 * This method inserts a row of values at the given index. This method does not
	 * replace an existing row, but performs an insertion where it makes room for
	 * the new row. The new row contains the given values. The nodes of the new row
	 * are connected to each other vertically as well as horizontally to the row on
	 * either side of it. Three special cases are considered: when it is inserted at
	 * index 0, insert anywhere in the middle, or insert at the end. It is verified
	 * that the number of values passed into the values parameter, matches the
	 * current number of columns. If not, then an IllegalArgumentException is
	 * thrown. It is also verified that the index is within bounds of the row
	 * indexes. If not, then an IllegalArgumentException is thrown.
	 * 
	 * @param index  the insertion point
	 * @param values are generic type being added
	 */
	public void insertRow(int index, E... values) {
		if (index < 0 || index > rowSize) {
			throw new IndexOutOfBoundsException(
					"Index " + index + "is out of bounds. Index must be between 0 and " + rowSize);
		}
		/**
		 * if the chosen index is the last column
		 */
		else if (index == rowSize) {
			/**
			 * call the add lost column method
			 */
			addLastRow(values);
			/**
			 * or if the chosen index is 0
			 */
		} else if (index == 0) {
			/**
			 * call the add first column method
			 */
			addFirstRow(values);
			/**
			 * if the chosen index is neither of these
			 */
		} else {
			/**
			 * create a node that starts at the head
			 */
			Array2DNode bIndex = head;
			/**
			 * tracking the first element of the row being added
			 */
			Array2DNode newNode = new Array2DNode(values[0]);
			/**
			 * traversing through rows until we get to the one before the chosen index
			 */
			for (int i = 0; i < index - 1; i++) {
				/**
				 * moving to the next row
				 */
				bIndex = bIndex.nextRow;
			}
			/**
			 * create a second node that is currently at the index chosen to insert
			 */
			Array2DNode aIndex = bIndex.nextRow;
			/**
			 * linking the row at row - 1 to the new column
			 */
			bIndex.nextRow = newNode;
			/**
			 * linking the new row to the row previously at that index
			 */
			newNode.nextRow = aIndex;
			/**
			 * increment the row size
			 */
			rowSize++;
			/**
			 * traversing through the elements of the new row
			 */
			for (int i = 1; i < values.length; i++) {
				/**
				 * moving to the next row in row at index - 1
				 */
				bIndex = bIndex.nextCol;
				/**
				 * moving to the next row in column at index
				 */
				aIndex = aIndex.nextCol;
				/**
				 * variable to track the current value at i in the new row
				 */
				Array2DNode currentValue = new Array2DNode(values[i]);
				/**
				 * linking the next column to the value at i
				 */
				newNode.nextCol = currentValue;
				/**
				 * linking the elements being added to the element next to it
				 */
				bIndex.nextRow = currentValue;
				/**
				 * linking the element to the the element in row at index + 1
				 */
				currentValue.nextRow = aIndex;
				/**
				 * updating the new nodes to value at i to move to the right accordingly
				 */
				newNode = currentValue;
			}
		}
	}

	/**
	 * This method takes no parameters and returns nothing. It removes the first
	 * column of nodes from the Array.
	 */
	public void deleteFirstCol() {
		/**
		 * if the column size is less than or equal to zero,
		 */
		if (colSize <= 0) {
			/**
			 * throw an exception
			 */
			throw new IllegalArgumentException("There is no column to delete");
		} else {
			/**
			 * create a node that starts at the head
			 */
			Array2DNode currentHead = head;
			/**
			 * create a node that starts at the node under the head
			 */
			Array2DNode headRow = head.nextRow;
			/**
			 * create a node that starts at the node to the right of the head
			 */
			Array2DNode headCol = head.nextCol;

			/**
			 * moving the head one column to the right
			 */
			head = headCol;
			/**
			 * decrementing the column size
			 */
			colSize--;
			/**
			 * traversing through rows
			 */
			for (int i = 1; i < rowSize; i++) {
				/**
				 * removing nodes in the first column
				 */
				currentHead.nextCol = null;
				currentHead.nextRow = null;
				currentHead = headRow;
				/**
				 * moving to the next row of the deleted column
				 */
				headRow = headRow.nextRow;
				/**
				 * moving to the next row of the new first column
				 */
				headCol = headCol.nextRow;
			}

			/**
			 * updating the row tail
			 */
			rowTail = headCol;
		}
	}

	/**
	 * This method takes no parameters and returns nothing. It removes the first row
	 * of nodes from the Array
	 */
	public void deleteFirstRow() {
		/**
		 * if the row size is less than or equal to zero,
		 */
		if (rowSize <= 0) {
			/**
			 * throw an exception
			 */
			throw new IllegalArgumentException("There is no column to delete");
		} else {
			/**
			 * create a node that starts at the head
			 */
			Array2DNode currentHead = head;
			/**
			 * create a node that starts at the node under the head
			 */
			Array2DNode headRow = head.nextRow;
			/**
			 * create a node that starts at the node to the right of the head
			 */
			Array2DNode headCol = head.nextCol;

			/**
			 * moving the head one row down
			 */
			head = headRow;
			/**
			 * decrementing the row size
			 */
			rowSize--;
			/**
			 * traversing through rows
			 */
			for (int i = 1; i < colSize; i++) {
				/**
				 * removing nodes in the first row
				 */
				currentHead.nextRow = null;
				currentHead.nextCol = null;
				currentHead = headCol;
				/**
				 * moving to the next row of the deleted column
				 */
				headCol = headCol.nextCol;
				/**
				 * moving to the next row of the new first column
				 */
				headRow = headRow.nextCol;
			}

			/**
			 * updating the row tail
			 */
			colTail = headRow;
		}
	}

	/**
	 * This method takes no parameters and returns nothing. It removes the last row
	 * of nodes from the Array.
	 */
	public void deleteLastCol() {
		if (colSize > 0) {
			/**
			 * track head
			 */
			Array2DNode updatedLast = this.head;
			/**
			 * traversing through columns
			 */
			for (int i = 0; i < colSize - 2; i++) {
				/**
				 * move to the next column, end at colSize - 1
				 */
				updatedLast = updatedLast.nextCol;
			}
			/**
			 * first element of the column to be removed
			 */
			Array2DNode removedNode = updatedLast.nextCol;
			/**
			 * move the column tail
			 */
			this.colTail = updatedLast;
			/**
			 * next row of the column being removed
			 */
			Array2DNode currentNode = removedNode.nextRow;
			/**
			 * while the deleted column has a next row
			 */
			while (currentNode != null) {
				/**
				 * removing links from the new last column
				 */
				updatedLast.nextCol = null;
				/**
				 * moving to the next row
				 */
				updatedLast = updatedLast.nextRow;
				/**
				 * updating nodes to remove column accordingly
				 */
				removedNode = currentNode;
				/**
				 * moving to the next row
				 */
				currentNode = currentNode.nextRow;
				/**
				 * if we have reached the end of the column being removed
				 */
				if (currentNode == null) {
					/**
					 * removing links from the new last column
					 */
					updatedLast.nextCol = null;
				}
			}
			/**
			 * decrement the column size by onw
			 */
			this.colSize--;
		} else {
			throw new IllegalStateException("There is no column to delete.");
		}
	}

	/**
	 * This method takes no parameters and returns nothing. Removes the last row of
	 * nodes from the Array.
	 */
	public void deleteLastRow() {
		if (colSize > 0) {
			/**
			 * track head
			 */
			Array2DNode updatedRow = this.head;
			/**
			 * traverse through rows
			 */
			for (int i = 0; i < rowSize - 2; i++) {
				/**
				 * move to the next column, end at rowSize - 1
				 */
				updatedRow = updatedRow.nextRow;
			}
			/**
			 * first element of the row being removed
			 */
			Array2DNode removedNode = updatedRow.nextRow;
			/**
			 * update the row tail
			 */
			this.rowTail = updatedRow;
			/**
			 * next column of the row being removed
			 */
			Array2DNode currentNode = removedNode.nextCol;
			/**
			 * while the row being removed has a next row
			 */
			while (currentNode != null) {
				/**
				 * remove links from the new last row
				 */
				removedNode.nextCol = null;
				updatedRow.nextRow = null;
				/**
				 * move to the next column
				 */
				updatedRow = updatedRow.nextCol;
				/**
				 * update node to remove columns accordingly
				 */
				removedNode = currentNode;
				/**
				 * move to the next column
				 */
				currentNode = currentNode.nextCol;
				/**
				 * if we have reached the end of the row being removed
				 */
				if (currentNode == null) {
					/**
					 * removing links from the new last row
					 */
					updatedRow.nextRow = null;
				}
			}
			/**
			 * decrement the row size
			 */
			this.rowSize--;
		} else {
			throw new IllegalStateException("There is no column to delete.");
		}
	}

	/**
	 * This method returns nothing. Removes the column of nodes from the Array at
	 * the given index. Index is validated and throw an IndexOutOfBoundsException if
	 * necessary. Three cases are considered: beginning, middle, or end of the
	 * structure.
	 * 
	 * @param index the deletion point
	 */
	public void deleteCol(int index) {
		/**
		 * if the index is out of bounds
		 */
		if (index < 0 || index > colSize) {
			/**
			 * throw an error
			 */
			throw new IllegalStateException(
					"The chosen index must 0 - " + colSize + ". " + "Index: " + index + "is out of Bounds");
		}

		/**
		 * if the chosen index is the first column
		 */
		else if (index == 0) {
			/**
			 * call the delete first column method
			 */
			deleteFirstCol();
			/**
			 * if the chosen index is the last column
			 */
		} else if (index == colSize) {
			/**
			 * call the delete last column method
			 */
			deleteLastCol();
		} else {
			/**
			 * create a node to track the column before the chosen index
			 */
			Array2DNode bColumn = this.head;
			/**
			 * traverse through columns
			 */
			for (int i = 0; i < index - 1; i++) {
				/**
				 * stop at index - 1
				 */
				bColumn = bColumn.nextCol;
			}
			/**
			 * create a node to track the column being removed
			 */
			Array2DNode removedNode = bColumn.nextCol;
			/**
			 * create a node to track the rows of the column being removed
			 */
			Array2DNode columnRow = removedNode.nextRow;
			/**
			 * create a node to track the column at index + 1
			 */
			Array2DNode nextCol = removedNode.nextCol;
			/**
			 * traverse through rows
			 */
			for (int i = 0; i < rowSize; i++) {
				/**
				 * move to the next column
				 */
				bColumn.nextCol = nextCol;
				/**
				 * move to the next row
				 */
				removedNode = columnRow;
				/**
				 * if the sandwiching columns are not null
				 */
				if (bColumn != null && nextCol != null) {
					/**
					 * move to the next row at index - 1
					 */
					bColumn = bColumn.nextRow;
					/**
					 * move to the next row at index + 1
					 */
					nextCol = nextCol.nextRow;
				}

			}

			/**
			 * decrement the size
			 */
			this.colSize--;
		}

	}

	/**
	 * This method returns nothing. Removes the row of nodes from the Array at the
	 * given index. Index is validated and throws an IndexOutOfBoundsException if
	 * necessary. Three cases are considered: when deleting from the beginning,
	 * middle, or end of the structure.
	 * 
	 * @param index is the deletion point
	 */
	public void deleteRow(int index) {
		/**
		 * if the index is out of bounds
		 */
		if (index < 0 || index > rowSize) {
			/**
			 * throw an error
			 */
			throw new IllegalStateException(
					"The chosen index must 0 - " + rowSize + ". " + "Index: " + index + "is out of Bounds");
		}

		/**
		 * if the index is the first column
		 */
		if (index == 0) {
			/**
			 * call the delete first row method
			 */
			deleteFirstRow();
			/**
			 * if the index is the last row
			 */
		} else if (index == rowSize) {
			/**
			 * call the delete last row method
			 */
			deleteLastRow();
		} else {
			/**
			 * create a node to track the row at index - 1
			 */
			Array2DNode bRow = this.head;
			/**
			 * traverse through rows
			 */
			for (int i = 0; i < index - 1; i++) {
				/**
				 * move to the next row, end at index - 1
				 */
				bRow = bRow.nextRow;
			}
			/**
			 * create a node to track the row being removed
			 */
			Array2DNode removedRow = bRow.nextRow;
			/**
			 * create a node to track the row below the removed row
			 */
			Array2DNode belowRow = removedRow.nextCol;
			/**
			 * create a node to track of the row at index + 1
			 */
			Array2DNode nextRow = removedRow.nextRow;
			/**
			 * traverse through columns
			 */
			for (int i = 0; i < colSize; i++) {
				/**
				 * move to the next row
				 */
				bRow.nextRow = nextRow;
				/**
				 * detach the row
				 */
				removedRow.nextRow = null;
				removedRow = belowRow;
				/**
				 * if the sandwiching rows are null
				 */
				if (bRow != null && nextRow != null) {
					/**
					 * move to the next column at index - 1
					 */
					bRow = bRow.nextCol;
					/**
					 * move to the next column at index + 1
					 */
					nextRow = nextRow.nextCol;
				}
			}
			/**
			 * decrement row size
			 */
			this.rowSize--;
		}

	}

	/**
	 * Returns the item at the given (rowIndex, colIndex). It is validated that
	 * rowIndex and colIndex are within bounds. Throws an IndexOutOfBoundsException
	 * if necessary.
	 * 
	 * @param rowIndex is the row number
	 * @param colIndex is the column number
	 * @return the generic item
	 */
	public E get(int rowIndex, int colIndex) {
		/**
		 * if index is out of bound, throw an exception
		 */
		if (rowIndex < 0 && rowIndex > this.rowSize && colIndex < 0 && colIndex > this.colSize) {
			throw new IndexOutOfBoundsException("Index is out of bounds.");
		}

		/**
		 * create a node to track the item
		 */
		Array2DNode genericItem = this.head;
		/**
		 * traverse through rows
		 */
		for (int i = 0; i < rowIndex; i++) {
			/**
			 * move to the next row
			 */
			genericItem = genericItem.nextRow;
		}
		/**
		 * traverse through columns
		 */
		for (int i = 0; i < colIndex; i++) {
			/**
			 * move to the next column
			 */
			genericItem = genericItem.nextCol;
		}

		/**
		 * return the item
		 */
		return (E) genericItem.getItem();
	}

	/**
	 * Returns a generic ArrayList<E> which holds the values from the requested
	 * column. It is validated that colIndex is within bounds. Throws an
	 * IndexOutOfBoundsException with an appropriate error message if necessary.
	 * 
	 * @param colIndex is the column number
	 * @return a generic ArrayList holding values from requested column
	 */
	public ArrayList<E> getCol(int colIndex) {
		/**
		 * if index is out of bound, throw an exception
		 */
		if (colIndex < 0 && colIndex > this.colSize) {
			throw new IndexOutOfBoundsException("Index is out of bounds.");
		}
		/**
		 * create a generic ArrayList which holds the values from the requested col.
		 */
		ArrayList colNode = new ArrayList<>(rowSize);
		/**
		 * create a node that starts at the head
		 */
		Array2DNode colItem = this.head;
		/**
		 * traverse through columns
		 */
		for (int i = 0; i < colIndex; i++) {
			/**
			 * move to the next column
			 */
			colItem = colItem.nextCol;
		}
		/**
		 * traverse through rows
		 */
		for (int i = 0; i < rowSize; i++) {
			/**
			 * add the items from column to the arrayList
			 */
			colNode.add(colItem.getItem());
			/**
			 * move to the next row
			 */
			colItem = colItem.nextRow;
		}
		/**
		 * return the arraylist
		 */
		return colNode;

	}

	/**
	 * Returns a generic ArrayList<E> which holds the values from the requested row.
	 * It is validated that colIndex is within bounds. Throws an
	 * IndexOutOfBoundsException with an appropriate error message if necessary.
	 * 
	 * @param rowIndex is the row number
	 * @return a generic ArrayList holding values from requested column
	 */
	public ArrayList<E> getRow(int rowIndex) {
		if (rowIndex < 0 && rowIndex > this.rowSize) {

			throw new IndexOutOfBoundsException("Index is out of bounds.");

		}

		/**
		 * create a generic ArrayList which holds the values from the requested row.
		 */
		ArrayList rowNode = new ArrayList<>(colSize);
		/**
		 * create a node that starts at the head
		 */
		Array2DNode rowItem = this.head;
		/**
		 * traverse through rows
		 */
		for (int i = 0; i < rowIndex; i++) {
			/**
			 * move to the next row
			 */
			rowItem = rowItem.nextRow;
		}
		/**
		 * traverse through columns
		 */
		for (int i = 0; i < colSize; i++) {
			/**
			 * add the items from row to the arrayList
			 */
			rowNode.add(rowItem.getItem());
			/**
			 * move to the next col
			 */
			rowItem = rowItem.nextCol;
		}
		/**
		 * return the arraylist
		 */
		return rowNode;

	}

	/**
	 * Assigns the given item to the Array2DNode at the given rowIndex and colIndex.
	 * This method replaces the any previous value stored at that location with the
	 * new value. It is validated that colIndex is within bounds. Throws an
	 * IndexOutOfBoundsException with an appropriate error message if necessary.
	 * 
	 * @param rowIndex is the row number
	 * @param colIndex is the column number
	 * @param item     in the the Array2DNode
	 */
	public void set(int rowIndex, int colIndex, E item) {
		/**
		 * create a node that starts at the head
		 */
		Array2DNode setNode = this.head;
		/**
		 * if index is out of bounds, throw an exception
		 */
		if (rowIndex < 0 && rowIndex > this.rowSize && colIndex < 0 && colIndex > this.colSize) {
			throw new IndexOutOfBoundsException("Index given is out of bounds.");
		}
		/**
		 * traverse through rows until you reach rowIndex - 1
		 */
		for (int i = 0; i < rowIndex; i++) {
			/**
			 * move to the next row (rowIndex)
			 */
			setNode = setNode.nextRow;
		}
		/**
		 * traverse through columns until you reach colIndex - 1
		 */
		for (int i = 0; i < colIndex; i++) {
			/**
			 * move to the next column (colIndex)
			 */
			setNode = setNode.nextCol;
		}
		/**
		 * set the item at rowIndex, colIndex
		 */
		setNode.setItem(item);

	}

	/**
	 * Returns the number of columns.
	 * 
	 * @return The amount of columns in the 2D linked list.
	 */
	public int colSize() {
		return this.colSize;

	}

	/**
	 * Returns the number of rows.
	 * 
	 * @return The amount of rows in the 2D linked list.
	 */
	public int rowSize() {
		return this.rowSize;

	}

	/**
	 * Add a method to return a string representation of your table, where the table
	 * is traversed col by col.
	 * 
	 * @return table column by column
	 */
	public String toStringColByCol() {
		/**
		 * create an empty string
		 */
		String sb = "";
		/**
		 * create a node to track the column
		 */
		Array2DNode currentCol = this.head;
		/**
		 * boolean to be used in while loop conditon
		 */
		boolean bool = true;
		/**
		 * outer while loop that moves by column
		 */
		while (bool == true) {
			/**
			 * create a node to track the current node
			 */
			Array2DNode current = currentCol;
			/**
			 * inner while loop that moves by row
			 */
			while (bool == true) {
				/**
				 * add the tem to the string
				 */
				sb += current.getItem() + " ";
				/**
				 * move to the next row
				 */
				current = current.nextRow;
				/**
				 * if the column node is empty
				 */
				if (current == null) {
					/**
					 * add a new line
					 */
					sb += "\n";
					/**
					 * and exit the loop
					 */
					break;
				}
			}
			/**
			 * move to the next column
			 */
			currentCol = currentCol.nextCol;
			/**
			 * if the column is empty
			 */
			if (currentCol == null) {
				/**
				 * exit the loop
				 */
				break;
			}
		}
		/**
		 * return the string
		 */
		return sb;
	}

	/**
	 * Overrides the Java toString() method to return a string representation of the
	 * table, where the table is traversed row by row.
	 */
	@Override
	public String toString() {
		/**
		 * Create an empty string
		 */
		String str = "";

		/**
		 * Create a node to track the rows
		 */
		Array2DNode row = head;
		/**
		 * boolean to use as a condition for a while loop
		 */
		boolean bool = true;
		/**
		 * outer loop that traverses through rows
		 */
		while (bool = true) {
			/**
			 * create a node to track each node within a row
			 */
			Array2DNode currentNode = row;
			/**
			 * inner loop that traverses through columns
			 */
			while (bool == true) {
				/**
				 * get the item within that node and add it to the string
				 */
				str += currentNode.getItem() + " ";
				/**
				 * move to the next column
				 */
				currentNode = currentNode.nextCol;
				/**
				 * if the current node is empty,
				 */
				if (currentNode == null) {
					/**
					 * move to the next row
					 */
					str += "\n";
					bool = false;
				}
			}
			/**
			 * move to the next row
			 */
			row = row.nextRow;
			/**
			 * if the next row is empty,
			 */
			if (row == null) {
				/**
				 * exit the loop
				 */
				break;
			}
		}

		/**
		 * return the string with all items
		 */
		return str;
	}

}