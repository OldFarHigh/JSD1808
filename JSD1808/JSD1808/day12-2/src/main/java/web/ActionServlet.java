package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BmiService;


public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();//获取资源路径
		String path = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));//截取需要用的路径资源
		System.out.println("path:"+path);
		//依据请求路径，调用对应的模型处理
		if("/bmi".equals(path)) {
			String height =  request.getParameter("height");
			String weight =  request.getParameter("weight");
			BmiService bs = new  BmiService();
			String status = bs.bmi(Double.parseDouble(height),Double.parseDouble(weight));
			//将模型返回的处理结果交给对应的视图来展现
			request.setAttribute("status", status);
			request.getRequestDispatcher("/WEB-INF/view2.jsp").forward(request, response);;
			
		}else if("/toBmi".equals(path)){
			request.getRequestDispatcher("/WEB-INF/bmi.jsp").forward(request, response);
		}
	}

}
