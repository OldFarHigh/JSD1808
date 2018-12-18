package cn.tedu;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 新的文件读取方式，比xml更简单
 * properties文件，以键值对方式存储数据,会自动将中文转化为16进制存储
 * @author soft01
 *
 */
public class Test05 {
	public static void main(String[] args) throws IOException {
		//1、创建属性对象
		Properties  prop =  new Properties();
		//2、得到文件流，利用反射方式得到
		InputStream ips = Test05.class.getClassLoader().getResourceAsStream("jdbc.properties");
		//3、把流交给属性对象
		prop.load(ips);
		//4、获取数据 只能获取字符串形式的数据
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		System.out.println(driver+url+username+password);
	}
}
