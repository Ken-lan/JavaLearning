package thread;

public class TestThread {

	public static void main(String[] args) {

		Runnable r = () -> {
				for (int i = 5; i > 0; i--) {
					System.out.println("倒數" + i + "秒," + Thread.currentThread());
					// 暫停一秒
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("執行結束");
			};
		
		
		
		
		
		
		
		// Thread t1 = new MyThread();//繼承自製Thread
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 5; i > 0; i--) {
					System.out.println("倒數" + i + "秒," + Thread.currentThread());
					// 暫停一秒
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("執行結束");
			}

		});
		t1.setName("倒數執行緒");
		t1.setDaemon(false);//設成背景執行緒
		t1.setPriority(0);//設定權重，windows上有用，Mac上沒用
		t1.start();// 開始執行，非同步，也有可能作業系統很忙，2秒後才開始執行
		
		System.out.println(t1.isAlive());
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}//等待t1行結束，卡住
		System.out.println("main方法結束");

	}

}
