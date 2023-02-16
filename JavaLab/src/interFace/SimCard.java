package interFace;

import java.text.SimpleDateFormat;
import java.util.Date;
//型態: product ,Warrantable, Expirable
public class SimCard extends Product implements Warrantable, Expirable {
	
	@Override
	public Date 最後期限() {
		// TODO Auto-generated method stub
		return this.expireDate;
	}
	
	
	@Override
	public int 保固天數() {
		// TODO Auto-generated method stub
		return this.warranty;
	}
	
	private int warranty;// 保固天數
	private Date expireDate;

	public SimCard(String name, int price, int warranty, Date expireDate) {
		super(name, price);
		this.warranty = warranty;
		this.expireDate = expireDate;
	}

	@Override
	public String desc() {
		String description = super.desc();
		// 2023/01/06, y:year , M:month , m:minutes, h:hour
		SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
		description = description + ",最後開卡日：" + f.format(expireDate)
					+"可用"+this.warranty+"天Data";
		return description;
	}

}
