package homework;

public class HomeworkPrintPyramid {

	public static void main(String[] args) {
		// 圖一
		String rice = "*";
		for (int i = 0; i < 5; i++) {
			System.out.println(rice);
			rice = rice + "*";
		}
		// 圖二
		rice = "*";
		for (int i = 0; i < 5; i++) {
			System.out.printf("%5s%n", rice);
			rice = rice + "*";
		}

		System.out.println();

		// 圖三
		rice = "*";
		for (int i = 0; i < 9; i++) {

			if (i > 3) {
				System.out.println(rice);
				rice = rice.substring(0, rice.length() - 1);
			} else {
				System.out.println(rice);
				rice = rice + "*";
			}

		}

		rice = "*";
		for (int i = 0; i < 9; i++) {

			if (i > 3) {
				System.out.println(rice);
				rice = rice.substring(0, rice.length() - 1);
			} else {
				System.out.println(rice);
				rice = rice + "*";
			}

		}
	}

}
