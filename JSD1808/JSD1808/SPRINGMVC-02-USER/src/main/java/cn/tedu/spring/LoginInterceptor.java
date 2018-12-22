package cn.tedu.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//测试输出
		System.out.println("LoginInterceptor.preHandle()");
		/*
		 * 拦截规则：
		 * 		如果未登录，重定向到登录，并拦截
		 * 		如果已登录，直接放行
		 */
		HttpSession session = request.getSession();
		if(session.getAttribute("username") == null) {
			response.sendRedirect("../user/login.do");//
			return false;
			
		}
		//true 放行      false 拦截
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("LoginInterceptor.postHandle()");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("LoginInterceptor.afterCompletion()");
	}

}
