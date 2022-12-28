package hw04;

/**
 * This class represents an individual tile and contains the methods necessary
 * to assign tile information from the txt file, assign colors, rotate, and
 * match the tile data.
 * 
 * @author angy xajil CS2013-05 CIN: 400304005
 *
 */

public class Tile {

	/*
	 * array to hold all data from the tile sides;
	 */
	private Color[] sideData;
	/**
	 * integer to hold position number
	 */
	private int pos;
	/**
	 * integer to hold the tile number
	 */
	private int num;

	/*
	 * Default constructor sets the sideData array to 6 because our tiles have 6
	 * sides; setting each side of the tile as color k and setting at position 0
	 * with no rotations;
	 */
	public Tile() {
		sideData = new Color[6];
		for (int i = 0; i < 6; i++) {
			sideData[i] = Color.K;
		}
		pos = 0;
	}

	/*
	 * Copy constructor that takes in a Tile t as a parameter to add to our solution
	 * copies all side data, tile number, and position number (:
	 */
	public Tile(Tile t) {
		sideData = new Color[6];
		for (int i = 0; i < 6; i++) {
			sideData[i] = t.sideData[i];
		}
		pos = t.pos;
		num = t.num;
	}

	/**
	 * Method that takes a String init and an integer v as parameters and assigns
	 * colors to the array
	 * 
	 * @param init string from txt file
	 * @param v    is the tile number
	 */
	public void assign(String init, int v) {
		/**
		 * previously initialized "num" now equals our parameter v which is the tile
		 * number
		 */
		num = v;
		/**
		 * String init is now a substring from index of ":" + 2 (where the letters start
		 * to the end of the string)
		 */
		init = init.substring(init.indexOf(':') + 2, init.length());
		/**
		 * all commas in that substring are removed
		 */
		init = init.replaceAll(",", "");
		/*
		 * reading through the 6 colors and putting them into the sideData array
		 */
		for (int i = 0; i < 6; i++) {
			switch (init.charAt(i)) {
			case 'R':
				sideData[i] = Color.R;
				break;
			case 'O':
				sideData[i] = Color.O;
				break;
			case 'Y':
				sideData[i] = Color.Y;
				break;
			case 'G':
				sideData[i] = Color.G;
				break;
			case 'B':
				sideData[i] = Color.B;
				break;
			case 'P':
				sideData[i] = Color.P;
				break;
			/**
			 * if color cannot be changed from K, error in file reading or formatting
			 */
			default:
				sideData[i] = Color.K;
				System.out.println("Error initializing tile colors.");
				break;
			}
		}

		/**
		 * no position since it has not been placed yet
		 */
		pos = 0;
	}

	/*
	 * Method that shifts the array left by 1, which rotates our tile
	 */
	void rotate() {
		Color LastColor = sideData[5];
		for (int i = 5; i > 0; i--) {
			sideData[i] = sideData[i - 1];
		}
		sideData[0] = LastColor;
	}

	/**
	 * Method that returns rotation count an integer, updates
	 * 
	 * @return integer rotation count
	 */

	/**
	 * 
	 * Method containing a switch case that assigns sideData indexes to sides a - f
	 * i.e(index 0 is side a, index 1 is side b, ...)
	 *
	 * @param s is a side
	 * @return color at specified index
	 */
	public Color color(Side s) {
		switch (s) {
		case SA:
			return sideData[0];
		case SB:
			return sideData[1];
		case SC:
			return sideData[2];
		case SD:
			return sideData[3];
		case SE:
			return sideData[4];
		case SF:
			return sideData[5];
		default:
			return Color.K;
		}
	}

	/**
	 * Method that takes 2 tiles objects as parameters (the previously placed tile
	 * and the center tile) and matches the appropriate sides
	 * 
	 * Or, if previous tile is in position x, match and place position x + 1
	 *
	 * @param prev   is the previously placed tile
	 * @param center is the center tile (position 1)
	 * @return a boolean value
	 */
	public boolean Match(Tile prev, Tile center) {
		/**
		 * position of the tile previously placed is set as the condition for the switch
		 * statement
		 */
		switch (prev.Pos()) {
		/*
		 * Match position 2 tile side D to previous position tile side A
		 */
		case 1:
			return color(Side.SD) == center.color(Side.SA);
		/**
		 * Match position 3 tile side E with center position tile side B and side F with
		 * previous tile side C
		 */
		case 2:
			return color(Side.SE) == center.color(Side.SB) && color(Side.SF) == prev.color(Side.SC);
		case 3:
			return color(Side.SF) == center.color(Side.SC) && color(Side.SA) == prev.color(Side.SD);
		case 4:
			return color(Side.SA) == center.color(Side.SD) && color(Side.SB) == prev.color(Side.SE);
		case 5:
			return color(Side.SB) == center.color(Side.SE) && color(Side.SC) == prev.color(Side.SF);
		case 6:
			return color(Side.SC) == center.color(Side.SF) && color(Side.SD) == prev.color(Side.SA);
		/**
		 * in case we are attempting to place an 8th tile
		 */
		case 7:
			System.out.println("ERROR: Attempted to place tile after last tile.");
			return false;
		default:
			System.out.println("ERROR: Attempted to place tile at invalid position " + (prev.Pos() + 1) + ".");
		}
		return false;
	}

	/*
	 * Setter for position value
	 */
	public void Place(int p) {
		pos = p;
	}

	/**
	 * Getter for position value
	 * 
	 * @return the position of the tile
	 */
	public int Pos() {
		return pos;
	}

	/**
	 * Method to remove tiles from the board
	 */
	public void Remove() {
		pos = 0;
	}

	/*
	 * Implements the toString method that return the formatted tile object
	 */
	public String toString() {

		String outString = "Position " + pos + ": Tile #" + num + ":";

		for (int i = 0; i < 6; i++) {
			outString += "\t" + sideData[i];
		}

		outString += "\n";

		return outString;
	}
}