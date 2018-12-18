package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * 测试DBUtils_Test是否成功
 * @author soft01
 *
 */
public class Test04 {
   @Test
   public void test01() {
	   Connection conn = null;
	   Statement state = null;
	   ResultSet rs = null;
	   try {
	 conn = DBUtils_Test.getConn();
	 state = conn.createStatement();
	 String sql = "insert into jdbct1 values(null,'Tom3')";
	 state.executeUpdate(sql);
	 System.out.println("插入完成！");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		DBUtils_Test.close(conn, state, rs);
	}
	   
   }
}
