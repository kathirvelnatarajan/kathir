package samayyu.assigmnent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.omg.Messaging.SyncScopeHelper;

public class Processor {
	public static Map<StockQuoteKey,Double> readFile(File f) throws Exception{
		Map<StockQuoteKey,Double> map = new TreeMap<StockQuoteKey, Double>();
	BufferedReader br = new BufferedReader(new FileReader(f));
	String line;
	StockQuote sq =null;
	br.readLine();
	while((line=br.readLine()) != null) {
		//	System.out.println(line);
			StockQuoteKey sqk =new StockQuoteKey();
			sq = parse(line);
			sqk.setTicker(sq.getStockTicker());
			sqk.setKey(sq.getDate());
			System.out.println(map.put(sqk,sq.getPrice()));
			}
	br.close();
		return map;
	}
	public static StockQuote parse(String line) {
		String[] coloumn = line.split(",");
		StockQuote sq = new StockQuote();
		sq.setDate(coloumn[0]);
		sq.setPrice(Double.parseDouble(coloumn[1]));
		sq.setStockTicker("AAPL");
		return sq;
	}
	public static void main(String[] args) {
		File f = new File("C:\\Users\\kathi\\Desktop\\AAPL.csv");
		try {
			Map<StockQuoteKey,Double> map =Processor.readFile(f);
			Iterator iter = map.keySet().iterator();
			while( iter.hasNext() ) {
				System.out.println( iter.next());
			}
			
			System.out.println(map.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


