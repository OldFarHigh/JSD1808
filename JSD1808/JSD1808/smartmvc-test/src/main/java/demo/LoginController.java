package demo;

import javax.servlet.http.HttpServletRequest;

import annotation.RequestMapping;

public class LoginController {
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("smartmvc-test LoginController's tologin()");
		return "login";
	}
	
	
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request) {
		System.out.println("smartmvc-test LoginController's login()");
		String username = request.getParameter("username");
		System.out.println("smartmvc-test's username:"+username);
		String password = request.getParameter("pwd");
		System.out.println("smartmvc-test's password:"+password);
		if("admin".equals(username)&&"admin".equals(password)) {
			return "redirect:toWelcome.do"; 
		}else {
			request.setAttribute("login_failed", "用户名或密码错误");
			return "login";
		}
	}
	
	@RequestMapping("/toWelcome.do")
	public String toWelcome() {
		System.out.println("smartmvc-test LoginController toWelcome()");
		
		return "welcome";
	}
	
}
