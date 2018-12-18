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
		response.setContentType("text/html;charsert=UTF-8");
		PrintWriter out = response.getWriter();
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		System.out.println("height:"+height);
		System.out.println("weight:"+weight);
		if(height!=null) {
			double h = Double.parseDouble(height);
			double w = Double.parseDouble(weight);
			String bmi = h/w/w+"";
			out.println("<h1>BMI:"+bmi+"</h1>");
		}else {
			out.println("BMI:0");
		}
				
	}
	
}
