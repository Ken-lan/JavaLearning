package func;

public class TestPeople {

	public static void main(String[] args) {
		People p = new People();// id =18
		p.height = 1.7;
		p.weight = 70;
		double BMI = p.getBMI();//this==p
		System.out.printf("BMI=%.2f%n", BMI);
		//class名稱.靜態屬性來存取
		System.out.println(BMI > People.OVER_WEIGHT_BMI?"過重":"標準");
		//class名稱.靜態方法就可以呼叫
		System.out.println(People.BMI(1.7, 70));
		System.out.println(Math.pow(3, 3));
		System.out.println(Math.sqrt(9));
	}
}