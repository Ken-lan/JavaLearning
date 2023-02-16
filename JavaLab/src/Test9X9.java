
public class Test9X9 {

	public static void main(String[] args) {
		// i 表示被乘數, j表示乘數
		// 1x1=1 1x2=2... 1x9
		// 2x1=2
		// 3x1=3
		// 9x1=9 ............9x9
		// int i =1;
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.print(i + "x" + j + "=" + i * j + "\t"); // \t是tab鍵
				// ln=line, 會換行
			}
			// 換行
			System.out.println();// 有ln 就會換行
		}

	}

}
