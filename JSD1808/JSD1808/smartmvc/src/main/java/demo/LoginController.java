package demo;

import javax.servlet.http.HttpServletRequest;

import base.annotation.RequestMapping;

public class LoginController {
	
	@RequestMapping("/toLogin.do")
	public String toLogin() {
		System.out.println("LoginController's toLogin()");
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request){
		System.out.println("LoginController's login()");
		//获取请求对象发送的用户名和密码
		String username = request.getParameter("username");
		System.out.println("username:"+username);
		String password = request.getParameter("pwd");
		System.out.println("password:"+password);
		
		if("tom".equals(username)&&"test".equals(password)) {
			//登录成功，重定向到toWelcome.do页面
			//如果视图名以redirect:开头，表示重定向到某个地址。
			return "redirect:toWelcome.do";
		}else {
			//登录失败，转发到登录页面并提示用户
			request.setAttribute("login_failed", "用户名或密码错误");
			return "login";
		}
	}
	
	@RequestMapping("/toWelcome.do")
	public String toWelcome() {
		System.out.println("LoginController's toWelcome()");
		return "welcome";
	}
}
