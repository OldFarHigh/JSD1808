package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Find_AddCookieServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies =request.getCookies();
		if(cookies!=null) {
			boolean flag = false;
			for (Cookie c : cookies) {
				if("cart".equals(c.getName())) {
					//找到名为cart的cookie
					out.println(c.getValue());
					flag = true;
				}
			}
			if(!flag){
				//没有找到名为cart的cookie	
				Cookie c = new Cookie("cart","123456");
				response.addCookie(c);
			}
		}else {
			//没有找到任何cookie
			Cookie c = new Cookie("cart","123456");
			response.addCookie(c);
		}
		
		
	}

}
