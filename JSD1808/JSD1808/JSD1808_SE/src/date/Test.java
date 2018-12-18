package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 程序启动后，要求用户输入自己的生日，格式：yyyy-MM-dd
 * 然后经过程序计算，输出到今天为止一共活了多少天？
 * 以及出生10000天的纪念日是哪天，纪念日格式同上
 * @author OldFarHigh
 *
 */
public class Test {
	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入您的生日，格式如：1998-03-04:");
		String line =scan.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = sdf.parse(line);
		//出生距今
		Date now = new Date();//获取系统时间
		long lifeTime =now.getTime()-birthday.getTime();
		 lifeTime /= 1000*60*60*24;
		System.out.println("距今您活了："+lifeTime+"天!");
		//10000天纪念日
		long time = birthday.getTime()+1000L*60*60*24*10000;//获取可维护的long值
		Date date = new Date(time);
		line =sdf.format(date);
		System.out.println("10000天纪念日为："+line);
		
		
		
		
	}
}
