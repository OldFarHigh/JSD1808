package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LifeServlet() {
	
		System.out.println("LifeServlet's constructor");
		
	}

	

	@Override
	public void init() throws ServletException {
		System.out.println("LifeServlet's init");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeServlet's doGet");
	}
	
	@Override
	public void destroy() {
		System.out.println("LifeServlet's destory");
	}
	

/*
	 @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("LifeServlet's service");
		
		 * 可以通过继承自GenericServlet提供的方法来获得ServletConfig对象
		 
		ServletConfig config = getServletConfig();
		
		 * 通过servletConfig对象提供的方法来读取初始化参数
		 
		String company = config.getInitParameter("company");
		System.out.println("company:"+company);
		System.out.println("param-value:"+company);
	}
*/
}
