package collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestHashMap {

	public static void main(String[] args) {
		//LinkedHashMap可以有順序
		Map<String,Integer> map = new HashMap<>();
		map.put("John", 2000);//put(key,value)
		map.put("David", 1000);
		map.put("Tom", 5000);
		map.put("Tom", 2500);//蓋掉同一個key
		//get(key)可以得到value
		System.out.println("Tom's salary = "+map.get("Tom"));
		System.out.println("size = "+map.size());
		//contains
		System.out.println(map.containsKey("Tom"));
		System.out.println(map.containsKey(1999));
		//如果hashcode()沒有實作，物件不論是key or value ，丟到
		//HashSet,HashMap中都會有問題，此例Key是String，value:Integer
		//hashCode由JDK負責的一定有寫
		//1.先取得所有的key
		Set<String> keys = map.keySet();//shift + alt + l// shift + alt +1: "John", "David","Tom"
		for(String key: keys) {
			//String name = (String) key;//ctrl+1
			System.out.printf("name=%s,salary=%d%n",key,map.get(key));
		
		}
		
		//2.entry: 一組資料,entrySet:把整個資料變成一個set
		System.out.println("------ entry set -----");
		 Set<  Entry<String, Integer>  > entrySet = map.entrySet();//shift + alt +l
		int sum = 0;//sum = 0;
		for (Entry<String, Integer> entry : entrySet) {
			//Entry entry = (Entry) e; //ctrl + 1
			Integer salary = entry.getValue();
			sum += salary.intValue();//unboxing
			//sum = new Integer(sum.intValue + salary.intValue());
			//2x unboxing
			System.out.printf("name=%s,salary=%d%n",entry.getKey(),entry.getValue());
		}
		System.out.println("總和="+sum);
	}

}
