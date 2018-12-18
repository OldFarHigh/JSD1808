package cn.tedu;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
	//创建全局变量，作用整个范围
	private static BasicDataSource dataSource;
	static {
		//1、创建属性对象
		Properties prop = new Properties();
		//2、得到文件输入流
		InputStream ips = Demo05.class.getClassLoader().getResourceAsStream("jdbc.properties");
		//3、把流加载到属性对象中
		try {
			prop.load(ips);
			//4、调用四个变量 把配置文件中的数据读取到变量中
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			//创建数据源对象
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			//设置初始连接数量
			dataSource.setInitialSize(3);
			//设置最大连接数量
			dataSource.setMaxActive(5);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//获取连接的方法
	public static Connection getConn() throws Exception {

		//返回数据库连接池中的连接
		return dataSource.getConnection();
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
