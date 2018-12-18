package web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		/*
		 * 向浏览器端发送一个名称为username的cookie.
		 * 注：
		 * 		cookie只能存放字符串。
		 */
		Cookie c = new Cookie("username","Sally");
		//设置cookie的生存时间，单位是s
		c.setMaxAge(40);
		response.addCookie(c);
		
		/*
		 * cookie只能存放合法的ASCII字符
		 * 这儿使用encode方法将中文转换成合法的ASCII字符的形式
		 */
		String city  = URLEncoder.encode("北京","utf-8");
		System.out.println("city:"+city);
		
		Cookie c2 = new Cookie("city",city);
		response.addCookie(c2);
		
	}
	
}
