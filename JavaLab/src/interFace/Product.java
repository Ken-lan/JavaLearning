package interFace;

public abstract class Product {
	
	//public abstract int calc(int quantity);

	public static final double TAX = 0.05;
	static {
		System.out.println("只會執行一次");
	}
	
	
	protected String name;
	protected int price;

	// 2 個 constructor, 一個name,一個prince 另一個沒有參數
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Product() {
	}

	
	
	//說明商品資訊的文字
	public String desc() {
		String info = String.format("商品名稱:%s, 售價:NT%d元", this.name,this.price);
		return info;
	}
	
	
	
	
	
	// source /generate getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
