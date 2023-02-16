package exception;

public class TestException {

	public static void main(String[] args) {
		//System.err.println("this is an error")
		try {
		int a = 1;
		int c = 1;
		System.out.println("c=" + c);
		int b = a / c;
		System.out.println("b=" +b);
		int[] x = {}; // length =0, 空的陣列
		System.out.println(x[0]);// Array Index OutOf Bound Exception
		
		
		
		}catch (ArithmeticException| ArrayIndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace(); //Exception上層的父類別，以便攔下所有其他的錯誤
		}finally {
			//1.關閉資料庫連線 2.關閉連線
			System.out.println("一定會被執行的程式區塊");
		}
		//錯誤有被攔下來就會繼續執行
		System.out.println("done");
		
	}

}
