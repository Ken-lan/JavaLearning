package encap;

public class TestCar {

	public static void main(String[] args) {
		//The constructor Car() is undefined
		Car car = new Car("Prius");
		//car.model = "Prius";
		//car.setModel("Prius") ;
		//car.price = 10000000;
		System.out.printf("型號:%s,售價:%d,顏色:%s%n",car.getModel(),car.getPrice(),car.getColor());
		
	}

}
