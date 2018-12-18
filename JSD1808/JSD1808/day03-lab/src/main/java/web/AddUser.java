package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUser extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解析中文，添加规定的字符集
		request.setCharacterEncoding("UTF-8");
		//读取请求参数值
		String username = request.getParameter("username");
		System.out.println("username:"+username);
		String password = request.getParameter("password");
		System.out.println("password:"+password);
		String email = request.getParameter("email");
		System.out.println("email:"+email);
		//回复内容类型，回复的字符集类型
		response.setContentType("text/html;charset=utf-8");
		//
		if(username==null) {
			response.getWriter().println("请输入正确的内容！");
		}else {
			response.getWriter().println("您输入的用户名为："+username+" 密码为:"+password+" 邮箱为："+email);
		}
	}
	
}
