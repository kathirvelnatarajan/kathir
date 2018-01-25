package samayyu.assigmnent;

public class Employee {
 String name;
 int age;
 public Employee(String s, int a) {
	 this.name = s;
	 this.age = a;
 }
 public Employee(String s) {
	 this.name = s;
	 
 }
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}

public String toString() {
return name;	
}

public boolean equals(Object o) {
	if(this == o) {
		return true;
	}
	if(!(o instanceof Employee)) {
		return false;
	}
	Employee e = (Employee) o;
	if(name.equals(e.name) && (age == (e.age))){
		return true;
	}
	return false;
}
public int hashCode() {
	return age+10;
}
 
}
