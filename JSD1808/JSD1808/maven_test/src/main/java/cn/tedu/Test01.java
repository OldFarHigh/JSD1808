package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc的使用过程
 * @author OldFarHigh
 *
 */
public class Test01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3","root","");
		//3、创建执行SQL语句的对象
		Statement stat = conn.createStatement();
		String  sql = "create table  if not exists jdbct2(id int primary key auto_increment,name varchar(10))";
		//4、执行语句完成
		stat.execute(sql);
		System.out.println("执行完成了！");
		//5、关闭资源
		stat.close();
		conn.close();
		
	}
}
