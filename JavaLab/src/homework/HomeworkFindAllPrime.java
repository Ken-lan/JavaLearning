package homework;
import java.util.*;

public class HomeworkFindAllPrime {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("輸入一個數字:");
		int num = scan.nextInt();
		for (int i = 2; i < num-1; i++) {
			for(int j = 2; j < num; j++) {
				if(i%j == 0) {
					break;
				}else {
					System.out.println(i);
					
				}
			
			}
			
		}

	}

}
