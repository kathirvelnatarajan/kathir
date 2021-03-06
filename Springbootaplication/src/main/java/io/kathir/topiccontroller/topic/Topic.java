package io.kathir.topiccontroller.topic;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.websocket.server.PathParam;

import io.kathir.topiccontroller.topic.DatabaseManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





@RestController
@EnableAutoConfiguration
public class Topic {
	@Autowired
	DatabaseManager dm ;
	
	
	@RequestMapping("/hello")
public String sayHi() {
	return "hi";
}
	@RequestMapping("/topic")
	public List<TopicString> topicName(){
			return Arrays.asList(new TopicString(01,"Tiger","About Animal"),new TopicString(02,"Rose","About Flowers"),
					
					new TopicString(01,"JAVA","About programming")
					);
	}
	@RequestMapping("/stocks")
	public List<String> getAllStocks() throws Exception{
		File f = new File("C:\\Users\\kathi\\Desktop\\AAPL.csv");
		List<String> list = new LinkedList<String>();
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line;
		while((line = br.readLine()) != null) {
			list.add(line);
		}
		return list;
	}
	@RequestMapping("/movingaverage")
		public List<MovingAverage> setMovingAverage() throws Exception{
			List<MovingAverage> list = new LinkedList<MovingAverage>();
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://Salesdb3Admin.db.3009048.hostedresource.com/Salesdb3Admin","Salesdb3Admin","Welcome@77");
			PreparedStatement ps = cn.prepareStatement("SELECT * from stock_mov_average");
			ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String ticker = rs.getString(2);
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
	@RequestMapping("/fetchAllAverage")
	public List<MovingAverage> getMovingAverage(@RequestParam("ticker") String tick) throws Exception{
		return dm.fetchAverage(tick);
	}
	@RequestMapping("/fetchAllAveragePath/{ticker}/{check}")
	public List<MovingAverage> getMovingAverageFromParam(@PathVariable("ticker") String tick) throws Exception{
		System.out.println("Ticker = "+tick);
		return dm.fetchAverage(tick);
	}
	@RequestMapping("/fetchStockQuotes")
	public String getStockQuote(@RequestParam("ticker") String stockTicker) throws Exception{
		List<StockQuote> l = dm.fetchStockQuotes(stockTicker);
		List<StockQuote> ll = new LinkedList<StockQuote>();
		String str="<html><body><table border=3><tr><td>No</td><td>Date</td><td>ticker</td><td>price</td>";
		SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
		Set<StockQuote> set =  new LinkedHashSet<StockQuote>();
		set.addAll(l);
		Iterator<StockQuote> it =set.iterator();
		while(it.hasNext()) {
			ll.add( it.next());
		}
		for(int i=0;i<ll.size();i++){
			StockQuote sq = (StockQuote)ll.get(i);
			str +="<tr><td>"+(i+1)+"</td><td>"+sd.parse(sq.getDate())+"</td><td>"+sq.getTicker()+"</td><td>"+sq.getPrice()+"</td></tr>";
		}
		str +="</table></body></html>";
				return str;
	}
	
	public List calculate(int noOfDays, String ticker) {
			List ll= new LinkedList();
			Map<String, Double> map = new HashMap<String, Double>();
			List<StockQuote> quotes = dm.fetchStockQuotes(ticker);
			Collections.sort(quotes);
			for (int j = noOfDays-1; j < quotes.size(); j++) {
				double sum = 0;
				StockQuote sq = (StockQuote) quotes.get(j);
				List ab = quotes.subList(j-(noOfDays-1), j);
				for (int i = 0; i < ab.size(); i++) {
					StockQuote stock = (StockQuote) ab.get(i);

					sum += stock.getPrice();
				}
				double average = sum/noOfDays;
				MovingAverage ma = new MovingAverage();
			ma.setStockTicker(sq.getTicker());
			ma.setAverage(average);
			
			ma.setDate(sq.getDate());
				map.put(sq.getDate(), average);
				ll.add(ma);
			}
			return ll;
		}
	
	
	
	
	}

