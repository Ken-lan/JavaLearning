package homework;
import java.util.*;

public class HomeworkFindPrime {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("輸入一個數字:");
		int num = scan.nextInt();
		for (int i = 2; i < num; i++) {
			if(num%i == 0) {
				System.out.println(num+"不是質數");
				break;
			}else {
				System.out.println(num+"是質數"); 
				break;
			}
		}
		scan.close();
	}
}
