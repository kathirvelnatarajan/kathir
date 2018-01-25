public class GrowableStockQuotes {
StockQuotes[] s = new StockQuotes[0];

public void add(StockQuotes sq ) {
	StockQuotes[] tsq = new StockQuotes[s.length+1];
	for(int i=0;i<s.length;i++) {
		tsq[i] = s[i];
	}
	tsq[s.length] = sq;
	s=tsq;
}

public StockQuotes[] dateAndPrice() {
	
	return s;
}

public void printAll() {	
	for(int i=0;i<s.length;i++) {
		System.out.println(s[i]);		
	}
}

public double avg() {
	double count = s.length;
	double price = 0.0;
	for(int i =0;i<s.length;i++) {
		price += s[i].price;
		}
	return price/count;
}

public StockQuotes high() {
	StockQuotes stemp = new StockQuotes();
	stemp = s[0];
	for(int i=1;i<s.length;i++) {
		if(stemp.price < s[i].price) {
			stemp= s[i];			
		}
	}
	return stemp;
}
}

