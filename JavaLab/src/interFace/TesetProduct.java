package interFace;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TesetProduct {

	public static void main(String[] args) {
		//final int a;
		//a = 2;
		//a = 3;
		//Product p = new Product("AAA",100);//抽象類別不能用來產生物件
		//p.calc();
		
		Notebook nb = new Notebook("Dell", 30000, 365);
		System.out.printf("名稱:%s,價錢:%d%n", nb.getName(),nb.getPrice());
		System.out.println(nb.name);// TestProduct跟Product在同一個package
		System.out.println(nb.desc());
		Product item = nb;
		System.out.println(item.desc());//Product.desc()
		//Type mismatch: cannot convert from Product to Notebook

		Notebook item2 = (Notebook)item; //Notebook
		//自動修正1.mouse移動到錯誤 2.keyboard: ctrl +1
		if(item instanceof Food) {
			//確認item真正指向的物件是否有Food的型態(是不是Food的一種)
			Food item3 = (Food) item; //Food = Product
		}
		
		
		//item.getWarranty();// compile error
		//2023.1.7, 日曆 ->Date
		//GregorianCalendar calendar = new GregorianCalendar(2023,Calendar.JANUARY,06);
		Date expDate = Util.getDate(2023,1,6);// 呼叫getTime()可以取得Date物件
		Food food = new Food ("肉鬆", 100,expDate);
		System.out.println(food.desc());
		
		Date simCardExpDate = Util.getDate(2023,1,31);// shift+alt+l : 區域變數宣告
		SimCard simCard = new SimCard("日本漫遊", 700, 7, simCardExpDate);
		System.out.println(simCard.desc());
				
		Product[] list = {nb, food, simCard}; //{1,2,3}
		buy(list);
		//buy(food);
		
	}
	public static void buy (Product[] products) {
		int sum = 0;
		Date now = new Date();
		for (Product product : products) {
			//notebook, food(v) ,simcard(v)
			//有過期特性的商品會實作Expirable
			if(product instanceof Expirable) {
				//符合條件的目前只有Food, SimCard, 轉成會過期的商品
				Expirable expirableItem = (Expirable)product;
				//判斷是否過期
				//取得目前的日期
				if (expirableItem.最後期限().before(now)) {
					System.out.println(product.getName()+"已經過期!!!");
					//跳過過期商品不處理，請處理下一個商品
					continue;
				}
				
			}
			
			System.out.printf("買入:%s%n",product.desc());
			sum += product.getPrice();
		}
		System.out.println("總金額="+sum);
	}
	
//	public static void buy (Food nb) {
//		System.out.printf("買入:%s%n",nb.getName());
//	}
	
}
