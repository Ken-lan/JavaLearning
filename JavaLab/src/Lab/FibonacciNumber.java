package Lab;

/* Fibonacci number費氏數列，1 1 2 3 5 8 13 21 34 55 ...，第n位的值為前兩位相加。
 * 
 * 產生前10位費氏數列。
 * 
 * 要可以在10秒內算到第50位(n=50)，可以試著用遞迴或者迴圈處理。
 * 
 * 
 */
public class FibonacciNumber {

	public static void main(String[] args) {

		long[] f = new long[50];
		f[0] = 1;
		f[1] = 1;

		for (int j = 2; j < 50; j++) {
			f[j] = f[j - 2] + f[j - 1];

		}

		for (long i : f) {
			System.out.println(i);
		}
		;

	}

}
/*
 * 
 * f[0] = 1 
 * f[1] = 1 
 * f[2] = f[0] + f[1] = 2 
 * f[3] = f[1] + f[2] = 3 
 * f[4] = f[2] + f[3] = 5
 * .
 * .
 * f[i] = f[i-2] + f[i-1]
 * 
 * 
 */
