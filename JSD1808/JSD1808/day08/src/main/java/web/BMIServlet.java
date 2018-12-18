package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BMIServlet extends HttpServlet{
	private int min1;
	private int max1;
	private int min2;
	private int max2;
	@Override
	public void init() throws ServletException {
		//继承自GenericServlet提供的方法来获得ServletConfig对象
		ServletConfig config = getServletConfig();
		//读取初始化参数
		String male =config.getInitParameter("male");
		String female = config.getInitParameter("female");
		//将获得的参数值进行拆分，获得参数值数组
		String[] males = male.split(",");
		min1 = Integer.parseInt(males[0]);//获取参数值数组中的第一个参数值
		max1 = Integer.parseInt(males[1]);

		String[] females = female.split(",");
		min2 = Integer.parseInt(females[0]);//获取参数值数组中的第一个参数值
		max2 = Integer.parseInt(females[1]);
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//读取身高、体重和性别
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String gender = request.getParameter("gender");
		
		//依据从浏览器获取的身高、体重来计算bmi指数
		double bmi = Double.parseDouble(weight)/Double.parseDouble(height)/Double.parseDouble(height);
		
		//依据性别和bmi指数，来判断一个人的体重状况
		String status = "正常";
		if("m".equals(gender)) {
			//当性别为男性时
			if(bmi < min1) {
				status ="体重过轻";
			}
			if(bmi > max1) {
				status ="体重过重";
			}
		}else {
			//当性别为女性时
			if(bmi < min2) {
				status ="体重过轻";
			}
			if(bmi > max2) {
				status ="体重过重";
			}
		}
		
		out.println("你的BMI指数是："+bmi+"体重："+status);
	}

}
