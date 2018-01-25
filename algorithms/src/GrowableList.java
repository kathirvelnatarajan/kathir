
public class GrowableList {
	Entry head;
public void add(int value) {
	Entry e = new Entry();
	e.value = value;
	if(e.value == 0) {
	e.next = head;
	}
}
}
