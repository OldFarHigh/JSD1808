package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入查询的页数：");
		int pages = sc.nextInt();
		System.out.println("请输入查询的条数：");
		int num = sc.nextInt();
		if(pages<=0) {
			pages=1;
		}
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql = "select * from jdbcuser limit ?,?";
			stat = conn.prepareStatement(sql);
			//替换？ 的值
			stat.setInt(1, (pages-1)*num);
			stat.setInt(2, num);
			rs = stat.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);	
				String name = rs.getString("name");
				int age = rs.getInt("age");
				System.out.println(id+":"+name+":"+age);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, stat, rs);
		}
		sc.close();
	}
}
