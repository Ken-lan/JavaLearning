package test;

public class Employee {
	private String name;
	public Employee(String name) {
			this.name = name; 
  }
	
	public static void main(String[] args) {
		int age = 18;
		Employee emp = new Employee("Vincent");
		Employee emp2 = new Employee("David");
	}

}
