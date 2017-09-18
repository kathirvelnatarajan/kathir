package threadtest;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Processor implements Runnable {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		executor.submit(new Processor());

	}

	public void run() {
		StockQuote sq = (StockQuote)Thread.currentThread();
		MovingAverage ma = (MovingAverage)Thread.currentThread();
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
