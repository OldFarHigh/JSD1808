package cn.tedu;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Demo05 {
	public static void main(String[] args) throws IOException {
		//创建属性对象
		Properties prop = new Properties();
		//得到文件输入流，利用反射得到
		InputStream ips = Demo05.class.getClassLoader().getResourceAsStream("jdbc.properties");
		//把流交给属性对象
		prop.load(ips);
		//获取数据 只能获取到字符串类型的数据
		String name = prop.getProperty("name");
		String age = prop.getProperty("age");
		String driver = prop.getProperty("driver");
		System.out.println(name+":"+age+":"+driver);
	}
}
