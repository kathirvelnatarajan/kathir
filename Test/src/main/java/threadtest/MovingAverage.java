package threadtest;

public class MovingAverage extends Thread {
	private String ticker;
	private String date;
	private double average;
	private int noOfDates;
	public int getNoOfDates() {
		return noOfDates;
	}
	public void setNoOfDates(int noOfDates) {
		this.noOfDates = noOfDates;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}

}
