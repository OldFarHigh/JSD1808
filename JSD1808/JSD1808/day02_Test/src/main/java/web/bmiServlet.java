package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class bmiServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String gender = request.getParameter("gender");
		System.out.println("height:"+height);
		System.out.println("weight:"+weight);
		System.out.println("gender:"+gender);
		if(gender!=null) {
			double bmi =Double.parseDouble(height)/Double.parseDouble(weight)/Double.parseDouble(weight);
			out.println("BMI:"+bmi);
			if(bmi>24.2) {
				out.println("BMI偏高");
			}else {
				out.print("BMI偏低");
			}
		}else {
			out.println("请输入数据！");
		}
		
			
			
			
		/*}else if(gender=="女") {
			double bmi =Double.parseDouble(height)/Double.parseDouble(weight)/Double.parseDouble(weight);
			out.println("BMI:"+bmi);
			if(bmi>22.2) {
				out.println("BMI偏高");
			}else {
				out.print("BMI偏低");
			}
		}else {
			
		}*/
		
	}

}
