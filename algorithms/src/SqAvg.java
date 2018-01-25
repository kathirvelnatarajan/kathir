public class SqAvg {
	
	public static void main(String[] args) {
	String quotes = "AAPL,12/15/2017,30#GOOG,10/15/2017,180#"
			+ "AAPL,10/15/2017,45#GOOG,10/15/2017,300"
			+ "#NAP,15/15/2017,120#SAP,12/15/2017,160"
			+ "#AAPL,10/20/2017,100#AAPL,10/26/2017,200"
			+ "#GOOG,15/15/2017,140";
	String[] indQuotes = quotes.split("#");
	/*GrowableTickerQuotes gtq = new GrowableTickerQuotes();*/
	GrowableArray<TickerQuotes> tickerQuotes = new GrowableArray<>();
	TickerQuotes t = new TickerQuotes();
	for(int i = 0 ;i<indQuotes.length;i++) {
		String[] s1= indQuotes[i].split(",");
		t.ticker = s1[0];
		String date = s1[1];
		String price = s1[2];
	TickerQuotes tq = tickerQuotes.search(t);
	if(tq == null) {
		tq= new TickerQuotes();
		tq.ticker = t.ticker;
		tickerQuotes.add(tq);
	}
	StockQuotes stock = new StockQuotes();
		stock.date = date;
		stock.price = Double.parseDouble(price);
		tq.quotes.add(stock);
		}
	/*gtq.printAll();
    gtq.highTicker();*/
	tickerQuotes.print();
	}
	
}

