package exam_finished.e6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {

         People p1 = new People("001",21);
         People p2 = new People("002",33);
         People p3 = new People("003",41);
         //實作1:請實作一個「泛型」的Map中的key值為people的id，value為people物件，將上述三個people放入Map中
         //請不要用使用001,002，例如：map.put("001"...)
         Map<String, People> map = new HashMap<String, People>();
         map.put(p1.getId(),p1);
         map.put(p2.getId(),p2);
         map.put(p3.getId(),p3);
         //實作2:請用for迴圈或者iterator，計算Map中三人的平均年齡，列印到小數以下第一位
         int sum = 0;
         Set<String> keySet = map.keySet();
         for (String keys : keySet) {
			
			sum += map.get(keys).getAge();;
		}
         double Sum = (double) sum; 
         System.out.printf("%.1f%n",Sum/map.size());
         
         
         
    }
}
