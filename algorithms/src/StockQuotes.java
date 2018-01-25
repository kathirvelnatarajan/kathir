public class StockQuotes {
	 String date;
	 double price;
	 
public String toString() {
	return date+" "+price;
}
public boolean equals(Object o) {
	StockQuotes s = (StockQuotes) o;
	return (o instanceof StockQuotes && s.date.equals(date) && s.price == price);
}
}

class TickerQuotes {
	String ticker;
	GrowableArray<StockQuotes> quotes = new GrowableArray<>();
	public String toString() {
		return ticker+" "+ quotes;
	}
	public boolean equals(Object o) {
		TickerQuotes t = (TickerQuotes) o;
		return (o instanceof TickerQuotes && t.ticker.equals(ticker));
	}
}

/*class GrowableTickerQuotes{
	TickerQuotes[] ticker = new TickerQuotes[0];
	public void add(TickerQuotes t) {
		TickerQuotes[] temp = new TickerQuotes[ticker.length+1];
		for(int i =0;i<ticker.length;i++) {
			temp[i] = ticker[i];
		}
		temp[ticker.length] = t;
		ticker = temp;
	}
	
	public TickerQuotes search(String temp) {
		for(int i =0;i<ticker.length;i++) {
			TickerQuotes t = ticker[i];
			if(t.ticker.equals(temp)) {
				return t;
			}
		}
		return null;
	}
	
	
	public void highTicker() {
		GrowableHighQuotes ghq = new GrowableHighQuotes();
		for(int i=0;i<ticker.length;i++) {
			StockQuotes[] s = ticker[i].quotes.dateAndPrice();
			for(int j =i+1;j<ticker.length;j++) {
				StockQuotes[] s1 = ticker[j].quotes.dateAndPrice();
				for(int k=0;k<s.length;k++) {
					for(int l=0;l<s1.length;l++) {
						if(s[k].date.equals(s1[l].date)) {
							if(s[k].price > s1[l].price) {
							ghq.searchAdd(ticker[i].ticker, s[k].date, s[k].price);
							}else {
							ghq.searchAdd(ticker[j].ticker, s1[l].date, s1[l].price);
							}				
						}
					}
				}
			}
		}
		ghq.printHigh();
	}
	
	public void printAll() {
		for(int i=0;i<ticker.length;i++) {
			System.out.println(ticker[i].ticker);
			ticker[i].quotes.printAll();
			System.out.println("The average for ticker: "+ticker[i].ticker+" is = "+ticker[i].quotes.avg());
			System.out.println("The highest price for date is: "+ticker[i].quotes.high());
		}
		
	}
}*/
