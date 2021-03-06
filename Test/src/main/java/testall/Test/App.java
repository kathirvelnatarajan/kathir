package testall.Test;

import java.util.Arrays;
import java.util.Stack;



/**
 * Hello world!
 *
 */
public class App 
{
	public static int losOf2(String x, String y, int m, int n) {
		int[][] array = new int[m+1][n+1];
		for(int i =0 ;i<=m;i++) {
			for(int j =0;j<=n;j++) {
				if(i== 0 || j ==0) {
					array[i][j] = 0;
				}
			
				else if(x.charAt(i-1) == y.charAt(j-1)) {
					array[i][j] = array[i-1][j-1]+1;
				}else
					array[i][j] = max(array[i-1][j], array[i][j-1]);
			}
		}
		return array[m][n];
	}
	public static int max(int a, int b)
	{
		return (a > b)? a : b;
	}
	public static boolean balanceCheck(String s) {
		Stack<Character> collection = new Stack<Character>();
		for(int i =0; i<s.length();i++) {
			if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
				collection.push(s.charAt(i));
			}
			if(s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == ']') {
				if(!collection.isEmpty()) {
					if(isValid(collection.peek(),s.charAt(i))) {
						collection.pop();
					}else 
						return false;
				}else 
				return false;
			}
		}
		if(collection.isEmpty()) {
			return true;
		}else
			return false;
	}
	public static boolean isValid(char check, char para) {
		if(check =='{' && para == '}') {
			return true;
		}
		if(check =='(' && para ==')') {
			return true;
		}
		if(check == '[' && para ==']') {
			return true;
		}
		return false;
	}
	
	public static int losOf3(String q, String w, String e, int m, int n, int o) {
		int[][][] array = new int[m+1][n+1][o+1];
		for(int i =0;i<=m;i++) {
			for(int j =0;j<=n;j++) {
				for(int k =0;k<=o;k++) {
					if(i == 0 || j ==0 || k == 0 ) {
						array[i][j][k] =0;
					}
					else if((q.charAt(i-1) == w.charAt(j-1)) && (q.charAt(i-1) == e.charAt(k-1))) {
						array[i][j][k] = array[i-1][j-1][k-1]+1;
					}
					else
						array[i][j][k] = Math.max(Math.max(array[i-1][j][k], array[i][j-1][k]), array[i][j][k-1]);
				}
			}
		}
		return array[m][n][o];
	}
	public static int value(char s) {
		if(s == 'M') {
			return 1000;
		}
		if(s == 'D') {
			return 500;
		}
		if(s == 'C') {
			return 100;
		}
		if(s == 'L') {
			return 50;
		}
		if(s == 'X') {
			return 10;
		}
		if(s == 'V') {
			return 5;
		}
		if(s == 'I') {
			return 1;
		}
		return -1;
	}
	public static int convert(String a) {
	int result = 0;
	for(int i =0;i<a.length();i++) {
		int s1 = value(a.charAt(i));
		if(i+1 < a.length()) {
			int s2 = value(a.charAt(i+1));
			if(s1 >= s2) {
				result = result + s1;
			}else
				result = result+s2-s1;
			i++;
		}else
			result = result + s1;
		i++;
	}
	return result;
	}
	
	public static int find(int[] a, int toFind, int low, int high) {
		 int middle = ((high+low))/2;
		 System.out.println("Searching "+low+" "+high);
		 if(high<low) {
			 return -1;
		 }
		 if(toFind < a[middle]) {
			 return find(a,toFind,low,middle-1);
		 }
		 else if(toFind > a[middle]) {
			 return find(a,toFind,middle + 1,high);
		 
		 }
		 else {
			 return middle;
		 }
		
	}
	
	
    public static void main( String[] args )
    {
    	/*App a = new App();
    	String s ="IV";
    	System.out.println(App.convert(s));*/
    	int[] array = {45, 10 , 42, 17, 24, 35,29};
    	 Arrays.sort(array);
    	 for(int i:array) {
    	 System.out.println(i);
    	 }
    	int low = 0;
		 int high = array.length-1;
		 int search = 20;
		 int result = find(array, search, low, high);
			if(result == -1) {
				System.out.printf("Element %d not found in array",search);			
			} else {
				System.out.printf("Element %d found at index : %d ",search,result);
			}
			System.out.println("");
    }
}
