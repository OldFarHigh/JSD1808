package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class LoginServlet extends HttpServlet{
	/**
	 *序列化 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//规定解析字符集类型
		request.setCharacterEncoding("UTF-8");
		//规定发送的数据类型和字符集类型
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//获得用户输入的信息
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		UserDAO dao = new UserDAO();
		try {
			User users =dao.findUsername(username);
			if(username != null && users.getPassword().equals(password)){
			    //登录成功
			    response.sendRedirect("list");
			}else{
			    //登录失败
			    request.setAttribute("login_failed","用户名或密码错误");
			    //获得转发器并转发
			    request.getRequestDispatcher("Login.jsp").forward(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙，请稍后重试！");
		}
	}

}
