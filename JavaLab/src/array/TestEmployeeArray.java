package array;

public class TestEmployeeArray {

	public static void main(String[] args) {

		Employee [] emps = new Employee[2];
		/*
		Employee emp1 = new Employee();
		emp1.empno=1;
		emp1.name = "Vinecent";
		emps[0] = emp1;
		*/
		emps[0] = new Employee();
		emps[0].empno = 1;
		emps[0].name = "Vincent";
		
		System.out.println(emps[0].name);
		//emps[].name => 0900.name
		
		Employee emp2 = new Employee();
		emp2.name = "David";
		emp2.empno = 2;
		emps[1] = emp2;
		
		for(int i = 0; i <emps.length; i++) {
			System.out.printf("員工編號:%d,姓名:%s%n",emps[i].empno,emps[i].name);
		}
	}

}
