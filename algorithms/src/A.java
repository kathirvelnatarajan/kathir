import java.io.CharArrayReader;
import java.io.IOException;

public class A {
	private static int first(int a, int b) {
		if(b==0) {
			return a;
		}else {
			return second(b, a-b);
		}
	}
	private static int second(int a, int b) {
		if( a==0) {
			return b;
		}else {
			return first(b,a);
		}
	}
	int i =1;
	{
		i=2;
	}
	A(){
		i=3;
	}
	A(int i){
		this.i=i;
	}
	{
		i=4;
	}
	public void print() {
		System.out.println(i);
	}
	public static void badMethod() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		/*
		try {
			badMethod();
			System.out.println("A");
		}catch(Exception ex){
			System.out.println("B");
		}finally {
			System.out.println("C");
		}
		System.out.println("D");

	}*/
		
		
		
	}}
