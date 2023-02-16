package interFace;

//型態(多型):Notebook, Product, Warrantable ,Object
public class Notebook extends Product implements Warrantable {
	private int warranty;// 保固天數

	@Override
	public int 保固天數() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int 檢測費用() {
		return 1000;
	}

	// Constructor, 三個參數
	public Notebook(String name, int price, int warranty) {
		super(name, price); // 一定要在第一行
		// this.price = price;
		// setName(name);
		// setPrice(price);
		this.warranty = warranty;
	}

	// Annotation #XXXX,Spring hibernate
	@Override
	public String desc() {
		String descFromSuper = super.desc(); // super指向父類別，只有商品名稱跟售價
		String info = String.format("%s, 保固%d天", descFromSuper, this.warranty);
		return info;
	}

	// 一組getter an setter
	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	/*
	 * @Override //子類別實作 public int calc(int quantity) { return this.price *
	 * quantity; }
	 */

}
