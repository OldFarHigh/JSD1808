package cn.tedu.day02;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils_Test {
	private static BasicDataSource dataSource;
	static {
		dataSource = new BasicDataSource();
		Properties prop = new Properties();
		InputStream ips = DBUtils_Test.class.getClassLoader().getResourceAsStream("jdbc.properties");
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
	public static Connection getConn() throws SQLException{
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
				conn.setAutoCommit(true);
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
