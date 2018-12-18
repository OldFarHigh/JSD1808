package dayTest_1025;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.util.Date
 * @author OldFarHigh
 *日期类：每一个实例都代表一个确切的时间
 *  long getTime():获取Date实例内部可维护的long值。
 *  Date Date():默认创建代表当前对象
 *  void setTime():设置增加时间，使其表示对应日期(ms为单位)
 */
public class DateTest {
	public static void main(String[] args) {
		Date date = new Date();//当前系统时间
		System.out.println(date);
		long time = date.getTime();//获取1970-01-01至今的long值
		System.out.println(time);
		date.setTime(time);//设置一个long值表示1970+long后的时间
		System.out.println(date);
		
		String str = "yyyy-MM-dd";//时间格式年-月-日
		SimpleDateFormat sdf = new SimpleDateFormat(str);//将字符串转换为日期格式
		str = sdf.format(date);
		System.out.println(str);
	}
}
