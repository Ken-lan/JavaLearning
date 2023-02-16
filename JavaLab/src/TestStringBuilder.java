import java.util.Iterator;

public class TestStringBuilder {

	public static void main(String[] args) {

		String hello = "Hello"; //pool
		String hello1 =hello +"World"; 
		//加號會在heap中建一個新的字, new String("HelloWorld")
		String hello2 = "HelloWorld"; //pool
		System.out.println(hello1 == hello2); //false
		
		/*
		 i = 0, temp = "" +0
		 i = 1, temp = "0" + 1
		 i = 2, temp = "01" + 2
		 用加號會產生新的物件在heap區
		 
		 */
		
		String temp ="";
		for (int i = 0; i < 10; i++) {
			temp = temp + i;
		}
			
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i <10; i++ ) {
			//呼叫.append()
			builder.append(i);
			
		}
		//利用toString 取得組合的文字
		System.out.println(builder.toString());
	}

}
