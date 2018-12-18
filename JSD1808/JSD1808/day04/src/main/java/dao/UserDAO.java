package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.DBUtils;

/**
 * UserDAO
 * 底层的数据库访问对象
 * @author OldFarHigh
 *
 */
public class UserDAO {
	public void delete(int id ) throws Exception {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql = "DELETE FROM t_user WHERE id=?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, id);
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.close(conn, stat, rs);
		}
	}
	public void save(User user) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String username = user.getUsername();
			String password = user.getPassword();
			String email = user.getEmail();
			String sql = "INSET INTO  t_user VALUES(null.?,?,?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, username);
			stat.setString(2, password);
			stat.setString(3, email);
			stat.executeUpdate();
			System.out.println("执行完成");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, stat, rs);
		}
	}
	public void update() {
		//
	}
	public List<User> finAll() {
		List<User> users = new ArrayList<User>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery("SELECT * FROM t_user");
			while(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				User user = new User();
				user.setId(id);
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, stat, rs);
		}
		return users;
	}
}
