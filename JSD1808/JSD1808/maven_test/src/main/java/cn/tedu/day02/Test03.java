package cn.tedu.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * 在表jdbcuser中插入数据
 * 要求：
 * 在控制台输入名字和年龄
 * 并将输入的数据插入到jdbcuser表中
 * @author soft01
 *
 */
public class Test03 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入名字：");
		String name = sc.nextLine();
		System.out.println("请输入年龄");
		int age = sc.nextInt();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils_Test.getConn();
			String sql = "insert into jdbcuser values(null,?,?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, name);
			stat.setInt(2, age);
			stat.executeUpdate();
			System.out.println("执行完毕！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils_Test.close(conn, stat, rs);
		}
		sc.close();
	}
}
