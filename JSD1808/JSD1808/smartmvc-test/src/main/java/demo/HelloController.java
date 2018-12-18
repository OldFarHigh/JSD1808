package demo;

import annotation.RequestMapping;

/**

 * 方法前要添加@RequestMapping注解，该注解用来指定该方法用来处理哪个请求。方法返回视图名。
 * author OldFarHigh
 *
 */
public class HelloController {
	@RequestMapping("/hello.do")
	public String hello() {
		System.out.println("smartmvc-test's HelloControl's hello()");
		/**
		 *返回视图名。
		 *DispatcherServlet(控制器)会依据视图名来生成真正的目标地址
		 */
		return "hello";
	}
}
