package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3","root" , "");
		//System.out.println(conn);
		//3、创建执行语句
		Statement state = conn.createStatement();
		//4、执行SQL
		String sql="drop table  if exists jdbct1";
		state.execute(sql);
		//System.out.println(state.execute(sql));
		System.out.println("执行完成了！");
		//5、关闭资源
		state.close();
		conn.close();
	}
}
