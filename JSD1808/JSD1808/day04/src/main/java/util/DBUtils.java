package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;



/**
 * 数据库连接类，封装连接数据库所需要的常用连接操作，关闭连接操作
 * 通过读取jdbc.properties文件获取数据库的基本配置，创建连接，读取数据
 * @author OldFarHigh
 *
 */
public class DBUtils {
	private static BasicDataSource dataSource;
	static {
		//创建数据对象
		dataSource = new BasicDataSource();
		//
		Properties prop = new Properties();
		InputStream ips = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			prop.load(ips);
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			dataSource.setInitialSize(3);
			dataSource.setMaxActive(5);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() throws SQLException {
		return dataSource.getConnection();
	}
	
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
				//打开自动提交
				conn.setAutoCommit(true);
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
