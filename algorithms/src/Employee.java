import java.util.Scanner;

public class Employee {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number of Employees: ");
	int emp = sc.nextInt();
	int[] id = new int[emp];
	double[] salary = new double[emp];
	String[] name = new String[emp];
	double max = 0.0;
	for(int i=0;i<emp;i++) {
		name[i] =sc.next();
		id[i] = sc.nextInt();
		salary[i] = sc.nextDouble();
	}
	for(int j=0;j<salary.length;j++) {
		for(int p=0;p<10;p++) {
		salary[j]=salary[j]+(salary[j] * 0.1);
		}
		System.out.println("The incremented salary for employee "+name[j]+" is = "+salary[j]);
	}
	for(int k=0;k<salary.length;k++) {
		if(salary[k] > max) {
			max = salary[k];
		}
	}
	System.out.println("The highest salary paid after 10 years "+max);
		

	}

}

