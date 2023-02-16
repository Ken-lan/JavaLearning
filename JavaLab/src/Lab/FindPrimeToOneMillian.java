package Lab;
/*請列出1到1,000,000之間的所有質數，質數為除了1跟自己以外無法被其他數整除。
 * 應該會有789498個。
 * 
 * 進階:試著在一秒內取得所有結果
 * 
 * 
 * 
 * 
 */

public class FindPrimeToOneMillian {

	public static void main(String[] args) {
		int i, j;
		for (i = 1; i <= 1000000; i++) {
			for (j = 2; j < i; j++) {
				if (i % j == 0)
					break;
			}
			if (j >= i)
				System.out.println(j);
		}

	}

}
