package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import pack1.Item;

//utility
//Java.util.Date
public class TestArrayList {

	public static void main(String[] args) {

		List <String> list = new ArrayList<>();
		list.add("hello");// [0]
		list.add("world");// [1] -> [2]
		
		
		
		Double d = new Double(3.0);//boxing,物件的形式
		double doubleValue = d.doubleValue(); //3.0 ,unboxing
		//list.add(3.0);//[2] -> [3]
		
		//list.add(3.0);// [2] -> [3]
		list.add(1, "Java");// [1]

		Integer a = new Integer(1);
		//int x = new Integer(1);
		int x = new Integer(1).intValue();
		
		System.out.println(Integer.parseInt("1")+2);//文字的數字要加減必須改變型別，基本型別才能；比較快
		System.out.println(Integer.valueOf("1")+2);//文字的數字要加減必須改變型別
		System.out.println(Integer.valueOf("1").intValue()+2);//文字的數字要加減必須改變型別，等於上面
		
		System.out.printf("Size = %d%n", list.size());
		System.out.printf("index = %s%n", list.get(0));
		System.out.printf("index = %s%n", list.get(1));
		System.out.printf("index = %s%n", list.get(2));

		for (int i = 0; i < list.size(); i++) {
			String item = list.get(i);// shift+alt+L
			System.out.println(item);
		}
			System.out.println("-----Iterator-----");
			Iterator<String> it = list.iterator();//shift + alt + l
			
			//當前游標下方是否有資料
			while (it.hasNext()) {
				String item = it.next();//移動游標取出物件
				System.out.println(item);
			}				
			
			System.out.println("-----for each-----");
			// list.get(0)會拿到什麼型態，String
			for (String item : list) {
				System.out.println(item);
			}
			System.out.println("-----lambda- foreach前----");
			list.forEach( new Consumer<String>() {

				@Override
				public void accept(String item) {
					System.out.println(item);
					
				}
				
				
			});
			
			System.out.println("-----lambda- foreach----");
			
			
			list.forEach( (item) ->{
				System.out.println(item);
			});
			
			System.out.println("-----Method Reference----");
			//有4種用法
			//需要一個方法，符合一個要件就能使用，沒有回傳值
			list.forEach(System.out::println);//println跟consumer一樣，接收一個物件沒有回傳
			list.forEach(TestArrayList::printItem);//寫一個也能放進來
			
	}

	//接收一個文字形式物件，沒有回傳
	public static void printItem(String item) {
		System.out.println("A="+item);
	}
	
	
}
