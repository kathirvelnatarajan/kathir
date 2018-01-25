public class GrowableArray<T> {

T[] arr = (T[]) new Object[0];


public void add(T element) {
	
	T[] tempArr = (T[]) new Object[arr.length+1];
	for(int i=0;i<arr.length;i++) {
		tempArr[i] = arr[i];
	}
	tempArr[arr.length] = element;
	arr= tempArr;
}
public T search(T element) {
	for(int i= 0;i<arr.length;i++) {
		if(arr[i].equals(element)) {
			return arr[i];
		}
	}
	return null;
}
public void print() {
	for(int i=0;i<arr.length;i++) {
		System.out.println(arr[i]);
	}
}
}
