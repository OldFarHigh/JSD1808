package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BMIServlet extends HttpServlet{
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
		System.out.println("height:"+height);
		System.out.println("weight:"+weight);
		if(height==null) {
			out.println("<h1>BMI:0</h1> ");
			out.println("<h1>请输入身高和体重的值</h1>");
		}else {
			String bmi = Double.parseDouble(height)/Double.parseDouble(weight)/Double.parseDouble(weight)+"";
			out.println("<h1>BMI:"+bmi+"</h1>");
		}
	}

}
