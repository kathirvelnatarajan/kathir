import java.util.Scanner;

public class Age {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of records you want to enter: ");
		int total = sc.nextInt();
		int[] date = new int[total];
		int[] month = new int[total];
		int[] year = new int[total];
		String[] name = new String[total];
		int age, count =0;
		for(int i=0;i<total;i++) {
			name[i] = sc.next();
			date[i]= sc.nextInt();
			month[i]=sc.nextInt();
			year[i] = sc.nextInt();
		}
		for(int j =0;j<total;j++) {
			System.out.println(name[j]+" DOB ="+date[j]+"/"+month[j]+"/"+year[j]);
		}
		for(int k=0;k<total;k++) {
			 age = 2018-year[k];
			 if(age>=18) {
				 count++;
			 }
		}
		System.out.println("Number of eligible students are: "+count);

	}

}
