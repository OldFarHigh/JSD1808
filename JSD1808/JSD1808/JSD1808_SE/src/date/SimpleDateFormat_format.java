package date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.text.SimpleDateFormat
 * 可以将Date和String按照指定的日期格式进行相互转换
 * @author OldFarHigh
 *
 */
public class SimpleDateFormat_format {
	public static void main(String[] args) {
		Date now =new Date();
		System.out.println(now);
		/*
		 * 2018-10-25 10:22:35
		 * yyyy -MM-dd HH:mm:ss
		 */
		String str ="yyyy年MM月-dd日 HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(str);
		/*
		 * String format(Date date)
		 * 将给定的Date按照当前SDF指定的日期格式转换为字符串
		 */
		String line =sdf.format(now);
		System.out.println(line);
	}
}
