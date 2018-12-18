package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class Demo06 {
	public static void main(String[] args) throws SQLException {
		//创建数据源对象
		BasicDataSource dataSource = new BasicDataSource();
		//设置数据库连接信息
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
