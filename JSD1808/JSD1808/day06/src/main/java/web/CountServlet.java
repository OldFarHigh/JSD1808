package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CookieUtil;

/**
 * 看请求中是否有一个名称为count的cookie，
 * 如果没有，则创建该cookie（值设置为1）
 * 如果有，则将该cookie的值加1，然后再发送浏览器
 * @author OldFarHigh
 *
 */
public class CountServlet extends HttpServlet{
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//查找名称为count的cookie，返回该cookie的值
		String count = CookieUtil.findCookie("count",request);
		if(count ==null) {
			//没有找到名称为count的cookie，则添加该cookie。
			CookieUtil.addCookie("count", "1", 60*60, "/day06", response);
			out.println("你是第:1次访问");
		}else {
			//找到了名称为count的cookie，则将其值加1，然后发送给浏览器。
			int v1 = Integer.parseInt(count)+1;
			CookieUtil.addCookie("count", v1+"", 60*60,"/day06", response);
			out.println("你是第："+v1+"次访问");
		}
	}

}
