package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public HelloServlet() {
		 System.out.println("HeloServlet's constructor...");
	}
	@Override
	/**
	 * servlet容器在收到请求之后，会调用servlet的service方法来处理请求。
	 * 注：
	 * 		容器会将request对象和response对象事先创建好，然后作为参数传递给service方法。
	 * 容器会将请求数据包中的数据解析出来，然后存放到request对象上，开发人员只需要调用request对象提供的方法
	 * 就可以获得请求数据包中的所有数据（比如获得请求参数值）。
	 * 		另外，开发人员只需要将处理结果存放到response对象上即可，容器会从respinse对象上获得处理结果，然后创建
	 * 响应数据包并发送给浏览器。	
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloServlet's service....");
		/*
		 * 通过request对象获得请求参数值.
		 * 注意：如果请求参数名与实际传递过来的请求参数名不一样，会获得null值
		 */
		String name  = request.getParameter("name");
		System.out.println("name:"+name);
		/*
		 * 设置响应类型（即设置content-type  消息头）。
		 * 注：
		 * 		通过设置响应类型，可以告诉浏览器，服务器返回的数据类型。
		 * 		浏览器会采用相应的方式来解析服务器返回的数据。
		 */
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		/*
		 * out.println方法只是将数据存放到了response对象里面。
		 */
		out.println("<h1>Hello "+name+"</h1>");
		/*
		 * 用close方法关闭流
		 * 注：
		 * 		不调用close方法也可以，容器会自动关闭流。
		 */
		out.close();
		/*
		 * step1:浏览器依据ip和port建立连接
		 * step2:浏览器将相关数据添加到请求数据包里面，然后发送给服务器
		 * step3:服务器会解析请求数据包中的数据，并且将这些数据添加到request对象里面，同时还会创建一个reponse对象
		 * 注：开发人员可以通过request对ixang获得请求数据包中的数据，比如获得请求参数值，可以将处理结果写到
		 * response对象里面，容器会从response对象中获取处理结果，然后创建响应数剧包，并发送给浏览器
		 * step6:浏览器解析响应数据包，依据解析到的数据生成响应的页面
		 * 
		 * 常见错误
		 * （1）404
		 * a。含义：404是一个状态码，表示服务器依据请求路径找不到对应的资源
		 * b。原因：
		 * 		b1.请求路径写错
		 * 				应该按照http：//ip：port/appname/url-pattern来写
		 * 		b2.应该没有部署或者部署失败
		 * 	（2）500
		 * a。含义：500是一个状态码，表示服务器运行出错
		 * b。原因：
		 * 		b1.代码没有严格遵守servlet规范。
		 * 		比如，没有实现servlet接口或者继承HttpServlet类
		 * 		又比如web.xml中将servlet-class写错或者servlet-name不一致。
		 * 
		 * 		b2.代码不严谨.
		 * 		比如，对请求参数没有做检查就做类型转换.
		 * 
		 * 	（3）405
		 * a。含义：服务器找不到处理方法。
		 * b。原因：
		 * 		service方法没有按照正确的格式来写，即：没有正确override
		 * 		Http
		 * 
		 */
	}

}
