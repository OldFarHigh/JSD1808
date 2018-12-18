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
 * DBUtils
 * @author OldFarHigh
 *
 */
public class DBUtils {
	private static BasicDataSource dataSource;
	static {
		//创建数据源对象
		dataSource = new BasicDataSource();
		//创建属性对象
		Properties prop = new Properties();
		//得到文件输入流 通过反射机制动态获取
		InputStream ips = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			//把文件流加载到属性对象中
			prop.load(ips);
			//读取数据库连接信息，因为读取方法的限制，只能读取到字符串类型的事件
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			//通过数据源对象设置连接属性
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			//初始连接数量
			dataSource.setInitialSize(3);
			//最大连接数量
			dataSource.setMaxActive(3);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConn() throws SQLException {
		return dataSource.getConnection();
	}
	public static void close(Connection conn,Statement state, ResultSet rs) {
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
