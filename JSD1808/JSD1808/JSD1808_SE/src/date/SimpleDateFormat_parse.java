package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将一个字符串解析为Date
 * @author OldFarHigh
 *
 */
public class SimpleDateFormat_parse {
	public static void main(String[] args) throws ParseException {
		String str = "2008-08-08 20:08:08";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//Fri Aug 08 20:08:08 CST 2008
		Date date = sdf.parse(str);//解析时间
		System.out.println(date);//Fri Aug 08 20:08:08 CST 2008
		
		
		
		
	}
}
