package test;

import java.sql.SQLException;
import java.util.List;

import dao.UserDAO;
import entity.User;
import util.DBUtils;

public class Test {
	public static void main(String[] args) throws SQLException {
		System.out.println(DBUtils.getConn());
		
		UserDAO  dao  = new UserDAO();
		
		User user = new User();
		user.setUsername("use");
		user.setPassword("password");
		user.setEmail("1506183608@qq.com");
		try {
			dao.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<User> users = dao.finAll();
		System.out.println(users);
		/*
		try {
			dao.delete(12);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}
}
