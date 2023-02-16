package innerClass;

import interFace.Lawyer;

public class TestPeople {

	public static void main(String[] args) {
		
		People p = new People(1.7, 60);
		p.printBMI();
		
		//new Lawyer, java會產生一個沒有名字的class,幫你實作缺少的方法
		//必須要把實作寫在大括號內
		Lawyer lawyer = new Lawyer() {
			@Override
			public void 訴訟() {
				// TODO Auto-generated method stub
				
			}
		};
		//不用另外產生另一個新的class產生一個新的class來implements Lawyer
		lawyer.訴訟();
	}

}
