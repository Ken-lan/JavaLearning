package collection;

import java.util.Comparator;

//改變treeset comparator的排序
//型態:DescComparator, Comparator, Object
public class DescComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Integer i1 = (Integer) o1; // ctrl+1
		Integer i2 = (Integer) o2; // ctrl+1
		// 由大到小
		if (i1 > i2) {
			return -1;// 表示i1要排在i2前面
		} else if (i1 < i2) {//希望位置要反過來
			return 1;//讓o2(i2)排前面
		} else {
			return 0;
		}

		// return 0;
	}

}
