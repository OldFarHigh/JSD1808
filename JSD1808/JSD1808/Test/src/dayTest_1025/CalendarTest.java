package dayTest_1025;

import java.util.Calendar;

/**
 * java.util.Calendar
 * @author OldFarHigh
 *日历类：因为日期类自身的千年虫和存在时区问题，所以一般通过日历类来操作日期数据
 *
 *
 */
public class CalendarTest {
	public static void main(String[] args) {
		Calendar calendar =  Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);//获取当前时间的年份
		System.out.println(year);
		calendar.add(Calendar.YEAR, 1);//对当前时间的年份加1
		year = calendar.get(Calendar.YEAR);
		System.out.println(year);
		
		calendar.set(Calendar.YEAR, 10);
		System.out.println(calendar.getTime());
	}
}
