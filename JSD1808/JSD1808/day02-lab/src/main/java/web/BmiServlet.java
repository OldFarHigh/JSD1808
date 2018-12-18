package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author OldFarHigh
 *
 */
public class BmiServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String height = request.getParameter("height");
		System.out.println("height:"+height);
		String weight = request.getParameter("weight");
		System.out.println("weight:"+weight);
		String gender = request.getParameter("gender");
		System.out.println("gender:"+gender);
		response.setContentType("text/html;charset=utf-8");
		if(gender==null) {
			response.getWriter().println("请输入数据！");
		}else if(gender=="男") {
		double	BMI = Double.parseDouble(weight)/Double.parseDouble(height)/Double.parseDouble(height);
			 if(BMI<20) {
				 response.getWriter().println("体重过轻");
			 }else if(BMI>25) {
				 response.getWriter().println("体重过重");
			 }else {
				 response.getWriter().println("正常");
			 }
		}else {
			double	BMI = Double.parseDouble(weight)/Double.parseDouble(height)/Double.parseDouble(height);
			 if(BMI<19) {
				 response.getWriter().println("体重过轻");
			 }else if(BMI>24) {
				 response.getWriter().println("体重过重");
			 }else {
				 response.getWriter().println("正常");
			 }
		}
		
			
		}

}
