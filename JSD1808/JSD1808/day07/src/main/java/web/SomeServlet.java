package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * ##如何获得Session对象
 *  ###1）方式一
 *	HttpSession session = request.getSeeesion(boolean flag)
 *    注：
 *    	HttpSession是一个接口
 *      当flag为true时：
 *       	会先查看请求当中是否含有Session，
 *       	如果没有，则创建一个session对象。
 *       	如果有，则依据sessionId查找对应的session对象，找到了则返回该对象，找不到，则创建一个新的sessionId.
 *      	当flag为false时：
 *      		会先查看请求当中是否有sessionId，
 *      		如果没有，则返回null。
 *      		如果有，则依据sessionId查找对应的session对象，找到了则返回该对象，找不到，返回null
 *   ###2）方式2
 *   HttpSession session = request.getSession();
 *   	注：
 *   		等价于request.getSession(true);
 *   
 *   ###3）常用方法
 *   	session.setAttribute(String name,Object object);//绑定数据
 *   	Object session.getAttribute(String name);//依据绑定名，获得绑定值，如果绑定值不存在，返回null
 *   	session.removeAttribute(String name);//解除绑定
 *   
 *   ###4)session超时
 *   什么是session超时？
 *   	服务器会将空闲时间过长的session对象删除掉。
 *   	目的是为了节省内存空间。
 *   	注：
 *   		大部分服务器默认的超时时间限制是30分钟
 *   
 *   如何修改超时时间？
 *   
 *  方式一 	修改服务器的配置文件（web.xml）
 *  <session-config>
 *       <session-timeout>30</session-timeout>
 *  </session-config>
 *  	方式二 session.setMaxInactiveInterval(int seconds);
 *  		注：
 * 			该方法用于设置两次请求之间的最大间隔，如果超过这个时间，session对象会被销毁
 *###5）删除session
 *	session.invalidate() 使...失效
 *
 *###6)session验证
 *step1.登录成功以后，
 * @author OlFarHigh
 *
 */
public class SomeServlet  extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得session对象
		HttpSession session = request.getSession();
		//设置两次请求之间最大的间隔时间为35s
		//session.setMaxInactiveInterval(35);
		//获得sessionId
		String sessionId = session.getId();
		System.out.println("sessionId:"+sessionId);
		//获得绑定值，如果绑定值不在返回null，存在则返回绑定值
		Integer count = (Integer)session.getAttribute("count");
		if(count == null) {
			//第一次访问，在session对象上绑定次数设置为1
			count = 1;
		}else {
			//不是第一次，将绑定次数加1
			
			count ++;
		}
		//将访问次数绑定到session对象上
		session.setAttribute("count", count);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("你是第："+count+"次访问");
		//使session对象失效
		//session.invalidate();
	}


}
