package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PathServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		System.out.println("username:"+username);
		
		
		//response.sendRedirect(request.getContextPath()+"/jsp03/sub/a4.jsp");
		request.getRequestDispatcher("/jsp03/sub/a4.jsp").forward(request, response);
	}

}
