package test;


//public class Test {
//	private int i = 1;
//	public static void main(String argv[]){
//		int i = 2;
//		Test s = new Test(); 
//		s.print();
//	}
//	//DO NOT CHANGE
//	public static void print(){
//		System.out.println(i); 
//	}
//}
public class Test {
	private static int i = 1;
	public static void main(String argv[]){
		
		Test.print();
		Test.print();
	}
	

	
	public int getI() {
		return i;
	}



	public void setI(int i) {
		this.i = i;
	}



	//DO NOT CHANGE
	public static void print(){
		System.out.println(i); 
	}
}