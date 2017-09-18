package memorytest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WithTree {
	
public int toFind(Set treeSet, int k){
	long start =System.currentTimeMillis();
	int n = 0;
	Iterator<Integer> i = treeSet.iterator();
	System.out.println("iterating........");
	while(i.hasNext()) {
		 n = i.next();
		if(n == k) {
		n = k;
		}
		
	}
	System.out.println("found");
	System.out.println((System.currentTimeMillis() - start));
return n;
}
	public static void main(String[] args) {
			
		Set<Integer> treeSet = new HashSet<Integer>();
		System.out.println("adding......");
		for(int i=0;i<3738430;i++) {
			treeSet.add(i);
			System.out.println(i);
		}
		System.out.println("added!!");
		WithTree w =new WithTree();
		int k = 9999999;
		System.out.println(w.toFind(treeSet,k));
		
	}

}
