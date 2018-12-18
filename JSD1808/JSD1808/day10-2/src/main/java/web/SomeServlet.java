package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int count = 0;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 *对有可能产生线程安全问题的代码块加锁
		 *加锁会影响性能
		 */
		synchronized(this){
			count ++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+":"+count);
		}
			
	}

}
