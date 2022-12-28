package hw01;

import java.io.File;

/**
 * 
 * Main class that executes each StockList method and creates a .txt file of
 * TeslaStock objects and prints First ten stock, last ten stocks, average
 * opening price, average closing price, maximum high price and minumum low price
 */

/**
 * 
 * @author angy xajil CIN : 400304005 CS 2013-05
 *
 */

public class Main {

	public static void main(String[] args) {

		StockList list = new StockList();

		/**
		 * File object linked to the .csv file
		 */
		File files = new File("src/files/tesla_historic_stock_prices.csv");

		/**
		 * passes csv file to StockReader class
		 */
		list = StockReader.readStockData(files);

		/**
		 * Executes each method from the StockList class and show the results
		 * of each method
		 */
		list.printAllStocks();
		

		System.out.println("First Ten Stocks");
		list.displayFirstTenStocks();

		System.out.println("--------------------------------------------------");

		System.out.println("\n");
		System.out.println("Last Ten Stocks");
		list.displayLastTenStocks();

		System.out.println("--------------------------------------------------");
		System.out.println("Average Opening Price: ");
		double averageOpen = list.computeAverageOpeningPrice();
		System.out.printf("%,.4f", averageOpen);

		System.out.println("\n------------------------------------------------");
		System.out.println("Average Closing Price: ");
		double averageClose = list.computeAverageClosingPrice();
		System.out.printf("%,.4f", averageClose);

		System.out.println("\n------------------------------------------------");
		System.out.println("Maximum High Price: ");
		TeslaStock maxHigh = list.findMaxHighPrice();
		System.out.println(maxHigh);

		System.out.println("\n------------------------------------------------");
		System.out.println("Minimum Low Price: ");
		TeslaStock minLow = list.findMinLowPrice();
		System.out.println(minLow);

	}

}
