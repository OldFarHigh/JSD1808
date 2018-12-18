package cn.tedu.day02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * jdbc事务的提交练习
 * 对超人和蝙蝠侠转账的操作
 * 
 * @author soft01
 *
 */
public class Test10 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils_Test.getConn();
			stat = conn.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils_Test.close(conn, stat, rs);
		}
	}
}
