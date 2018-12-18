package date;

import java.util.Calendar;

/**
 * Calendar提供了获取指定时间分量对应值的操作
 * int get(int field)
 * 参数为对应的时间分量，返回值为该时间分量所对应的值。
 * 而时间分量Canlendar提供了大量的常量来表示。
 * @author OldFarHigh
 *
 */
public class Calendar_get {
	public static void main(String[] args) {
		Calendar calendar =  Calendar.getInstance();
		//获取年
		int year = calendar.get(Calendar.YEAR);
		//获取月(月份从0开始)
		int month = calendar.get(Calendar.MONTH)+1;
		//获取日
		/*
		 * 和“天”相关的时间分量：
		 * DAY_OF_MONTH：月中的天
		 * DATE：月中的天，与DAY_OF_MONTH本身没区别
		 * DAY_OF_WEEK:周中的天
		 * DAY_OF_YEAR:年中的天
		 */
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int date = calendar.get(Calendar.DATE);
		//获取时
		int hour = calendar.get(Calendar.HOUR);//12小时制
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);//24小时制
		//获取分
		int minute = calendar.get(Calendar.MINUTE);
		//获取秒i
		int second = calendar.get(Calendar.SECOND);
		//获取今天是今年的第几天？
		int doy = calendar.get(Calendar.DAY_OF_YEAR);
		System.out.println("今天是今年的第："+doy+"天");
		//获取今天是一周的第几天？
		int dow =calendar.get(Calendar.DAY_OF_WEEK);
		String[] data = {"日","一","二","三","四","五","六"};
		//获取今年一共多少天？
		int days =calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
		System.out.println("今年一共"+days+"天");
		//获取当月一共多少天？
		days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("本月一共："+days+"天");
		
		
		System.out.println("今天是周"+data[dow-1]);
		System.out.println(year+"-"+month+"-"+day+"    "+hourOfDay+":"+minute+":"+second);
	}
}
