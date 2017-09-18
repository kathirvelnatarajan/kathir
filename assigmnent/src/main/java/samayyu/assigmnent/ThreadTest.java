package samayyu.assigmnent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadTest {
	private  List<String> employees ;
	final  ReentrantReadWriteLock rwl ;
	private static ThreadTest instance;
	private ThreadTest() {
		  employees = new ArrayList<String>();
		rwl = new ReentrantReadWriteLock();
	}
	public  void search(String name) {
		rwl.readLock().lock();
		
		employees.contains(name);
		
		rwl.readLock().unlock();
	}
	public  void add(String name) {
		rwl.writeLock().lock();
		employees.add(name);
		rwl.writeLock().unlock();
		
	}
	public static  ThreadTest instance() {
		if(instance == null) {
			synchronized (ThreadTest.class) {
				if(instance == null) {
				instance = new ThreadTest();		
			}
				}
		
		}
		return instance;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}/* static sync = classname.class
sync = .this*/
