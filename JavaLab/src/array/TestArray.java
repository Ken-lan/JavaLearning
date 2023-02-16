package array;

public class TestArray {

	public static void main(String[] args) {

//		int[] ages = new int[10];
		int[] ages = { 1, 2, 3 };
		ages[0] = 1;// 設值
		ages[1] = 2;
		ages[2] = 3;
		System.out.println(ages[1]);// 取值
		System.out.printf("陣列大小:%d%n", ages.length);
//		System.out.println(ages[10]);
//		java.lang.ArrayIndexOutOfBoundsException
		System.out.println("done");

//		int[][] x = new int[5][4];
		//              x[0]          x[1]          x[2]
		int[][] x = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		x[0][0] = 1;
		x[1][0] = 2;
		x[2][0] = 3;
		System.out.println(x[2][0]);
		System.out.printf("有%d排%n", x.length);
		System.out.printf("第二排有%d個%n", x[1].length);
		// 代表第幾排,0表示第一排
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				System.out.printf("x[%d][%d] = %d %n", i, j, x[i][j]);
			}
		}
		System.out.println("-------for each-----");
		//宣告: 陣列變數名稱
		//ages[0]-> 型態是int
		for(int value: ages) {
			System.out.println(value);
		}
		//Lab:用for each語法處理二微陣列x
		//x[0]型態是int[]
		
		for(int[] row : x ) {
			for(int value: row) {
				System.out.println(value);
			}
		}
		
		
	}

}
