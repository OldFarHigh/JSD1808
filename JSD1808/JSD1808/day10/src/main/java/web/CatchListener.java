package web;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


import dao.UserDAO;
import entity.User;

public class CatchListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("监听到获取数据。。。");
		/*
		 * 查询t_user表，将所有用户信息查询出来，然后将用户信息绑定到servlet上下文
		 */
		UserDAO dao = new UserDAO();//创建dao对象
		try {
			List<User> users = dao.findAll();
			//获取servet上下文对象
			ServletContext sctx = arg0.getServletContext();
			sctx.setAttribute("users",users);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e); 
		}
		
	}
	
	
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("监听到数据销毁。。。");
		//获取servlet上下文对象
		ServletContext sctx = arg0.getServletContext();
		//从上下文中获取数据
		
	}
}
