package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener{

	/**
	 * 在session对象创建之后，容器会调用此方法。
	 * HttpSessionEvent是事件对象，该对象提供了一个获得session对象的方法
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("sessionCreated...");
		//获取session对象
		HttpSession session = arg0.getSession();
		//获得servlet上下文
		ServletContext sctx = session.getServletContext();
		//通过servlet上下文获得在线人数
		Integer count = (Integer)sctx.getAttribute("count");
		if(count == null) {
			//为null则为第一个用户
			count =1;
		}else {
			//将在线人数累加
			count ++;
		}
		//将最新的人数，绑定到servlet上下文
		sctx.setAttribute("count", count);
	}
	/**
	 * session对象销毁之后，容器会调用此方法
	 * 
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestoryed...");
		//获取servlet上下文
		ServletContext sctx = arg0.getSession().getServletContext();
		//获取在线人数
		Integer count =(Integer)sctx.getAttribute("count");
		//人数-1
		count --;
		//将最新的人数，绑定到上下文
		sctx.setAttribute("count", count);
		
	}

}
