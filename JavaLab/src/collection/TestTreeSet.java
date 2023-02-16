package collection;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {
	// ctrl+shift+t
	public static void main(String[] args) {
		// Anonymous class

//		Comparator comparator = new Comparator() {
//			@Override
//			public int compare(Object o1, Object o2) {
//				Integer i1 = (Integer) o1; // ctrl+1
//				Integer i2 = (Integer) o2; // ctrl+1
//				// 由大到小
//				if (i1 > i2) {
//					return -1;// 表示i1要排在i2前面
//				} else if (i1 < i2) {// 希望位置要反過來
//					return 1;// 讓o2(i2)排前面
//				} else {
//					return 0;
//				}
//			}
//		};
		// 好處1.不用new新的class 2.排序的邏輯就在附近，閱讀性大幅提升
		// DescComparator comparator = new DescComparator();
		
		
		Comparator<Integer> c = (o1,o2) ->  o1>o2 ? -1 : 1;//只有一行{}和return都能省略
			
		
		
		
		
		
		
		
		Set<Integer> set = new TreeSet<>(( i1,  i2)-> {
			 
				//Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
					//@Override
					//public int compare(Integer i1, Integer i2) {
				// Integer i1 = (Integer) o1; // ctrl+1
				// Integer i2 = (Integer) o2; // ctrl+1
				System.out.printf("i1=%d,i2=%d%n", i1, i2);
				// return i2-i1;
				// 2000000000-(-2100000000)>int -> -2B
				// 由大到小
				if (i1 > i2) {
					return -1;// 表示i1要排在i2前面
				} else if (i1 < i2) {// 希望位置要反過來
					return 1;// 讓o2(i2)排前面
				} else {
					return 0;
				}
			
		});// 自然排序
		set.add(-2100000000);// autoboxing, Integer
		set.add(2000000000);
		set.add(10);
		set.add(8);

		for (Object item : set) {
			System.out.println(item);
		}

	}

}
