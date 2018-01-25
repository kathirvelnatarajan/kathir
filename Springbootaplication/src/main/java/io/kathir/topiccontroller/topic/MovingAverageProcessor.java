package io.kathir.topiccontroller.topic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.yaml.snakeyaml.tokens.DirectiveToken;

import assignment1.DataAccessManager;
import assignment1.MovingAvgQuote;
import assignment1.StockQuote;



public class MovingAverageProcessor {
	static Connection connection = null;
	public static Connection getConnection()throws Exception{
		if(connection == null)
		{
			synchronized (MovingAverageProcessor.class) {
				if(connection== null)
				{
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://Salesdb3Admin.db.3009048.hostedresource.com/Salesdb3Admin","Salesdb3Admin","Welcome@77");
					
				}
			}
		}
		return connection;
	}
	public List<MovingAverage> setMovingAverage() throws Exception{
		List<MovingAverage> list = new LinkedList<MovingAverage>();
		Connection cn = getConnection();
		PreparedStatement ps = cn.prepareStatement("SELECT * from stock_mov_average");
		ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		String ticker ="AAPL";
		String date = rs.getString(3);
		int average = rs.getInt(4);
		MovingAverage ma = new MovingAverage();
		ma.setStockTicker(ticker);
		ma.setDate(date);
		ma.setAverage(average);
		list.add(ma);
	}
	return list;
	}
	public static LinkedList calculate(int nodays ,String ticker) throws Exception {
		/*LinkedList ll= new LinkedList();
		HashMap<String, Double> map = new HashMap<String, Double>();
		
		Collections.sort(quotes);
		for (int j = nodays-1; j < quotes.size(); j++) {
			double sum = 0;
			StockQuote sq = (StockQuote) quotes.get(j);
			List ab = quotes.subList(j-(nodays-1), j);
			for (int i = 0; i < ab.size(); i++) {
				StockQuote stock = (StockQuote) ab.get(i);

				sum += stock.getPrice();
			}
			double average = sum / nodays;
		MovingAvgQuote ma = new MovingAvgQuote();
		ma.setStockTicker(sq.getStockTicker());
		ma.setAverage(average);
		ma.setNodays(nodays);
		ma.setQuoteDate(sq.getQuoteDate());
			map.put(sq.getQuoteDate(), average);
			ll.add(ma);
			//System.out.println("Ten day moving average : " + sq.getQuoteDate() + " " + average);

		}
		return ll;*/
	}
	
	public static void main(String[] args) {
		MovingAverageProcessor map =new MovingAverageProcessor();
		try {
			System.out.println(map.setMovingAverage().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
