package test;

import java.sql.SQLException;

import dao.UserDAO;
import entity.User;


public class TestCase {
	public static void main(String[] args) throws SQLException {
		//System.out.println(DBUtils.getConn());
		
		
		/*UserDAO dao = new UserDAO();
		List<User> users = dao.findAll();
		System.out.println(users);*/
		
		
		
		UserDAO dao = new UserDAO();
		User user = new User();
		try {
		user =dao.findUsername("a6");
		System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*user.setUsername("use");
		user.setPassword("password");
		user.setEmail("1506183608@qq.com");
		try {
			dao.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
	}
}
