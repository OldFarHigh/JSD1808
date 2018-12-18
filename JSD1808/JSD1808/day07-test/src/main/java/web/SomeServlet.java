package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author OldFarHigh
 *
 */
public class SomeServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		System.out.println("sessionId:"+sessionId);
		
		Integer count = (Integer) session.getAttribute("count");
		if(count==null) {
			//如果不存在		
			count =1;
		}else {
			count ++;
		}
		session.setAttribute("count",count);//绑定对象数据
		response.setContentType("text/heml;charset=UTF-8");
		response.getWriter().println("这是第："+count+"次访问");
	}

}
