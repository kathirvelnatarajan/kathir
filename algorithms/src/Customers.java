import java.util.Scanner;

public class Customers {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the number of customers : ");
		int cus = sc.nextInt();
		int[] id = new int[cus];
		int[] price = new int[cus];
		int[] quantity = new int[cus];
		String[] name = new String[cus];
		int total[] =new int[cus];
		int max = 0;
		for(int i=0;i<cus;i++) {
			name[i]= sc.next();
			id[i]=sc.nextInt();
			price[i] = sc.nextInt();
			quantity[i] = sc.nextInt();
		}
		for(int j=0;j<cus;j++) {
			total[j] = price[j] * quantity[j];
			System.out.println("Total price for customer "+name[j]+" is = "+total[j]);
			}
		for(int k=0;k<total.length;k++) {
			if(total[k]>max) {
				max = total[k];
			}
		}
		System.out.println("The highest amount of transaction is "+max);

	}

}
