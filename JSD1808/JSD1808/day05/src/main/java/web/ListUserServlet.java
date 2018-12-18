package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
				//绑定数据到请求对象上
				request.setAttribute("users", users);
				//获得转发器
				RequestDispatcher rd = request.getRequestDispatcher("listUser.jsp");
				//转发
				rd.forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
				out.println("系统繁忙，请稍后重试");
			} 
	}
}
