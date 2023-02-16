package func;
//設計
public class People {
	//static類別等級屬性
	public static final double OVER_WEIGHT_BMI = 24;// 類別(靜態)屬性，常數，不會變的值
	//類別等級的方法不能用到物件等級的屬性或方法
	public static double BMI(double h, double w) {
		//double bmi = weight / (height * height);
		double bmi = w / (h * h);
		return bmi;
	}
	
	//物件等級，屬性跟方法
	double height;
	double weight;
	//綁在設計圖上，設計圖只有一份，overWeightBMI也只會有一份
	
	public double getBMI() {
//		double bmi = weight / (height * height);
		double bmi = People.BMI(height , weight);
		//BMI公式，把計算改成呼叫static方法，那如果公式有改只要改static方法BMI中的公式
		return bmi;
	}
}
