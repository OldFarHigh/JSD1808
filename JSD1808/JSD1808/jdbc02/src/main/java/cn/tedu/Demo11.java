package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 获取自增主键的值
 * @author OldFarHigh
 *
 */
public class Demo11 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			stat = conn.createStatement();
			String sql = "insert into jdbcuser values(null,'Tom',18)";
			stat.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
			rs=stat.getGeneratedKeys();
			while(rs.next()) {
				//得到返回值主键值
				int id = rs.getInt(1);
				System.out.println("主键值："+id);
			}
			System.out.println("执行完成！");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, stat, rs);
		}
	}
}
