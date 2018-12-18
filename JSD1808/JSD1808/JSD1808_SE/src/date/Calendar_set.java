package date;

import java.util.Calendar;

/**
 * void set(int field,int value)
 * 设置指定时间分量为给定的值
 * @author OldFarHigh
 *
 */
public class Calendar_set {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		//设置为2008年
		calendar.set(Calendar.YEAR, 2008);
		System.out.println(calendar.getTime());
		//设置为8月
		calendar.set(Calendar.MONTH, 7);
		System.out.println(calendar.getTime());
		//设置为8号
		calendar.set(Calendar.DAY_OF_MONTH, 8);
		System.out.println(calendar.getTime());
		//设置8分
		calendar.set(Calendar.MINUTE,8);
		System.out.println(calendar.getTime());
		//设置8秒
		calendar.set(Calendar.SECOND, 8);
		System.out.println(calendar.getTime());
	}
}
