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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获得上下文
		ServletContext sctx  = getServletContext();
		String users =(String)sctx.getAttribute("users");
	
		
		//获得session
		HttpSession session = request.getSession();
		String users2 = (String) session.getAttribute("users");
		response.getWriter().println(users2);
		
		//读取全局的初始化参数
		String company =  sctx.getInitParameter("company");
		response.getWriter().println(company);
		
	}

}
