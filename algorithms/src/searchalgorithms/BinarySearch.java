package searchalgorithms;

import java.util.LinkedList;
import java.util.Scanner;

public class BinarySearch {
	public static void bubbleSort(int[] a) {
		for(int i=0;i<a.length;i++) {
			for(int j =0; j<a.length-i-1; j++) {
				if(a[j] > a[j+1]) {
					int temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				}
			}
		}
	}
	public static int binarySearch(LinkedList<Integer> l , int low, int high, int x) {
		int mid = low + (high - low) /2;
		
		if(low<=high) {
		if(l.get(mid) == x) {
			return l.indexOf(x);
			
		}
		if (x < l.get(mid)) {
			return binarySearch(l, low, mid-1, x);
		}
		else {
			return binarySearch(l, mid+1, high, x);
		}
		}
		
		return -1;
		
	}

	public static void main(String[] args) {
		BinarySearch b = new BinarySearch();
		LinkedList<Integer> l = new LinkedList<>();
		int[] a = {50,65,89,35,21,65};
		b.bubbleSort(a);
		for(int i = 0;i<a.length;i++) {
			 System.out.println(a[i]);
		}
		for(int i = 0; i<a.length; i++) {
			l.add(i, a[i]);
		}
		int low = 0;
		int high = l.size()-1;
		int result = b.binarySearch(l, low, high, 65);
		if(result == -1) {
			System.out.println("element is not present");
		}else
		System.out.println(result);
		

	}

}



