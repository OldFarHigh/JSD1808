package cn.tedu;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils1 {
	//创建全局变量，作用整个范围
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	static {
		//1、创建属性对象
		Properties prop = new Properties();
		//2、得到文件输入流
		InputStream ips = Demo05.class.getClassLoader().getResourceAsStream("jdbc.properties");
		//3、把流加载到属性对象中
		try {
			prop.load(ips);
			//4、调用四个变量 把配置文件中的数据读取到变量中
			 driver = prop.getProperty("driver");
			 url = prop.getProperty("url");
			 username = prop.getProperty("username");
			 password = prop.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//获取连接的方法
	public static Connection getConn() throws Exception {

		//5、把四个变量放到下面两行代码中取代写死的字符串
		//注册驱动
		Class.forName(driver);
		//创建连接对象
		Connection conn = DriverManager.getConnection(url,username,password);
		return conn;
	}
	//封装关闭资源的方法
	public static void close(Connection conn, Statement stat,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(stat!=null) {
				stat.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
