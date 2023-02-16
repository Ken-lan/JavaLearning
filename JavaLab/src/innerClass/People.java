package innerClass;

public class People{
	private double height;
	private double weight;

	// construtor, Source/ Generate Construtor usingfields
	public People(double height, double weight) {
		this.height = height;
		this.weight = weight;
	}

	// bmi 公式改用inner class
	private class InnerClass {
		public double calcBMI() {
			return weight / (height * height);
		}
	}
	
	public void printBMI() {
		InnerClass inner = new InnerClass();
		double bmi = inner.calcBMI();//shift + alt + l
		System.out.println(bmi);
		
	}
	
}

