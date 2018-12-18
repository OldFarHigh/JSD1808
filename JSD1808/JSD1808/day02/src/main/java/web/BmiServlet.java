package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BmiServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws 
	ServletException, IOException {
		
		//读取身高和体重
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		
		/*
		 * 服务器端，一定要对请求参数值做合法性的检查，
		 * 比如，检查身高和体重是否是非数字等等，如果
		 * 不符合要求，要提示用户进行修改。
		 */
		
		//依据身高和体重，计算BMI指数
		double bmi = Double.parseDouble(weight)/
				Double.parseDouble(height)/
				Double.parseDouble(height);
		
		//将处理结果发送给浏览器
		/*
		 * 1、设置content-type消息头的值
		 * 2、out.println方法会使用指定的字符集来编码
		 */
		response.setContentType("text/html;charset=utf-8");
		/*
		 * out.println()方法会默认使用ISO-8859-1这个字符集来编码。如果是中文，会发生编码错误，产生乱码问题。
		 */
		response.getWriter().println("你的BMI指数是:" + bmi);
	}
	
	
}





