package cn.tedu.day02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

/**
 * 对DBUtils_Test 的测试
 * @author OldFarHigh
 *
 */
public class Test01 {
	@Test
	public void findAll() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils_Test.getConn();
			stat = conn.createStatement();
			String sql = "select * from emp";
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("empno");
				String name = rs.getString("ename");
				System.out.println(id+":"+name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils_Test.close(conn, stat, rs);
		}
	}
}
