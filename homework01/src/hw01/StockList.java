package hw01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is a subclass of ArrayList<TeslaStock> and will contain the methods necessary to display various
 * @author angy xajil CIN : 400304005 CS 2013-05
 *
 */
public class StockList extends ArrayList<TeslaStock> {

	/**
	 * Default constructor
	 */
	public StockList() {

	}

	/**
	 * This method prints each stock in the StockList to an output file.
	 */
	public void printAllStocks() {

		/*
		 * Creates an output file called all_stock_data.txt
		 */
		try {

			FileWriter out = new FileWriter("all_stock_data.txt");

			/**
			 * Loops through the array and prints each object
			 */

			for (int i = 0; i < StockList.this.size(); i++) {

				out.write(StockList.this.get(i).toString());

			}

			out.flush();
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * This method displays the first 10 stocks in the StockList in a nice and easy
	 * to read format onto the console.
	 */
	public void displayFirstTenStocks() {

		for (int i = 0; i < 10; i++) {
			System.out.println(StockList.this.get(i).toString());

		}

	}

	/*
	 * This method displays the last 10 stocks in the StockList in a nice and easy
	 * to read format onto the console.
	 */
	public void displayLastTenStocks() {

		for (int i = StockList.this.size() - 1; i > StockList.this.size() - 11; i--) {

			System.out.println(StockList.this.get(i).toString());

		}
	}

	/*
	 * This method takes no parameters and returns a double value. This method
	 * computes and returns the average opening price of all stock data in the
	 * StockList.
	 */
	public double computeAverageOpeningPrice() {

		/**
		 * allOpen holds openingPrice of all stocks
		 * itemCount counts the amount of item being iterated through
		 * avgOpen calculates average using allOpen and itemCount
		 */
		double allOpen = 0;
		double itemCount = 0;
		double avgOpen;

		for (int i = 0; i < StockList.this.size(); i++) {

			allOpen += StockList.this.get(i).getOpeningPrice();

			itemCount++;
		}

		avgOpen = (allOpen / itemCount);

		return avgOpen;
	}

	/**
	 * This method takes no parameters and returns a double value. This method
	 * computes and returns the average opening price of all stock data in the
	 * StockList.
	 * 
	 * @return the average closing price of all stocks
	 */
	public double computeAverageClosingPrice() {

		/**
		 * allClose holds closingPrice of all stocks
		 * itemCount counts the amount of items being iterated through
		 * avgClose calculates the average using
		 * allClose and itemCount
		 */

		double allClose = 0;
		double itemCount = 0;
		double avgClose;

		for (int i = 0; i < StockList.this.size(); i++) {

			allClose += StockList.this.get(i).getClosingPrice();

			itemCount++;
		}

		avgClose = (allClose / itemCount);

		return avgClose;
	}

	/**
	 * This method takes no parameters and returns a TeslaStock object.
	 * This method computes and returns the maximum high price of all stocks
	 * 
	 * @return the Tesla Stock object with the highest price in all stock data
	 */
	public TeslaStock findMaxHighPrice() {

		TeslaStock highestPrice = StockList.this.get(0); 

		double maxHighValue = highestPrice.getHighPrice();

		for (int i = 1; i < StockList.this.size(); i++) {
			
			TeslaStock tmp = StockList.this.get(i);

			if (maxHighValue < tmp.getHighPrice()) {

				maxHighValue = tmp.getHighPrice();

				highestPrice = tmp;

			}

		}

		return highestPrice;
	}

	/**
	 * This method takes no parameters and returns a single TeslaStock object.
	 * This method computes and returns the minimum low price of all the stock
	 * data.
	 * 
	 * @return the Tesla Stock object with the lowest price in all stock data
	 */
	public TeslaStock findMinLowPrice() {

		TeslaStock lowestPrice = StockList.this.get(0);

		double minLowValue = lowestPrice.getLowPrice();

		for (int i = 1; i < StockList.this.size(); i++) {
			
			TeslaStock tmp = StockList.this.get(i);

			if (minLowValue > tmp.getLowPrice()) {

				minLowValue = tmp.getLowPrice();

				lowestPrice = tmp;

			}

	
		}

		return lowestPrice;
	}

}