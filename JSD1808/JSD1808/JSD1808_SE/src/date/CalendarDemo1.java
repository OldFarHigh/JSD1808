package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * java.util.Calendar
 * 日历类，用于操作时间的API
 * Calendar本身是一个抽象类。
 * 常见实现类：GregorianCalendar，即：阳历。
 * 
 * 可以通过Calendar提供的静态方法：getInstance方法获取一个当前地区适用的时间类，
 * 绝大多数地区获取的都是阳历。
 * @author OldFarHigh
 *
 */
public class CalendarDemo1 {
	public static void main(String[] args) {
		/*
		 * 默认创建也是表示当前系统时间
		 */
		Calendar calendar =Calendar.getInstance();
		System.out.println(calendar);
		/*
		 * Calendar提供了与Date之间互转的方法：
		 * Date getTime()
		 * 将当前Calendar表示的日期以一个Date实例形式返回
		 * 
		 * void setTIme(Date date)
		 * 使当前Calendar表示给定的Date所表示的日期
		 */
		Date date = calendar.getTime();
		System.out.println(date);
		
		
		
		String str ="yyyy年MM月-dd日 HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(str);
		String line =sdf.format(date);
		System.out.println(line);
	}
}
