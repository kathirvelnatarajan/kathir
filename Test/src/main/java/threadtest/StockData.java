package threadtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class StockData  {

	static List<MovingAverage> maList = new LinkedList<MovingAverage>();
	static List<StockQuote> sqList = new LinkedList<StockQuote>();
	final static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	final ReentrantReadWriteLock lock2 = new ReentrantReadWriteLock();
public static List getStockQuotes(String ticker) throws Exception {
	lock.readLock().lock();
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn =DriverManager.getConnection("jdbc:mysql://Salesdb3Admin.db.3009048.hostedresource.com/Salesdb3Admin\",\"Salesdb3Admin\",\"Welcome@77");
	PreparedStatement st= conn.prepareStatement("Select * from stock_quotes where stock_ticker=?");
	ResultSet rs	= st.executeQuery();
	st.setString(1,ticker);
	ResultSetMetaData rsmd = rs.getMetaData();
	while(rs.next()){
	String stock = rs.getString(2);
	String date = rs.getString(3);
	Double price = rs.getDouble(4);
	StockQuote quote = new StockQuote();
	quote.setStockTicker(stock);
	quote.setQuoteDate(date);
	quote.setPrice(price);
		sqList.add(quote);
	 }
	lock.readLock().unlock();
	return sqList;
	
}

public  boolean setStockQuotes(List quote, String ticker) throws Exception{
	
	lock2.writeLock().lock();
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn =DriverManager.getConnection("jdbc:mysql://Salesdb3Admin.db.3009048.hostedresource.com/Salesdb3Admin\",\"Salesdb3Admin\",\"Welcome@77");
	java.sql.PreparedStatement st=conn.prepareStatement("insert into stock_quotes "
			+ "(stock_ticker,quote_date, price) values(?,?,?)");
	for(int i=0; i<quote.size(); i++){
		StockQuote sq= (StockQuote) quote.get(i);
		st.setString(1, ticker);
		st.setString(2, sq.getQuoteDate());
		st.setDouble(3, sq.getPrice());
	st.executeBatch();
}
	lock2.writeLock().unlock();
	return true;
	
}

public  List<MovingAverage> getMovingAverage(String ticker)throws Exception{
	lock.readLock().lock();
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn =DriverManager.getConnection("jdbc:mysql://Salesdb3Admin.db.3009048.hostedresource.com/Salesdb3Admin\",\"Salesdb3Admin\",\"Welcome@77");
		PreparedStatement sp = conn.prepareStatement("Select * from stock_mov_average");
	ResultSet sr = sp.executeQuery();
	while(sr.next()) {
		String symbol =sr.getString(2);
		double average = sr.getDouble(4);
		String date = sr.getString(3);
		int nodays = sr.getInt(5);
		MovingAverage ma = new MovingAverage();
		ma.setTicker(ticker);
		ma.setAverage(average);
		ma.setNoOfDates(nodays);
		ma.setDate(date);
		maList.add(ma);
	}
	lock.readLock().unlock();
	return maList;
} 

public  boolean setMovingAverage(List quotes)throws Exception{
	
	lock2.writeLock().lock();	
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn =DriverManager.getConnection("jdbc:mysql://Salesdb3Admin.db.3009048.hostedresource.com/Salesdb3Admin\",\"Salesdb3Admin\",\"Welcome@77");
	PreparedStatement ps=conn.prepareStatement("insert into stock_mov_average (stock_ticker,quote_date, avg_value, noof_days) values(?,?,?,?)");
	int i=0;
	for(; i<quotes.size(); i++){
	MovingAverage maq= (MovingAverage) quotes.get(i);
	ps.setString(1, maq.getTicker());
	ps.setString(2, maq.getDate());
	ps.setDouble(3, maq.getAverage());
	ps.setInt(4, maq.getNoOfDates());
	ps.executeUpdate();
	
	}
	
	lock2.writeLock().unlock();
	return true;
}



}
