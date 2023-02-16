package func;

public class TestFunc {

	public static void main(String[] args) {
		//呼叫
		int s = add(10,20);
		System.out.println(s%2 == 1?"奇數":"偶數");
		System.out.println("done");
		add2(1,2,3,4,5,6,7,8);
		add2(1,2,3,4,5);
		add2(1);
		
	}
	
	public static int add2(int b, int... a) {
		//... 在方法實作就是陣列，呼叫方傳5個參數，拿到大小為5的整數陣列
		//... 要在參數的最後面
		int sum = 0;
		for (int value: a) {
			sum += value;
		}
		return sum;
	}
	//void 表示沒有回傳值   方法名稱   參數，多個用,區隔
	public static int add      (int a, int b  ) {
		//方法的實作
		//參數對方法的實作來說就是區域變數
		int sum = a + b;
		System.out.println("總和"+sum);
		return sum;
		
	}
	
}
