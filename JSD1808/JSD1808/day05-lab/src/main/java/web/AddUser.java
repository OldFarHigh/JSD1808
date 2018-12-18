package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class AddUser extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解析中文，添加规定的字符集
		request.setCharacterEncoding("UTF-8");
		//回复内容类型，回复的字符集类型
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//读取请求参数值
		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");
		String email = request.getParameter("email");
		
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		System.out.println("email:"+email);
		
			//将用户信息插入到数据库
			UserDAO dao = new UserDAO();
			try {
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
				dao.save(user);
				//重定向到用户列表
				response.sendRedirect("list");
			} catch (Exception e) {
				//记日志（保留现场）
				e.printStackTrace();
				/*
				 * 看异常能否恢复，如果不能够恢复
				 * （比如，数据库服务暂停，网络中断等等，这样的异常一般称之为系统异常）
				 * 则提示用户稍后重试。如果能够恢复，则立即恢复。
				 */
				out.println("系统繁忙，请稍后重试");
			} 
		}
		}

