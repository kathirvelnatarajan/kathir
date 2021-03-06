package samayyu.assigmnent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Hello world!
 *
 */
public class App 
{
	public int add(int a, int b) {
		return a+b;
	}
	public String word(String s) {
		
		return s;
	}
	public static int countWords(String words) {
	
	char[] c = words.toCharArray();
	int count = 1;
	for(int i =0 ; i<c.length;i++) {
	if(c[i] == ' ') {
		if(i<c.length-1 && c[i+1]>= 'a' && c[i+1] <= 'z') {
		 count++;
		}
	}}
	
		return count;
	}
	
	public static String[] stringArray(String s) {
		String[] result = s.split(" ");
		return result;
	}
	public static int sameChar(char[] x , char[] y, int m,int n) {
		if(m == 0 || n == 0) {
			return 0;
		}
		if(x[m-1] == y[n-1]) {
			return 1+sameChar(x,y,m-1,n-1);
		}
		
		else{
			return max(sameChar(x, y, m, n-1),sameChar(x, y, m-1, n));
		}
	}
	public static int max(int a,int b) {
		return(a>b)? a:b ;
	}
	public static boolean isValid(char check , char para) {
		if(check =='{' && para =='}') {
			return true;
		}
		else if(check =='(' && para ==')') {
			return true;
		}
		else if(check =='[' && para ==']') {
			return true;
		}
		return false;
	}
	public static boolean balanceCheck(String s) {
		Stack<Character> character = new Stack<Character>();
		for(int i = 0; i<s.length();i++) {
			if(s.charAt(i) == '{' || s.charAt(i)=='(' || s.charAt(i) == '[') {
				character.push(s.charAt(i));
			}
			if(s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == ']') {
				if(!character.isEmpty() ) {
					if(isValid(character.peek(),s.charAt(i))) {
						character.pop();
					}else
						return false;
				}else
				return false;
			}
		}
		if(character.isEmpty()) {
			return true;
		}else
			return false;
	}
	
	
	public static List<String> add(String words){
		 List<String> linkedList = new LinkedList<String>();
		 long start = System.currentTimeMillis();
		for(int i =0; i<10000000; i++) {
			linkedList.add(words);
		}
		long end = System.currentTimeMillis();
		long finish = end - start;
		System.out.println("time " + finish);
		return linkedList;
	}
	public static List<String> addArray(String s){
		List<String> arrayList = new ArrayList<String>();
		long start = System.currentTimeMillis();
		for(int i = 0;i<10000000;i++) {
			arrayList.add(s);
		}
		long end = System.currentTimeMillis();
		long finish = end - start;
		System.out.println("time " + finish);
		return arrayList;
	}
	public static boolean checkPara(String s) {
		Stack<Character> collection = new Stack<Character>();
		for(int i =0;i<s.length();i++) {
			if(s.charAt(i) =='{' || s.charAt(i) == '(' || s.charAt(i)=='[') {
				collection.push(s.charAt(i));
			}
			if(s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == ']') {
				if(!collection.isEmpty()) {
				if(doesValid(collection.peek(),s.charAt(i))) {
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
	public static boolean doesValid(char check , char para) {
		if(check == '{' && para =='}') {
			return true;
		}else if(check == '(' && para == ')') {
			return true;
		}else if(check == '[' && para ==']') {
			return true;
		}
		return false;
	}
	public static int lcsOf3(String a,String b, String c, int x, int y, int z) {
		int [][][] L = new int [x+1][y+1][z+1];
		for (int i = 0; i<= x; i++) {
			for(int j =0; j<=y;j++) {
				for(int k = 0;k<=z;k++) {
					if(i ==0 || j ==0|| k == 0) {
						 L [i][j][k] =0;
					}
					else if((a.charAt(i-1) == b.charAt(j-1)) &&(a.charAt(i-1) == c.charAt(k-1))) {
						 L [i][j][k] = L[i-1][j-1][k-1] + 1;
					}
				else
					L[i][j][k] = Math.max(Math.max(L[i-1][j][k], L[i][j-1][k]), L[i][j][k-1]);
			}
			}
		}return L[x][y][z];
	}
	
	public static int value(char r) {
		if(r == 'M') {
			return 1000;
		}
		if(r == 'D') {
			return 500;
		}
		if(r == 'C') {
			return 100;
		}
		if(r == 'L') {
			return 50;
		}
		if(r == 'X') {
			return 10;
		}
		if(r == 'V') {
			return 5;
		}
		if(r == 'I') {
			return 1;
		}
		return -1;
	}
	public static int returnNumber(String s) {
		int result = 0;
		for(int i =0;i<s.length();i++) {
			int s1 =value(s.charAt(i));
			if(i+1<s.length()) {
				int s2 = value(s.charAt(i+1));
			
			if(s1 >= s2) {
				result = result +s1;
			}else {
				result = result+s2-s1;
				i++;
			}
		}else {
			result = result + s1;
			i++;
		}
			}
		return result;
	}
    public static void main( String[] args )
    {
       App a = new App();
     /* String s1 = "axuyt";
      String s2 = "tyuxa";
      char[] x = s1.toCharArray();
      char[] y = s2.toCharArray();
      int m = x.length;
      int n = y.length;
      int count = App.sameChar(x, y, m, n);
      System.out.println(count);*/
       /*String words = "words";
     App.add(words);
     App.addArray(words);*/
   //  System.out.println(App.addArray(words));
    /*   List<Integer> list = new LinkedList();
       List<Integer> evenList = new LinkedList();
       List<Integer> oddList = new LinkedList();
       List<Integer> allList = new LinkedList();
       Integer temp ;
	for (int i =0; i<10;i++){
	    list.add(i);
	}
	for (int j =0 ;j<list.size();j++) {
		temp = list.get(j);
		if(temp % 2 ==0){
	    evenList.add(temp);
	    }
		else {
	    	oddList.add(temp);
	    }
      }
	allList.addAll(evenList);
	allList.addAll(oddList);
	System.out.println(allList);*/
     /*  String X = "AGGT12";
       String Y = "12TXAYB";
       String Z = "12XBA";
     
       int m = X.length();
       int n = Y.length();
       int o = Z.length();
     
       System.out.println("Length of LCS is " +
                               lcsOf3(X, Y,Z, m, n, o));*/
       System.out.println(a.returnNumber("IV"));
     
    }
}
