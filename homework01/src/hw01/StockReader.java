package hw01;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class reads and parses the .csv file of stock information.
 * 
 * @author angy xajil CIN : 400304005 CS 2013-05
 *
 */
public class StockReader {

	/**
	 * Private default constructor with no parameters
	 */

	private StockReader() {

	}

	/**
	 * This method takes a File object as a parameter and returns a StockList object
	 * once all data has been processed.
	 * 
	 * @param files is the File object
	 * @return a StockList object
	 */
	public static StockList readStockData(File files) {

		// object of type StockList
		StockList data = new StockList();

		/**
		 * validates that the given File object is a .csv file. If it is not,
		 * then this method throws an IllegalArgumentException on line 96
		 */
		if (files.getName().endsWith(".csv")) {

			/**
			 * reads the File object ("tesla_historic_stock_prices.csv" set in
			 * main) and processes all of the stock data into TeslaStock objects
			 * and store each object
			 * in a StockList
			 */
			try {

				Scanner fileReader = new Scanner(files);

				/**
				 * Ignores the first line of data containong the labels for each
				 * column of data.
				 */
				fileReader.nextLine();

				// loops through the csv file reading line by line
				while (fileReader.hasNext()) {

					String line = fileReader.next();

					/**
					 * initializing an array of Strings with the previously read
					 * line and breaks it up after each comma
					 */
					String[] tokens = line.split(",");

					/**
					 * The data must be parsed so each piece of data is correctly
					 * assigned to its respective data field in the TeslaStock
					 * class.
					 */
					String date = tokens[0];
					double openingPrice = Double.parseDouble(tokens[1]);
					double highPrice = Double.parseDouble(tokens[2]);
					double lowPrice = Double.parseDouble(tokens[3]);
					double closingPrice = Double.parseDouble(tokens[4]);

					try {

						TeslaStock tmp = new TeslaStock(date, openingPrice,
								lowPrice, highPrice, closingPrice);

						/**
						 * adds each TeslaStock object to the StockList object "data"
						 */
						data.add(tmp);

						// System.out.println(data);

					}

					/**
					 * Exception catches any incorrectly written data and ignores
					 */
					catch (IllegalArgumentException e) {
						continue;
					}

				}

				fileReader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("File not of csv type");
			System.exit(0);
		}

		return data;
	}
}
