package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("ActionServlet's service");
		
		//获得请求资源路径
		String uri = request.getRequestURI();
		System.out.println("uri:"+uri);
		
		/*
		 * 分析请求资源路径
		 * 为了方便比较，截取请求资源路径的一部分
		 */
		
		String path = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println("path:"+path);
		
		//依据请求路径（path）进行相应的处理
		if("/path".equals(path)) {
			System.out.println("处理用户列表的请求");
		}else if("/add".equals(path)) {
			System.out.println("处理添加用户的请求");
		}
	}

}
