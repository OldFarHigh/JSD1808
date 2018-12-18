package cn.tedu.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * 在控制台输入查询的页数和条数
 * 输出查询到的数据
 * @author OldFarHigh
 *
 */
public class Test09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要查询的页数：");
		int pages = sc.nextInt();
		System.out.println("请输入要查询的条数：");
		int num = sc.nextInt();
		if(pages==0) {
			pages=1;
		}
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils_Test.getConn();
			String sql = "select * from jdbcuser limit ?,?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, (pages-1)*num);
			stat.setInt(2, num);
			rs = stat.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				System.out.println(id+name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils_Test.close(conn, stat, rs);
		}
	}
}
