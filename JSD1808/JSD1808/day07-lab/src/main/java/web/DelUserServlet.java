package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

/**
 * 删除用户
 * @author OldFarHigh
 *
 */
public class DelUserServlet  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	
	 *查看用户有没有登录，只有登录过的用户才能访问用户列表 
	*/	 
		HttpSession session = request.getSession();//获取session对象。
		Object obj = session.getAttribute("user");//获取登录状态的对象
		
		if(obj==null) {
			//没有登录，重定向到登录界面
			response.sendRedirect("Login.jsp");
			return;//退出运行
		}
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		UserDAO dao = new UserDAO();
		try {
		dao.delete(id);
		response.sendRedirect("list");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙，请稍后重试");
		}
	}
}
