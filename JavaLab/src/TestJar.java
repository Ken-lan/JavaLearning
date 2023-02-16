import util.CountDown;

public class TestJar {

	public static void main(String[] args) {
		//java.lang.NoClassDefFoundError: util/CountDown
		//No Class Definition Found Error: util.CountDown.class
		//-cp: windows是用; Mac是用: 做路徑的區隔符號
		//-cp .可以到當前的工作目錄，..表示上一層的目錄
		CountDown countDown = new CountDown();
		countDown.run();

	}

}
