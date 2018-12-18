package date;

import java.util.Calendar;

/**
 * void add(int field,int amount)
 * 对指定的时间分量累加指定的值。若给定的值为负数，则是减去。
 * @author OldFarHigh
 *
 */
public class Calendar_add {	
	public static void main(String[] args) {
		/*
		 *查看3年2个月零25以后那周的周五是哪天？
		 */
		Calendar calendar  = Calendar.getInstance();
		//加3年
		calendar.add(Calendar.YEAR,3);
		//加2个月
		calendar.add(Calendar.MONTH,2);
		//加25天
		calendar.add(Calendar.DAY_OF_YEAR, 25);
		System.out.println(calendar.getTime());
		//设置周五
		calendar.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);
		System.out.println(calendar.getTime());
		
	}
}
