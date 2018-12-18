package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.DBUtils;

/**
 * DAO数据访问对象
 * 底层的类，只负责和数据库打交道
 * 优点：
 * a、方便测试
 * 	 将数据访问逻辑写在DAO类里面，可以直接测试，如果将数据访问逻辑写在servlet里面，需要部署整个应用才能测试
 * b、方便代码的维护
 * 	 DAO封装了数据访问逻辑，调用者不用关心底层数据库相关的代码，比如，数据库访问逻辑发生了改变
 * （从jdbc换成了mybatis），对调用者没有影响。
 * @author OldFarHigh
 *
 */
public class UserDAO {
	/**
	 * 通过用户名查询用户信息,如果找不到返回空值
	 * @throws Exception 
	 */
	public User findUsername(String username) throws Exception {
		User  user  = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql = "SELECT * FROM t_user WHERE username=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, username);
			rs = stat.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(username);
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.close(conn, stat, rs);
		}
		return user;
	}
	/**
	 *删除指定id的用户
	 */
	public void delete(int id) throws Exception{
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
	/**
	 * 将用户信息插入到数据库
	 * @throws Exception 
	 */
	public void save(User user) throws Exception {
		//将用户信息插入到数据库
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String username = user.getUsername();
			String password = user.getPassword();
			String email = user.getEmail();
			String sql = "INSERT INTO t_user VALUES(null,?,?,?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, username);
			stat.setString(2,password);
			stat.setString(3, email);
			//执行语句
			stat.executeUpdate();
			System.out.println("执行完成");
		} catch (Exception e) {
			//记日志（保留现场）
			e.printStackTrace();
			/*
			 * 看异常能否恢复，如果不能够恢复（比如，数据库服务暂停，网络中断等等，这样的异常一般称之为系统异常）
			 * 则提示用户稍后重试。如果能够恢复，则立即恢复。
			 */
			throw e;
		} finally {
			//关闭连接
			DBUtils.close(conn, stat, rs);
		}
	}
	/**
	 * 查询t_user表，将所有用户信息查找出来,并将所有信息都添加到list集合中
	 */
	public List<User> findAll() throws SQLException{
		List<User> users = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql = "select * from t_user";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
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

		} catch (SQLException e) {
			e.printStackTrace();
			//抛出异常给调用的servlet
			throw e;
		} finally {
			DBUtils.close(conn, stat, rs);
		}
		return users;
	}
}
