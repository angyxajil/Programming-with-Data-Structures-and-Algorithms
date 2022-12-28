package hw01;

/**
 * 
 * This class represents each stock's data from the csv file
 * 
 * @author angy xajil CIN : 400304005 CS 2013-05
 *
 */

public class TeslaStock {

	/**
	 * private data fields for the date, opening price, low price, high price,
	 * and closing price of a stock.
	 */

	private String date;
	private double openingPrice;
	private double lowPrice;
	private double highPrice;
	private double closingPrice;

	/**
	 * Default constructor
	 */
	public TeslaStock() {

	}

	/**
	 * TeslaStock class constructor, passes data from main class
	 * 
	 * @param date         is the date value
	 * @param openingPrice is the value for the opening price
	 * @param lowPrice     is the value for the low price
	 * @param highPrice    is the value for the high price
	 * @param closingPrice is the value for the closing price
	 * 
	 */
	public TeslaStock(String date, double openingPrice, double lowPrice, double highPrice, double closingPrice) {

		this.date = date;
		this.openingPrice = openingPrice;
		this.lowPrice = lowPrice;
		this.highPrice = highPrice;
		this.closingPrice = closingPrice;

	}

	/**
	 * Getters and setters for each data field.
	 */
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getOpeningPrice() {
		return openingPrice;
	}

	public void setOpeningPrice(double openingPrice) {
		this.openingPrice = openingPrice;
	}

	public double getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}

	public double getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}

	public double getClosingPrice() {
		return closingPrice;
	}

	public void setClosingPrice(double closingPrice) {
		this.closingPrice = closingPrice;
	}

	/**
	 * This method creates a String representation of this class by displaying
	 * the chosen data fields.
	 *
	 * @return The String representing a TeslaStock object
	 */
	@Override
	public String toString() {

		String format = "\n\nDate\t\t: " + this.date + "\nOpening Price\t: " + this.openingPrice + "\nHigh Price\t: "
				+ this.highPrice + "\nLow Price\t: " + this.lowPrice + "\nClosing Price\t: " + this.closingPrice;

		return format;

	}

}
