package searchalgorithms;

public class InterpolationSearch {
	  static int arr[] = new int[]{10, 12, 13, 16, 18, 19, 20, 21, 22, 23,
              24, 33, 35, 42, 47};
	  public static int interpolationSearch(int x) {
		  int low =0;
		  int high = arr.length-1;
		  while(low <= high && x>= arr[low] && x<=arr[high]) {
			  int pos = low + (((high-low)/(arr[high]-arr[low]))*(x-arr[low]));
			  if(arr[pos] == x) {
				  return pos;
			  }
			  if(arr[pos] < x) {
				  low = pos +1;
			  }
			  else
				  high = pos - 1;
		  }
		  return -1;
		  
		  
	  }

	public static void main(String[] args) {
		 int x = 18;
         int index = interpolationSearch(x);
         if (index != -1)
            System.out.println("Element found at index " + index);
         else
            System.out.println("Element not found.");

	}

}
