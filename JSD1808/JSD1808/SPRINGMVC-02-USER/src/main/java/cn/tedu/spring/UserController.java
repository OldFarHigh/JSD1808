package cn.tedu.spring;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.CharacterEncodingFilter;

@Controller
@RequestMapping("/user")
public class UserController {
	CharacterEncodingFilter c;
	@RequestMapping("/logout.do")
	public String handleLogout(HttpSession session) {
		//销毁session中的数据
		session.invalidate();
		//退出登录后，重定向到登录页面
		return "redirect:login.do";
	}
	@RequestMapping("/index.do")
	public String showIndex() {
		System.out.println("UserControlle.showIndex()");
		
		return "index";
	}
	
	@RequestMapping("/login.do")
	public String showLogin() {
		System.out.println("UserControlle.showLogin()");
		
		return "login";
	}
	/**
	 * Http Status 400 Required String parameter 'xxx' is not present
	 * 
	 * @param username
	 * @param password
	 * @param modelMap
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/handle_login.do",method=RequestMethod.POST)
	public String showLogin(String username,String password,ModelMap modelMap,HttpSession session){
		System.out.println("username："+username);
		System.out.println("password："+password);
		//设置能提示的错误信息
		String msg=null;
		if("root".equals(username) ){
			//判断密码
			if("1234".equals(password)) {
				//登录成功
				session.setAttribute("username", username);
				return "redirect:index.do";
			}else {
				//密码错误
				msg="密码错误！";
				modelMap.addAttribute("message",msg);
				return "error";
			}
		}else {
			//用户名不存在
			msg ="尝试登录的用户不存在";
			//封装即将转发的数据
			modelMap.addAttribute("message",msg);
			//执行转发
			return "error";
			/*
			String viewName ="error";
			Map<String,Object> model = new HashMap<String,Object>();
			model.put("message",msg);
			ModelAndView mav = new ModelAndView(viewName, model); 
			return mav;*/
		}
	}
	
	@RequestMapping("/reg.do")
	public String showReg() {
		System.out.println("UserController.showReg()");
		return "reg";
	}
	@RequestMapping("/info.do")
	public String showInfo(HttpSession session) {
		//判断用户是否已经登录
		if(session.getAttribute("username")==null) {
			//未登录
			return "redirect:login.do";
			
		}
			//已登录
			return "info";
		
	}
	//3、直接使用自定义类型接收请求参数
	@RequestMapping("/handle_reg.do")
	public String handleReg(User user,HttpServletRequest request) {
		
		//测试输出
		System.out.println("username:"+user.getUsername());
		System.out.println("password:"+user.getPassword());
		System.out.println("age:"+user.getAge());
		System.out.println("phone:"+user.getPhone());
		System.out.println("email:"+user.getEmail());
		
		//假设用户名root已经被占用，是不允许被注册的
		if("root".equals(user.getUsername())) {
			String msg="您尝试注册的用户名已被占用！";
			request.setAttribute("message", msg);
			return "error";
		}
		//假设手机号13800138001已经被占用
		if("13800138001".equals(user.getPhone())) {
			String msg="您尝试注册的手机号已被占用！";
			request.setAttribute("message", msg);
			return "error";
		}
		//假设注册成功，重定向登录界面
		return "redirect:login.do";
	}
	//2、直接将请求参数声明为处理请求的方法的参数 如果请求参数名称与方法中的参数名称无法保持一致，可以添加注解@RequestParam("uname")
	/*@RequestMapping("handle_reg.do")
	public String handleReg(String username,String password,Integer age,String phone,String email) {
		//测试输出
				System.out.println("username："+username);
				System.out.println("password："+password);
				System.out.println("age："+age);
				System.out.println("phone："+phone);
				System.out.println("email："+email);
		//暂不关心后续的显示
		return null;
	}*/
	
	//1、
/*	 @RequestMapping("handle_reg.do")
	public String handleReg(HttpServletRequest request) {
		//通过HttpServletRequest参数对象获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Integer age = Integer.valueOf(request.getParameter("age"));
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		//测试输出
		System.out.println("username："+username);
		System.out.println("password："+password);
		System.out.println("age："+age);
		System.out.println("phone："+phone);
		System.out.println("email："+email);
		//暂时不关心后续的显示
		return null;
	}*/
}
