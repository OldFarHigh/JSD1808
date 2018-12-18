package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 事务
 * conn.setAutoCommit(false/true)
 * conn.commit
 * conn.rollback
 * @author OldFarHigh
 *
 */
public class Demo10{
	public static void main(String[] args) {
		/*create table person(id int primary key auto_increment,name varchar(10),money int);*/
		/*insert into person values(null,'超人',5000),(null,'蝙蝠侠',100);*/
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			//关闭自动提交
			conn.setAutoCommit(false);
			stat = conn.createStatement();
			String sql1 = "update person set money = money-2000 where id=1";
			String sql2 = "update person set money = money+2000 where id=2";
			stat.executeUpdate(sql1);
			stat.executeUpdate(sql2);
			//得到超人剩余的钱数如果大于等于0则允许转账否则回滚
			rs = stat.executeQuery("select money from person where id=1");
			while(rs.next()) {
				int money = rs.getInt("money");
				if(money>=0) {
					System.out.println("转账成功！");
					conn.commit();//提交
				}else {
					System.out.println("转账失败！");
					conn.rollback();//回滚
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, stat, rs);
		}
	}
}
