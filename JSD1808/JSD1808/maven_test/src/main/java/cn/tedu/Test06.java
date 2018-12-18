package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 数据库连接池
 * @author soft01
 *
 */
public class Test06 {
	public static void main(String[] args) throws SQLException {
		//创建连接对象
		BasicDataSource dataSource = new BasicDataSource();
		//设置连接信息
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/newdb3");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		//设置初始连接数量
		dataSource.setInitialSize(3);
		//设置最大连接数量
		dataSource.setMaxActive(5);
		//从连接池中得到连接
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
	}
}
