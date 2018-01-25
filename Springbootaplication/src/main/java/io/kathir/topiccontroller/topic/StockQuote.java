package io.kathir.topiccontroller.topic;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.management.RuntimeErrorException;

public class StockQuote implements Comparable {
	private String ticker;
	private String date;
	private double price;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int compareTo(Object o) {
		StockQuote sq = (StockQuote) o;
		final String dateFormat = "MM/dd/yyyy";
		SimpleDateFormat df = new SimpleDateFormat(dateFormat);
		try {
			return (df.parse(date).compareTo(df.parse(sq.getDate())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("parsing error"+ date+ " "+ sq.getDate());
		}
	}

}
