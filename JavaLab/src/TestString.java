
public class TestString {

	public static void main(String[] args) {
		//Java.lang.String
		String name  = "Vincent"; //0800, pool
		String name1  = "Vincent"; //0800, pool
		System.out.println(name == name1); //true
		
		String name2 = new String("Vincent"); //1000m heap not in pool
		System.out.println(name = name2);//false, 0800 == 1000
		
		name = "Hellow," + name;
		//文字的內容逐字比較，要用equals方法，不能用==
		System.out.println(name.equals(name2));
		//屬性 emp.empno 不會有括號，有括號的是方法
		
		System.out.println("Java就業養成班".length());
		System.out.println("Java就業養成班".indexOf("Java")); //0
		System.out.println("Java就業養成班".indexOf("ava")); //1
		System.out.println("Java就業養成班".indexOf("ava1")); //找不到就回傳-1
		//如果想知道有沒有，可以contains,回傳boolean
		System.out.println("Java就業養成班".contains("Java")); //true
		
		System.out.println("Java就業養成班".substring(4)); //
		System.out.println("Java就業養成班".substring(4,6)); //
		//123.4556789, .2小數點2位, f表示float, 12表示總長12位
		System.out.println(String.format("%12.2f", 123.4556789 ));
		//有幾個%後方就要多少參數依序排入
		System.out.println(String.format("%s有%12.2f元,借出%d元","Vincent", 123.4556789, 100));
		System.out.printf("%s有%12.2f元,借出%d元%n","Vincent", 123.4556789, 100); //不會自動換行,ln(x),加%n
		System.out.println("Hello");
		
		System.out.printf("%n");
		System.out.printf("%n");
	}
	

}
