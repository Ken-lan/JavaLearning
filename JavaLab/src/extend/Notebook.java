package extend;
//型態(多型):Notebook, Product
public class Notebook extends Product {
	public int warranty;//保固天數
	
	//Constructor, 三個參數
	public Notebook(String name, int price, int warranty) {
		super(name, price); //一定要在第一行
		//this.name = name; //還是有繼承到name, price，在語法上不能直接.name .price
		//this.price = price; 
		//setName(name);
		//setPrice(price);
		this.warranty = warranty;
	}
	
	
	//Annotation #XXXX,Spring hibernate
	@Override
	public String desc() {
		String descFromSuper = super.desc(); //super指向父類別，只有商品名稱跟售價
		String info = String.format("%s, 保固%d天",descFromSuper,this.warranty);
		return info;
	}
	
	
	//一組getter an setter 
	public int getWarranty() {
		return warranty;
	}
	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	/*
	@Override //子類別實作
	public int calc(int quantity) {
		return this.price * quantity;
	}
	*/
}
