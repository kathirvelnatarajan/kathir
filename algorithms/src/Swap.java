

public class Swap {
	public static void main(String[] args) {
		int[] a = {3,6,7,9};
		for(int i=0;i<a.length;i=i+2) {
			for(int j=i+1;j<i+2;j++) {
				int temp = a[j];
				a[j]=a[i];
				a[i]= temp;
			}
		}
		for(int k=0;k<a.length;k++) {
			System.out.println(a[k]);
		}

	}

}
