package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUserServlet  extends HttpServlet{
	/**
	 *添加序列化 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 设置请求参数值的解码方式
		 * 注：
		 * 		a、该方法一定要添加到所有的getParameter方法的前面。
		 * 		b、该方法只针对post请求有效
		 */
		request.setCharacterEncoding("UTF-8");
		String username= request.getParameter("username");
		System.out.println("username:"+username);
		String[] interest = request.getParameterValues("interest");
		if(interest != null) {
			for(String str : interest) {
				System.out.println(str);
			}
		}
		
	}
	
}
