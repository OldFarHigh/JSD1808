package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCookieServlet  extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/heml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		/*
		 * 读取浏览器端发送过来的cookie一个Cookie对象封装了一个cookie的消息
		 * 注：
		 * 		有可能返回值为null
		 */
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(Cookie c: cookies) {
				String name = c.getName();//获取cookie的名字
				String value =URLDecoder.decode(c.getValue(), "UTF-8");//获取value值
				out.println(name+"："+value+" <br/>");
			}
		}else {
			//没有找到cookie
			out.println("没有找到Cookie");
		}
	}

}
