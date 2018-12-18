package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


/**
 * sql 注入
 * @author soft01
 *
 */
public class Demo06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username = sc.nextLine();
		System.out.println("请输入密码：");
		String password = sc.nextLine();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql = "select count(*) from t_user where username=? and password=?" ;
			stat = conn.prepareStatement(sql);
			//替换问号位置
			stat.setString(1,username);
			stat.setString(2, password);
			//执行SQL
			rs = stat.executeQuery();
			while(rs.next()) {
				//得到结果集中唯一的参数
				int count  = rs.getInt(1);
				if(count==0) {
					System.out.println("登录失败！");
				}else {
					System.out.println("登录成功！");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, stat, rs);
		}
		sc.close();
	}
}
