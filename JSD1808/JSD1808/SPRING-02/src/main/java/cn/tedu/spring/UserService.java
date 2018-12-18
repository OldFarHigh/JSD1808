package cn.tedu.spring;
/**
 * Model.Service
 * @author OldFarHigh
 *
 */
public class UserService {
	//在service中需要使用DAO对象
	private IUserDao userDao;
	
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	//模拟：注册
	public void reg() {
		System.out.println("UserService.reg()");
		
		userDao.findUserByUsername();
	}
	
	//模拟：登录
	public void login() {
		System.out.println("UserService.login()");
		
		userDao.findUserByUsername();
	}
	
	
}
