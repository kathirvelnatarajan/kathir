package threadtest;

public class StockQuote extends Thread {
	private String stockTicker;
	private String quoteDate;
	private double price;
	public String getStockTicker() {
		return stockTicker;
	}
	public void setStockTicker(String stockTicker) {
		this.stockTicker = stockTicker;
	}
	public String getQuoteDate() {
		return quoteDate;
	}
	public void setQuoteDate(String quoteDate) {
		this.quoteDate = quoteDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	

}
