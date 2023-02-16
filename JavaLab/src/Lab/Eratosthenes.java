package Lab;

public class Eratosthenes {

	public static void main(String[] args) {
		int aa[] = new int[1000000];
		aa[2] = 0;
		int k = 2, tt = 0;
		while (tt < 101) {
			for (int i = 1; i < aa.length; i++) // 不是質數的數篩除
			{
				if (i % k == 0 && i != k) //
					aa[i] = 1;

			}

			for (int i = 1; i < aa.length; i++) // 將篩除後的第一個數當做新的篩子(k)
			{
				if (i > k && aa[i] == 0) {
					k = i;
					break;
				}
			}
			tt++;
		}
		for (int i = 1; i < aa.length; i++)
			if (aa[i] == 0) 
			System.out.printf("%d ", i);

	}

}
