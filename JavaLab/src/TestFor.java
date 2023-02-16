
public class TestFor {

	public static void main(String[] args) {
		//     計數器宣告;    條件成立就執行block;   次數控制
		//    rename class: 檔案總管按F2
		//int i = 1;
		int sum = 0; //暫存的總和變數
		for(int i = 1 ;          i <= 100;             i++         ) {
			System.out.println(i); 
			//if (i%2 != 0) {
			if (i%2 == 0) {
				continue; //continue 會跳過該次
				//sum = sum + (i%2 =0 ?i:0);
				//sum = sum + i; 不等於偶數
				
			}
			sum = sum + i;
			
		}
		System.out.println("總和="+sum);
		// i cannot be resolved to variable: compiler不知道是什麼
		//System.out.println("finally i="+i);
		// i = 1, sum = 0 + 1 =1
		// i = 2, sum = 1 + 2 =3
		// i = 3, sum = 3 + 3 =6
		
		
		int i = 1;
		sum = 0;
		while (i <= 100 ) {
			sum += i;
			i++;
		}
		System.out.println("while總和="+sum);
		
		i = 1;
		sum = 0;
		do {
			sum += i;
			i++;
		} while (i <= 100);
		System.out.println("Dowhile總和="+sum);
		
		//取亂數,一直取要大於5, Math.random()會給我們一個浮點數
		double random;
		do {
			random = Math.random()*10;
			System.out.println();
		} while (random < 5);
		
		
	}

}
