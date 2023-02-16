
public class TestIf {

	public static void main(String[] args) {

		/*
		 * if 只有單一敘述 int age = 20; if (age >= 18){ System.out.println("成年"); }
		 * 
		 * 
		 */

		int age = 40;
		if (age >= 18) {
			System.out.println("成年");
			if (age >= 30) {
				System.out.println("壯年");
			}
		} else {
			System.out.println("未成年");
		}

		int classroom = 111;
		switch (classroom) {
		// tab ; shift + tab + enter
		// copy; ctrl + alt + down
		// 等於, 或
		// 只能用int
		case 111:
		case 204:
			System.out.println("人數 >= 30");
			break;

		case 305:
			System.out.println("人數 <= 30, >= 20");
			break;

		default:
			System.out.println("人數 <= 30, >= 20");
			break;
		}
		//format : ctrl + shift + f
	}

}
