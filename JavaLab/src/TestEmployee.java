
public class TestEmployee {

	public static void main(String[] args) {

		int a = 1; // 宣告
		Employee emp = new Employee(); // 產生物件
		emp.empno = 1;// 設定值到empno中
		emp.name = "Vincent";
		System.out.println("員工編號:" + emp.empno);// 取值

		Employee emp2 = new Employee(); // 產生物件
		emp2.empno = 2;
		emp2.name = "Andy";
		System.out.println("員工編號:" + emp2.empno+","+"名字:"+ emp2.name);// 取值

		System.out.println(emp == emp2);
		//指向的物件之記憶體是否相同，指向的物件是否同一個;false
		
		emp2 = emp; //都指向emp
		System.out.println(emp == emp2);
		//指向的物件之記憶體是否相同，指向的物件是否同一個;true
		emp = null; //清空原有物件的記憶體位址
		emp2 = null;
		//System.out.println(emp.name);//物件變數是null，不能使用，否則有執行錯誤
		
	}

}
