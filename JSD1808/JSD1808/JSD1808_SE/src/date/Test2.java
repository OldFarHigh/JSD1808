package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 计算商品的促销日期
 * 输入一个商品的生产日期，格式为：yyyy-MM-dd
 * 再输入该商品的保质期天数
 * 然后经过程序计算输入该商品的促销日期，格式如上
 * 
 * 促销日期计算规则：该商品过期日前两周的周三
 * @author soft01
 *
 */
public class Test2 {
	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入商品的生产日期，格式为：2018-10-25");
		String line = scan.nextLine();
		System.out.println("请输入该商品的保质期天数：");
		int  days = scan.nextInt();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(line);//Date实例
		Calendar calendar = Calendar.getInstance();//返回一个Calendar对象
		calendar.setTime(date);//使用calendar表示Date所描述的生产日期
		calendar.add(Calendar.DAY_OF_YEAR, days);//过期日
//		date = calendar.getTime();
//		line =sdf1.format(date);
//		System.out.println("过期时间为："+line);
		calendar.add(Calendar.DAY_OF_WEEK_IN_MONTH, -2);//过期前减两周
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);//设置为周三
		date = calendar.getTime();
		line =sdf.format(date);
		System.out.println("促销时间为："+line);
		
		
	}
	
}
