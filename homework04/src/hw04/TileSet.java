package hw04;

import java.io.*;
import java.util.*;

/**
 * This class represents an the set of all tiles and contains the methods
 * necessary to read tile information from the txt file, create and add to our
 * array of all tiles, and call our TileSolver class.
 * 
 * @author angy xajil CS2013-05 CIN: 400304005
 *
 */

public class TileSet {

	/*
	 * array list holding all our tile objects
	 */
	ArrayList<Tile> allTiles;

	/**
	 * Method that reads from the txt file and adds it to our tile set
	 * 
	 * @param fname string of the file we want to read
	 * @return tile set object with added tiles
	 */
	public static TileSet LoadTiles(String fname) {
		TileSet ts = new TileSet();
		try {
			BufferedReader bis = new BufferedReader(new FileReader(fname));
			/**
			 * for loop for 7 tiles
			 */
			for (int i = 1; i < 8; i++) {
				String s = bis.readLine();
				/**
				 * Tile to be added.
				 */
				Tile t = new Tile();
				/**
				 * call assign method with the string we just read and the tile number
				 */
				t.assign(s, i);
				/**
				 * Adds the tile to the array list (number and sideData)
				 */
				ts.AddTile(t);
			}
			bis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ts;
	}

	/*
	 * Default constructor
	 */
	private TileSet() {
		allTiles = new ArrayList<Tile>();
	}

	/**
	 * Method that takes a Tile object and adds it to our array of all Tiles
	 * 
	 * @param t is a Tile object
	 */
	private void AddTile(Tile t) {
		allTiles.add(t);
	}

	/**
	 * Method that calls the Solve method in the TileSolver class
	 * 
	 * @param solSet is a boolean that determines solution printing
	 */
	public void Solve(boolean solSet) {
		TileSolver.Solve(allTiles, solSet);
	}

}