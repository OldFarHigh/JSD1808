package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet  extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DateServlet() {
		System.out.println("DateServlet's constructor");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DateService's service");
		Date date = new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		String line =sdf.format(date);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>"+line+"</h1>");
		out.close();
	}
	
}
