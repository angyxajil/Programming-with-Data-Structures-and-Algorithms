package hw04;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * This class contains the methods necessary to solve our puzzle looking for all
 * possible solutions with different tiles in position 1 (center).
 * 
 * @author angy xajil CS2013-05 CIN: 400304005
 *
 */

public class TileSolver {

	/**
	 * Method that creates the LinkedLists necessary for the recursive method.
	 * 
	 * @param solSet is a boolean
	 */
	public static void Solve(ArrayList<Tile> tiles, boolean solSet) {
		/**
		 * creating linked lists off available tiles, used tiles, and all solutions
		 */
		LinkedList<LinkedList<Tile>> solutions = new LinkedList<LinkedList<Tile>>();
		LinkedList<Tile> usedTiles = new LinkedList<Tile>();
		LinkedList<Tile> availableTiles = new LinkedList<Tile>();

		/**
		 * loop through tiles
		 */
		for (Tile t : tiles) {
			/**
			 * tile object holding one tile
			 */
			Tile newTile = new Tile(t);
			/**
			 * putting all tiles into available linked list to use in solveR
			 */
			availableTiles.add(newTile);
		}
		/**
		 * Run the recursive method.
		 */
		int solNum = +SolveR(availableTiles, usedTiles, solutions, solSet);

		/**
		 * Special message for no solutions.
		 */
		if (solNum == 0) {
			System.out.println("No solutions exist.");
			/**
			 * When there is 1+ solutions
			 */
		} else {
			/**
			 * integer to hold solution number
			 */
			int count = 1;
			/**
			 * Print integer number of solutions message
			 */
			System.out.println("Number of solutions: " + solNum + ".");
			/**
			 * if parameter boolean is true, print all solutions
			 */
			if (solSet == true) {
				/**
				 * for each solution in our array or solutions
				 */
				for (LinkedList<Tile> solution : solutions) {
					/**
					 * Output solution header
					 */
					System.out.println(
							"Solution #" + count + "-----------------" + "---------------------------------------");
					System.out.println("\t\t\tSA\tSB\tSC\tSD\tSE\tSF");
					/**
					 * for each tile in our solutions
					 */
					for (Tile t : solution) {
						/**
						 * Output solution contents
						 */
						System.out.println(t);
					}
					/**
					 * Output solution footer
					 */
					System.out.println("---------------------------------------" + "-----------------------------");
					count++;
				}
			}
		}
	}

	/**
	 * 
	 * This method determines if a solution has been found, if a center tiles needs
	 * to be placed, and looks for all possible solutions using recursion and
	 * backtracking
	 * 
	 * @param available holds all unplaced tiles
	 * @param board     represents our board
	 * @param solutions holds all solutions
	 * @param solSet    is a boolean value
	 * @return an integer value
	 */
	private static int SolveR(LinkedList<Tile> available, LinkedList<Tile> board,
			LinkedList<LinkedList<Tile>> solutions, boolean solSet) {
		/**
		 * integer total solutions set as 0
		 */
		int solCount = 0;

		/**
		 * Base Case: if 7 tiles have been placed, copy the current solution on our
		 * board and add it our list of total solutions
		 */
		if (board.size() == 7) {
			if (solSet) {
				/**
				 * Creating a list to store our current solution
				 */
				LinkedList<Tile> sol = new LinkedList<Tile>();
				/**
				 * loop through all 7 placed tiles
				 */
				for (int j = 0; j < 7; j++) {
					/**
					 * Tile object cpy copies the tile to add to solution
					 */
					Tile cpy = new Tile(board.get(j));
					/**
					 * adding tile to solution list
					 */
					sol.add(j, cpy);
				}
				/**
				 * adding entire solution to our list of all solutions
				 */
				solutions.add(sol);
			}
			/**
			 * returning the number 1, since a solution has been found
			 */
			return 1;
		}

		/**
		 * integer to hold the number of tile available
		 */
		int n = available.size();
		/**
		 * loop through the available tiles (not placed).
		 */
		for (int i = 0; i < n; i++) {
			/**
			 * picking a tile from available list
			 */
			Tile t = available.get(i);
			/**
			 * remove placed tile from list of available tiles
			 */
			available.remove(i);

			/*
			 * Recursive Case: if not all tiles have been placed yet, place a tile in the
			 * center attempt to find a solution
			 */

			/**
			 * if the amount of placed tiles is 0,
			 */
			if (board.size() == 0) {
				/**
				 * place tile t in position 1 (center)
				 */
				t.Place(1);
				/**
				 * add it to our board
				 */
				board.addLast(t);
				/**
				 * recursive call to keep placing tiles in the center
				 */
				solCount += SolveR(available, board, solutions, solSet);
				/**
				 * done having that tile in the center
				 */
				board.removeLast();
				/**
				 * removing it from the board
				 */
				t.Remove();

				/**
				 * if we are actively looking for a solution, IP
				 */
			} else {
				/**
				 * looping through rotations
				 */
				for (int j = 0; j < 6; j++) {
					/**
					 * boolean to check the last tile placed on the board matches the center tile
					 */
					boolean val1 = t.Match(board.getLast(), board.getFirst());
					boolean val2 = true;
					/**
					 * if there are 6 tiles placed on the board,
					 */
					if (board.size() == 6) {
						/**
						 * check the third side (side B) of the last tile (position 7) matches position
						 * 2 tile's side E
						 */
						val2 = t.color(Side.SB) == board.get(1).color(Side.SE);
					}
					/**
					 * if boolean val1 is true
					 */
					if (val1 && val2) {
						/**
						 * set corresponding position for the tile
						 */
						t.Place(board.size() + 1);
						/**
						 * add to the board
						 */
						board.addLast(t);
						/**
						 * recursive call
						 */
						solCount += SolveR(available, board, solutions, solSet);
						/**
						 * if we reach a dead end, remove the last placed tile from the board
						 */
						board.removeLast();
						t.Remove();
					}

					/**
					 * rotate to try another side
					 */
					t.rotate();
				}
			}
			/**
			 * add tile back to list of available tiles
			 */
			available.add(i, t);
		}
		/**
		 * number of solutions
		 */
		return solCount;
	}

}
