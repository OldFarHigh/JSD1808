package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
