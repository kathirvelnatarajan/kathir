package samayyu.assigmnent;

import java.util.HashMap;

public class Execute {

	public static void main(String[] args) {
		Employee e = new Employee("kat",25);
		Employee e1 = new Employee("kat",30);
		Employee e2 = new Employee("kat",25);
		HashMap<Employee, Integer> map = new HashMap<Employee, Integer>();
		map.put(e, 25);
		map.put(e1, 30);
		map.put(e2, 26);
		System.out.println(map);
		System.out.println(e.equals(e2));
		System.out.println(e.hashCode());
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());

	}

}
