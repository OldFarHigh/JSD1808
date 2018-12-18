package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class ListUserServlet  extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");//解码接收消息
			response.setContentType("text/html;charset=utf-8");//回复消息类型，和字符集
			PrintWriter out = response.getWriter();
			//step1：有DAO对象查询出所有用户信息
			UserDAO dao = new UserDAO();
			try {
				List<User> users = dao.findAll();
				//step2:依据查询到用户信息，输出表格
				out.println("<table border='1' width='60%' cellpadding='0' cellspacing='0'>") ;
				out.println("<tr><td>ID</td>"
						+ "<td>用户名</td>"
						+ "<td>密码</td>"
						+ "<td>邮箱</td>"
						+ "<td>操作</td></tr>");
				for (User user : users) {
					int id = user.getId();
					String username = user.getUsername();
					String password = user.getPassword();
					String email = user.getEmail();
					out.println("<tr><td>"+id+"</td>"
							+ "<td>"+username+"</td>"
							+ "<td>"+password+"</td>"
							+ "<td>"+email+"</td>"
							+ "<td><a href='del?id="+id+"'>删除</td></tr>");
				}
				out.println("</table>");
				out.println("<p><a href='addUser.html'>添加用户</a></p>");
			} catch (Exception e) {
				e.printStackTrace();
				out.println("系统繁忙，请稍后重试");
			} 
	}
}
