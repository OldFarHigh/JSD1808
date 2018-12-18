package test;

import java.sql.SQLException;

import dao.UserDAO;


public class TestCase {
	public static void main(String[] args) throws SQLException {
		//System.out.println(DBUtils.getConn());
		
		
		/*UserDAO dao = new UserDAO();
		List<User> users = dao.findAll();
		System.out.println(users);*/
		
		
		
		UserDAO dao = new UserDAO();
		/*User user = new User();
		user.setUsername("use");
		user.setPassword("password");
		user.setEmail("1506183608@qq.com");
		try {
			dao.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			dao.delete(1);
			System.out.println("删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
