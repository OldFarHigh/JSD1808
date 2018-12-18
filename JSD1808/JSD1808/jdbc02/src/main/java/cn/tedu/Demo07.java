package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 批量操作
 * @author OldFarHigh
 *
 */
public class Demo07 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			stat = conn.createStatement();
			String sql1 = "insert into jdbcuser values(null,'张三',20)";
			String sql2 = "insert into jdbcuser values(null,'李四',30)";
			String sql3 = "insert into jdbcuser values(null,'王五',40)";
			// 添加到批量操作中
			stat.addBatch(sql1);
			stat.addBatch(sql2);
			stat.addBatch(sql3);
			//执行批量操作
			stat.executeBatch();
			System.out.println("插入操作完成！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, stat, rs);
		}
	}
}
