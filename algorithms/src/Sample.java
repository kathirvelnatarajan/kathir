import java.util.Arrays;
import java.util.Collections;

public class Sample {
	static int[] rearrange(int[] elements) 
    {
    return bubbleSort(elements);

    }
	public static int[] bubbleSort(int[] a) {
		for(int i=0;i<a.length;i++) {
			for(int j =0; j<a.length-i-1; j++) {
				if(doCompare(a[j] , a[j+1])) {
					int temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}
	public static boolean doCompare(int left, int right) {
		String l = Integer.toBinaryString(left);
		String r = Integer.toBinaryString(right);
		int countl = 0;
		int countr=0;
		for(int i=0;i<l.length();i++) {
			if(l.charAt(i) == '1') {
				countl++;
			}
		}
		for(int j=0;j<r.length();j++) {
			if(r.charAt(j) == '1') {
				countr++;
			}
		}
		if(countl == countr) return left>right;							
		return countl>countr;
		
	}
public static void main(String[] args) {
	int[] i = {5,3,7,10,14};
	int[] res = rearrange(i);
	for(int j=0; j<res.length;j++) {
		System.out.println(res[j]);
	}
}
}
