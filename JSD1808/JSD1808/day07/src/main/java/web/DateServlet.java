package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DateServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//获取session对象
		HttpSession session = request.getSession();
		//获得sessionId
		String  sessionId = session.getId(); 
		System.out.println("sessionId:"+sessionId);
		Date date = (Date)session.getAttribute("date");
		if(date==null) {
			//第一次访问，显示“你是第一次访问”。
			out.print("这是第一次访问");
		}else {
			out.println("上次运行时间是："+date);
		}
		//将访问次数绑定到session对象上
		session.setAttribute("date",new Date());
	}

}
