package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class BServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得上下文
		ServletContext sctx  = getServletContext();
		String users =(String)sctx.getAttribute("users");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println(users);
		
		//获得session
		HttpSession session = request.getSession();
		String users2 = (String) session.getAttribute("users");
		response.getWriter().println(users2);
	}

}
