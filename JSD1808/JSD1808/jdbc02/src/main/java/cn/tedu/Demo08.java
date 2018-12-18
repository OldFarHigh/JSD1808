package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 带变量的批量操作
 * @author OldFarHigh
 *
 */
public class Demo08 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql = "insert into jdbcuser values(null,?,?)";
			stat = conn.prepareStatement(sql);
			for(int i=1;i<=100;i++) {
				stat.setString(1, "name"+i);
				stat.setInt(2, 100+i);
				//添加到批量操作，会有最大数量限制，所以应考虑批量操作的数量避免过量导致内存溢出
				stat.addBatch();
				//每20条执行一次
				if(i%20==0) {
					//执行批量操作
					stat.executeBatch();
					//清除批量操作
					stat.clearBatch();
				}
			}
			//执行批量操作
			stat.executeBatch();
			System.out.println("执行完成！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, stat, rs);
		}
	}
}
