package cn.tedu;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 创建DBUtils 节省每次创建连接对象的过程
 * @author soft01
 *
 */
/*创建连接对象的方法*/
public class DBUtils_Test1 {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static {
		Properties prop = new Properties();
		InputStream ips = DBUtils_Test1.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			prop.load(ips);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
	}
	public static Connection  getConn() throws ClassNotFoundException, SQLException {
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,username,password);
		return conn;
	}
/*创建关闭资源的方法*/
	public static void close(Connection conn,Statement state,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(state!=null) {
				state.close();
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
