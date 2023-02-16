package equals;

public class TestEquals {

	public static void main(String[] args) {
		Employee e1 = new Employee("001");
		Employee e2 = new Employee("001");
		System.out.println(e1 == e2); //true? false?
		System.out.println(e1.equals(e2));//F3
		
		e1 = null;
		System.gc();//呼叫系統執行GC
		
		System.out.println(e2);//等同於呼叫e2.toString()回傳文字
		System.out.println(e2.toString());
	}

}
