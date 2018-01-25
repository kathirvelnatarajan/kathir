
class HighQuotes {
	String ticker;
	String date;
	double price;
	public String toString() {
		return ticker+" "+date+" "+price;
	}
}

class GrowableHighQuotes {
	HighQuotes[] hq = new HighQuotes[0];
	public HighQuotes search(String t, String d, double p) {
		for(int i=0;i<hq.length;i++) {
			HighQuotes h = hq[i];
			if(h.date.equals(d) ){
				if(h.price < p) {
					h.ticker = t;
					h.price = p;
					return h;
				}else {
					return h;
				}
			}
		}
		return null;
}
	
	public void add(HighQuotes h) {
		HighQuotes[] thq = new HighQuotes[hq.length+1];
		for(int i=0;i<hq.length;i++) {
			thq[i] = hq[i];
		}
		thq[hq.length] = h;
		hq = thq;
	}
	
	public void searchAdd(String t, String d, double p) {
		HighQuotes hqt = search(t,d,p);
		if(hqt == null) {
			HighQuotes h = new HighQuotes();
			h.ticker = t;
			h.date = d;
			h.price = p;
			add(h);
		}
	}
	
	public void printHigh() {
		for(int i=0;i<hq.length;i++) {
			System.out.println(hq[i].ticker+" has a highest price of "+hq[i].price+" on : "+hq[i].date);
		}
	}
}
