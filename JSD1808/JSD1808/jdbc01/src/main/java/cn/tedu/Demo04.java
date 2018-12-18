package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;



/**
 * 测试DBUtils是否成功
 * @author OldFarHigh
 *
 */
public class Demo04 {  
	@Test
	public void insert() {
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
			 conn =  DBUtils.getConn();
			 stat = conn.createStatement();
			 String sql = "insert into jdbct1 values(null,'Tom3')";
			 stat.executeUpdate(sql);
			 System.out.println("插入完成！");
			 //rs = stat.executeUpdate("insert into jdbct1 values(null,'LiLei')");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//关闭资源
			DBUtils.close(conn, stat, rs);
		}
	}
	@Test
	public void delete() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			stat = conn.createStatement();
			//创建执行语句
			String sql = "delete from jdbct1 where name='Tom3'";
			stat.executeUpdate(sql);
			System.out.println("完成删除操作！");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, stat, rs);
		}
	}
	@Test
	public void update() {
		Connection conn = null;
		Statement stat =  null;
		ResultSet rs =null;
		try {
			conn = DBUtils.getConn();
			stat = conn.createStatement();
			String sql = "update jdbct1 set name='Tom' where name = 'Tom3'";
			stat.executeUpdate(sql);
			System.out.println("修改完成了！");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, stat, rs);
		}
	}
	@Test
	public void select() {
		//window->preferences->java->Editor->Templates->new
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from emp ");
			while(rs.next()) {
				String name = rs.getString("ename");
				System.out.println(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, stat, rs);
		}
		
		/*Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from jdbct1");
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				System.out.println(id+":"+name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, stat, rs);
		}
	}*/
	}
}
