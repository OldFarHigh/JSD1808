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
	public BMIServlet() {
		 System.out.println("HeloServlet's constructor...");
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BMIServlet's service");
			String height =request.getParameter("height");
			System.out.println("height:"+height);
			String weight =request.getParameter("weight");
			System.out.println("weight:"+weight);
			response.setContentType("text/html");
			PrintWriter out  = response.getWriter();
			if(height!=null) {
				double h = Double.parseDouble(height);
				double w = Double.parseDouble(weight);
				String BMI = w/h/h+"";
				out.println("<h1>BMI:"+BMI+"</h1>");
			}else {
				out.println("<h1>BMI:0</h1>");
			}
			out.close();
	}
	
}
