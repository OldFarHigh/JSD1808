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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//获取输入的数据
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		System.out.println();
		//和数据库数据匹配
		UserDAO dao = new UserDAO();
		try {
			User user = dao.findUsername(username);
			if(user!=null&&user.getPassword().equals(password)) {
					response.sendRedirect("list");
			}else {
				request.setAttribute("login_failed", "用户名或密码错误");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙，请稍后重试！");
		}
	}

}
