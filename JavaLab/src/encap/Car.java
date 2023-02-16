package encap;

public class Car {
	private String model;
	private int price;
	private String color;
	//constructor,沒有回傳值的宣告
	
	public Car(String color) {
		this("Prius",color);//呼叫另一個建構子
		//this.color = color;
	}
	
	//source -> generate Constructor using Fields
	public Car(String model, String color) {
		//this.model = model;
		this.setModel(model); //建構子呼叫setModel
		this.color = color;
	}
	
	
	//getc setc
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	//1. eclipse,source/generate Getter and Setter
	//2. setm getm
	//不開放設定價錢，所以只有getPrice, 沒有setPrice (用getp)
	
	public int getPrice() {
		return price;
	}
	
	//間接透過方法設定屬性
	public void setModel(String model) {
		this.model = model;
		if(model.equals("Yaris")) {
			this.price = 57500;
		}else if (model.equals("Prius")) {
			this.price = 10990000;
		}else {
			System.out.println("型號有錯");
		}
	}
	//透過間接方法取得屬性值，目的是取值，所以回傳model的型態String
	public String getModel() {
		return model;
	}
	
}
