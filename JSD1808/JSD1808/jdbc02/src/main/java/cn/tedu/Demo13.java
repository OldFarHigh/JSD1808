package cn.tedu;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


/**
 * 获取元数据
 * @author OldFarHigh
 *
 */
public class Demo13 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			//得到数据库的元数据
			DatabaseMetaData dbmd = conn.getMetaData();
			System.out.println("驱动版本："+dbmd.getDriverVersion());
			System.out.println("连接地址："+dbmd.getURL());
			System.out.println("用户名："+dbmd.getUserName());
			System.out.println("数据库厂商："+dbmd.getDatabaseProductName());
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from emp");
			//从结果集中得到表的元数据
			ResultSetMetaData rsmd = rs.getMetaData();
			//得到表字段的数量
			int count = rsmd.getColumnCount();
			System.out.println("表字段的数量： "+count);
			//得到每个字段的字段名和类型
			for(int i=0;i<count;i++) {
				String name = rsmd.getColumnName(i+1);
				String type = rsmd.getColumnTypeName(i+1);
				System.out.println(name+"："+type);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, stat, rs);
		}
	}
}
