package demo;

import base.annotation.RequestMapping;

/**
 * 处理器：
 * 		负责业务逻辑的处理。
 * 	  注：
 * 		也可以调用其他的类来完成业务逻辑的处理。
 * @author OldFarHigh
 *
 */
public class HelloController {
		/**
		 * @RequestMapping注解用来告诉框架，该方法用来处理哪个请求。
		 */
		@RequestMapping("/hello.do")
		public String hello() {
			System.out.println("HelloController's hello()");
			/*
			 * 返回视图名。
			 * DispatcherServlet(控制器)会依据视图名来生成真正的目标地址。
			 */
			return "hello";
		}
		
}
