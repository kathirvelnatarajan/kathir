 package samayyu.assigmnent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class StockQuoteKey implements Comparable {
	String ticker,key;

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	@Override
	public int hashCode() {
		return (ticker+key).hashCode();
	}
	@Override
	public boolean equals(Object object) {
		if(this == object) {
			return true;
		}
		if(object == null) {
			return false;
		}
		if(!(object instanceof StockQuoteKey)) {
			return false;
		}
		StockQuoteKey sqk = (StockQuoteKey) object;
		if(ticker.equals(sqk.ticker) && (key.equals(sqk.key))  ){
			return true;
		}
		return false;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		StockQuoteKey sqk =(StockQuoteKey) o;
		if(ticker.compareTo(sqk.ticker) != 0) {
			return ticker.compareTo(sqk.ticker);
		}
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return  sd.parse(key).compareTo(sd.parse(sqk.key));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return key.compareTo(sqk.key);
		
	

	}
	public String toString() {
		return ticker+key;
	}

}
