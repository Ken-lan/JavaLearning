package collection;

import java.util.HashSet;
import java.util.Set;

import equals.Employee;

public class TestEmployeeSet {

	public static void main(String[] args) {
		Set set = new HashSet();
		Employee e1 = new Employee("001");
		Employee e2 = new Employee("001");
		set.add(e1);
		set.add(e1);
		System.out.println(set.add(e2));//false,e1.quals(e2) -> true
		System.out.printf("size=%d%n", set.size());
		
	}

}
