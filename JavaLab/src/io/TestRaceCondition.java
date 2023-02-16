package io;

import java.util.ArrayList;
import java.util.List;

public class TestRaceCondition {

    public static int counter = 0;

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        //產生threads，加入ArrayList
        for( int i=0 ; i < 10 ; i++) {
            Runnable runnable = new Runnable() {
                @Override
                // 在 void run前 synchronized: 鎖頭是this物件(runnable)
                //runnable物件是唯一的嗎?不是，每一個執行緒都有自己的runnable，放在迴圈外可以
                public synchronized void run() {
                    for ( int i= 0  ; i < 1000 ;i ++){
                        TestRaceCondition.vote();
                    }
                }
            };
            Thread t1 = new Thread(runnable,"T"+i);
            threads.add(t1);
        }
        //一起發動所有的thread
        for (Thread thread : threads) {
            thread.start();
        }
        try {
            //main thread 等待所有執行緒結束
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //印出最後的值
        System.out.println("finally counter = "+counter);

    }
    //鎖:要是唯一的，在區域變數內的鎖會沒有作用
    public static final Object Lock = new Object();
    
    
    //在static 前 Synchronized: 鎖頭:TestRacecondition.class
    public static void vote(){
        //第一種做法
    	//Object lock = new Object();
    	//synchronized (Lock) {
        //synchronized (TestRaceCondition.class) {//第三種
        	counter = counter + 1;
        //}	
			
		//}   
    }
}
