package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得Servlet上下文
		ServletContext sctx = getServletContext();
		//绑定数据到Servlet上下文
		sctx.setAttribute("users", "花千骨,小七");
		
		//获得session
		HttpSession session = request.getSession();
		//绑定数据到session
		session.setAttribute("users", "苍老师");
	}

}
