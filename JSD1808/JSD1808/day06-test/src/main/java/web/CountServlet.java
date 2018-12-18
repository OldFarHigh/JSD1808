package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CookieUtil;

/**
 * 
 * @author OldFarHigh
 *
 */
public class CountServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//查询是否有名为count的cookie。
		String count = CookieUtil.findCookie("count",request);
		//如果不存在名为count的cookie执行添加步骤
		if(count ==null) {
			CookieUtil.addCookie("count", "1", 60*60, "/day06-test", response);
			out.println("这是第：1次访问");
		}else {
		//如果存在名为count的cookie则次数加1
			int v = Integer.parseInt(count)+1;
			CookieUtil.addCookie("count", v+"", 60*60, "/day06-test", response);
			out.println("这是第："+v+"次访问");
		}
		
	}

}
