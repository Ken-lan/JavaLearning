package interFace;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Util {
	
	//輸入年月日, 取得java.util.Date
	public static Date getDate(int year, int month, int day) {
		
		GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
		Date expDate = calendar.getTime();// 呼叫getTime()可以取得Date物件
		return expDate;
	}
	
}
