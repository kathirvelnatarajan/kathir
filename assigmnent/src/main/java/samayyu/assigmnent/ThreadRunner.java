package samayyu.assigmnent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadRunner implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Thread thread = new Thread(new ThreadRunner());
		Thread thread1 = new Thread(new ThreadRunner());
		Thread thread2= new Thread(new ThreadRunner());
		Thread thread3= new Thread(new ThreadRunner());
		Thread thread4 = new Thread(new ThreadRunner());*/
	ExecutorService es =	Executors.newFixedThreadPool(10);
	for(int i = 0;i<100;i++) {
	es.submit(new ThreadRunner());
	}
		/*thread.start();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();*/
	}

	public void run() {
		// TODO Auto-generated method stub
		for(int i =0 ; i<100;i++) {
		ThreadTest.instance().add(String.valueOf(Math.random()));
		ThreadTest.instance().search("x");
		System.out.println(Thread.currentThread().getName()+" "+ i );
		}
		}

}
