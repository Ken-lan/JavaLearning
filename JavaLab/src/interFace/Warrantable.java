package interFace;
//有保固特性的商品
public interface Warrantable {
	//系統常數
	/*public static final */int MAX_WARRANTY = 365;
	// public static final 為預設值可省略
	int 保固天數();
	
	/*public*/default int 檢測費用() {
		return 500;
	}
}
