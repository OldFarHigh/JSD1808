package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class Demo01 {
	//只能对无参无返回值的方法进行单元测试
	@Test
	public void findAll() {
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	try {
		conn = DBUtils.getConn();
		stat = conn.createStatement();
		rs = stat.executeQuery("select * from emp");
		while(rs.next()) {
			String name = rs.getString("ename");
			Float salary = rs.getFloat("sal");
			System.out.println(name+":"+salary);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DBUtils.close(conn, stat, rs);
	}
}
}
