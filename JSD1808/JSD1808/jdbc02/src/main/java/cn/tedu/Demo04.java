package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;



public class Demo04 {
	public static void main(String[] args) {
		/*create table jdbcuser(id  int primary key auto_increment,name varchar(10),age int);*/
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入名字");
		String name = sc.nextLine();	
		System.out.println("请输入年龄");
		int age = sc.nextInt();
		Connection conn = null;
		//预编译的SQL执行对象
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql = "insert into jdbcuser values(null,?,?)";
			stat = conn.prepareStatement(sql);
			//把 ？ 替换成真正的数据
			stat.setString(1, name);
			stat.setInt(2, age);
			//执行SQL
			stat.executeUpdate();
			System.out.println("执行完毕！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, stat, rs);
		}
		sc.close();

	}
}
