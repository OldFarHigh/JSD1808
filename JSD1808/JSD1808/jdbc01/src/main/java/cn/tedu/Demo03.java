package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Demo03 {
	@Test
	public void test1() throws ClassNotFoundException, SQLException {
		System.out.println("我要单元测试了");
		//1、
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3","root","");
		Statement state = conn.createStatement();
		String sql = "insert into jdbct1 values(null,'Tom')";
		state.executeUpdate(sql);
		System.out.println("插入完成了！");
		state.close();
		conn.close();
	}
	@Test
	public void test2() throws ClassNotFoundException, SQLException {
		System.out.println("我又单元测试了");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3","root","");
		Statement state = conn.createStatement();
		String sql = "update jdbct1 set name='Jerry' where name='Tom' ";
		state.executeUpdate(sql);
		System.out.println("修改完成了！");
		state.close();
		conn.close();
	}
	@Test
	public void test3() throws ClassNotFoundException, SQLException {
		System.out.println("没想到吧！又是我!");
		System.out.println("我又单元测试了");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3","root","");
		Statement state = conn.createStatement();
		String sql = "delete  from jdbct1 where name='Jerry' ";
		state.executeUpdate(sql);
		System.out.println("删除完成了！");
		state.close();
		conn.close();
	}
	@Test
	public void findAll() throws ClassNotFoundException, SQLException {
		System.out.println("你好，我是老法海!");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3","root","");
		Statement state = conn.createStatement();
		//执行查询SQL
		ResultSet  rs = state.executeQuery("select * from emp");
		//遍历得到的数据 见到resultSet就while循环遍历
		while(rs.next()) {
			String name= rs.getString("ename");
			float salary= rs.getFloat("sal");
			System.out.println(name+":"+salary);
		}
		//关闭资源 先开的后关
		rs.close();
		state.close();
		conn.close();
	}
}
