package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo03 {
	public static void main(String[] args) {
		/*create table jdbcuser(id  int primary key auto_increment,name varchar(10),age int);*/
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入名字");
		String name = sc.nextLine();	
		System.out.println("请输入年龄");
		int age = sc.nextInt();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			stat = conn.createStatement();
			//执行插入的SQL语句
			String sql = "insert into jdbcuser values(null,'"+name+"',"+age+")";
			stat.execute(sql);
			System.out.println("执行完毕！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, stat, rs);
		}
		sc.close();

	}
}
