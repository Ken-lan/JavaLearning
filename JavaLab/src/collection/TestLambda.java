package collection;

import java.util.HashMap;
import java.util.Map;

public class TestLambda {

	public static Map<String, Integer> votes = new HashMap<>();
	
	public static void main(String[] args) {

		vote("小明");
		vote("小英");
		vote("小王");
		vote("小王");
		vote("小王");
		vote("小明");
		vote("小明");
		
		System.out.println(votes);
		
	}
	
	private static void vote(String name) {
		//1. 票匭中votes沒有這個人的票，設成一票
		//2/ 票匭中votes已經有這個人的票，取出前面的累計，加1放回votes maps中
		
		/*
		if (votes.containsKey(name)) {
			Integer existingVotes = votes.get(name);
			existingVotes++;//+1
			votes.put(name,existingVotes);//放回Votes map中
		}else {
			votes.put(name, 1);
		}
		*/
		
		//JDK8
		//votes.computeIfAbsent(name, (key) -> {
		//	return 0;
		//});
		votes.computeIfAbsent(name, (key) ->  0);
		
		//BiFuction: 2個參數值，目前的(key,value)，回傳一個新的value給他
		//votes.computeIfPresent(name, (key,value) ->{
		//	return value +1 ;
		//});
		votes.computeIfPresent(name, (key,value) -> value +1) ;
		
		
		
	}
	

}
