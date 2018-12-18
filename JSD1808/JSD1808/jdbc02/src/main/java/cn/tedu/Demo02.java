package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo02 {
	public static void main(String[] args) throws SQLException {
	/*	Connection conn1 = DBUtils.getConn();
		System.out.println("获取到了一号连接："+conn1);
		Connection conn2 = DBUtils.getConn();
		System.out.println("获取到了二号连接："+conn2);
		Connection conn3 = DBUtils.getConn();
		System.out.println("获取到了三号连接："+conn3);
		//归还conn1
		conn1.close();
		Connection conn4 = DBUtils.getConn();
		System.out.println("获取到了四号连接："+conn4);
		Connection conn5 = DBUtils.getConn();
		System.out.println("获取到了五号连接："+conn5);*/
		DemoThread t1 = new DemoThread();
		t1.start();
		DemoThread t2 = new DemoThread();
		t2.start();
		DemoThread t3 = new DemoThread();
		t3.start();
		DemoThread t4 = new DemoThread();
		t4.start();
	}
}
class DemoThread extends Thread {
		public void run() {
			try {
				//获取连接
				Connection conn  = DBUtils.getConn();
				System.out.println("获取到连接");
				//模拟耗时
				Thread.sleep(5000);
				//归还连接
				conn.close();
				System.out.println("归还连接");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}