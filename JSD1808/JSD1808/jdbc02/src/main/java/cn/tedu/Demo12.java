package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 
 * @author OldFarHigh
 *
 */
public class Demo12 {
	public static void main(String[] args) {
		/*create table team(id int primary key auto_increment,name varchar(10));*/
		/*create table player(id int primary key auto_increment,name varchar(10),team_id int);*/
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入球队名称");
		String  teamName = sc.nextLine();
		System.out.println("请输入球员名称");
		String  playerName = sc.nextLine();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			//查询是否存在用户输入的球队
			String sql = "select * from team where name=?";
			stat=conn.prepareStatement(sql);
			stat.setString(1, teamName);
			rs = stat.executeQuery();
			int tid = -1;
			while(rs.next()) {
				//得到已经保存的球队id
				tid = rs.getInt("id");
			}
			//判断是否保存过球队
			if(tid==-1) {//没有保存过球队
				sql = "insert into team values(null,?)";
				stat.close();
				stat = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				stat.setString(1, teamName);
				stat.executeUpdate();
				//得到球队的主键值
				rs.close();
				rs = stat.getGeneratedKeys();
				while(rs.next()) {
					tid = rs.getInt(1);
				}
			}
			//插入球员
			sql = "insert into player values(null,?,?)";
			//关闭资源
			stat.close();
			stat = conn.prepareStatement(sql);
			stat.setString(1, playerName);
			stat.setInt(2, tid);
			//执行
			stat.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, stat, rs);
		}
		sc.close();
	}
}
