package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc 删除创建的表
 * @author OldFarHigh
 *
 */
public class Test02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、创建数据库连接的对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3","root","");
		//3、创建执行语句
		Statement state = conn.createStatement(); 
		//4、执行SQL语句
		String sql = "drop table if exists jdbct2";
		state.execute(sql);
		System.out.println("删除完成了！");
		//5、关闭资源
		state.close();
		conn.close();
	}
}
