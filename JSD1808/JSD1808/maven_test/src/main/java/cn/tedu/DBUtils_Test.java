package cn.tedu;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 创建DBUtils 节省每次创建连接对象的过程
 * @author soft01
 *
 */
/*创建连接对象的方法*/
public class DBUtils_Test {
	private static BasicDataSource dataSource;
	static {
		Properties prop = new Properties();
		InputStream ips = DBUtils_Test.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			prop.load(ips);
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setPassword(password);
			dataSource.setUsername(username);
			dataSource.setInitialSize(3);
			dataSource.setMaxActive(5);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static Connection  getConn() throws ClassNotFoundException, SQLException {
		
	
		return dataSource.getConnection();
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
