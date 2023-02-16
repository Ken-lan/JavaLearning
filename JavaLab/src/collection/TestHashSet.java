package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class TestHashSet {

	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<>();//Set不能加重複的東西
		set.add("hello");
		boolean success = set.add("hello");//shift + alt + l
		//"hello".equals("hello") -> true
		System.out.println(success);//加入會失敗
		set.add("world");
		//set.add(3.0); //autoboxing
		
		
		
		System.out.printf("size=%d%n",set.size());
		System.out.println(set.contains("hello"));
		
		Iterator <String>it = set.iterator();
		while (it.hasNext()) {
			String item = it.next();
			System.out.println(item);
			
			
		}
		
	}

}
