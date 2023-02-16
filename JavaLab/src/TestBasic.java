
public class TestBasic {

	public static void main(String[] args) {
		//8 bytes, int  4byte 2.1B,
		long salary;  //宣告變數，拿到記憶體給一個名稱
		salary = 20000; //賦予值
		// long salary = 20000;
		System.out.println("薪水=" + salary);
		int i= 1, j=2, k=4; //一次要三個4bytes 空間,分別是i j k
		//1. 變數不能重複宣告
		//int salary;
		//delete: ctrl + d
		//2.要給值後才能使用
		//int i;
		//int j;
		//int k;
		//System.out.println(Integer.MAX_VALUE);
		//System.out.println(Integer.MIN_VALUE);
		long salaryOfMary = 21474783648L; //2.2B
		long overflow = 2000000000 + 2000000000; //很嚴重的事情; 數字後方加L
		System.out.println("數值溢位:" + overflow);
		//char字元,只能放一個字,"Hello World"字串
		char ch = '中'; //單引號,不是雙引號
		System.out.println(ch);
		boolean paid = true;// true or false
		System.out.println(paid);
		//8,組成java基本型別, 4 整數, char, boolean
		System.out.println("\"Hello\" World"); //跳脫字元 \"
		System.out.println("Hello \nWorld"); //跳脫字元 \n
		System.out.println("Hello \r\nWorld"); //跳脫字元 \r\n \r在早期印表機是移到最前面一行
		//windows鍵 + 左右能排視窗
		//windows鍵 + 上下能縮放視窗
		double a = 10;
		int b = 3;
		double c = a / b; // 除/,餘數%   -> int/int還是int ; 其中double
		System.out.println("c=" +c);
		int y = (int)a; //+-2.1B, 用(int)強制轉型
		System.out.println(y);
		int age = 20;
		boolean adult = age != 18; //一定要測 ==, !=
		System.out.println("是否成年:" + adult);
		
		System.out.println(age > 18 && age < 30); //且
		System.out.println(age > 18 || age < 30); //或, shift + enter 上方鍵
		System.out.println(!(age > 18)); // !是相反
		
		System.out.println(12 & 6);//bitwise
		System.out.println(12 | 6);//bitwise
		System.out.println(~12);//bitwise, 01互換
		//多重身分,
		//律師(8)  ,工程師(4)  ,老師(2)  ,學生(1)
		//int occp = 6; //代表你的職業多重
		int occp = 2|4;
		System.out.println(occp);
		
		System.out.println(occp & 1); //0表示沒有交集，不是學生
		System.out.println(occp & 2); //>0表示有交集，是老師身分
		System.out.println(occp & 4); //>0表示有交集，是工程師身分
		System.out.println(occp & 8); //>0表示沒有交集，沒有律師身分
		
		System.out.println(2 << 2); //向左移兩個bit, 等於乘上2的n次方
		System.out.println(2 * 2 * 2); //乘上2的2次方
		System.out.println(2  * Math.pow(2, 2)); //
		
		age = 18; //給age一個新的值
//		age++;
		System.out.println("age=" + ++age); //先加1，最後才加印出age
//		System.out.println("age=" + age++); //先印出age，最後才加1
		System.out.println("age=" + age);
		a = a+b; //10, 3
		a += b;
		System.out.println(a);
		//>= 18成年, >=30 壯年
		System.out.println(age >= 18 ? "成年"                                      : "未成年");
		System.out.println(age >= 18 ?(age >= 30? "壯年": "成年") : "未成年");
		
	}

}
