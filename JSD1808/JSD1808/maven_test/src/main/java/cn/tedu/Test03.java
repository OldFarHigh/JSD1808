package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * 不用main方法的单元测试
 * @author OldFarHigh
 *
 */
public class Test03 {
	@Test
	public void selectTest01() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3","root","");
		Statement state = conn.createStatement();
		ResultSet rs = state.executeQuery("select * from emp ");
		while(rs.next() ) {  //遍历rs
			String name = rs.getString("ename");
			float sal = rs.getFloat("sal");
			System.out.println(name+":"+sal);
			
		}
		rs.close();
		state.close();
		conn.close();
	}
}
