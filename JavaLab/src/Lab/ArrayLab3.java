package Lab;

import javax.sound.midi.Soundbank;

/*一個陣列為double[] x = {1.1, 2.0, 1.2, 1.4, 0.5, 6.0};
 * 列出陣列中的最大值及最小值及平均值
 */

public class ArrayLab3 {
	public static void main(String[] args) {
		double[] x = { 1.1, 2.0, 1.2, 1.4, 0.5, 6.0 };
		double temp = 0;

		for (int j = 0; j < x.length; j++) {
			for (int i = 0; i < x.length - 1; i++) {
				if (x[i] > x[i + 1]) {
					temp = x[i + 1];
					x[i + 1] = x[i];
					x[i] = temp;

				}
			}
		}
		;

		System.out.println("最大值= " + x[x.length - 1]);
		System.out.println("最小值= " + x[0]);

		double sum = 0;
		for (int i = 0; i < x.length - 1; i++) {
			sum += x[i];

		}
		System.out.println("平均數= " + sum/x.length);
	}

}

/*
 * sum = x[0] + x[1]
 * 
 * 
 * 
 * 
 * 
 * 
 */
