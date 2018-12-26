package cn.tedu.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ajax.entity.ResponseResult;
import cn.tedu.ajax.entity.User;
import cn.tedu.ajax.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@PostMapping("/reg.do")
	@ResponseBody
	public ResponseResult handleReg(User user) {
		ResponseResult rr = new ResponseResult();
		Integer result = userService.reg(user);
		if(result ==1) {
			rr.setState(result);
			rr.setMessage("注册成功！");
		}else if (result == 2){
			rr.setState(result);
			rr.setMessage("注册失败，您尝试注册的"+user.getUsername()+"用户名已被占用！");
		}else if(result == 3) {
			rr.setState(result);
			rr.setMessage("注册失败，注册过程中发生未知错误，请联系系统管理员！");
		}
		return rr;
	}
	@PostMapping("/login.do")//@RequestMapping(method=RequestMethod.Get)
	//@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult handleLogin(String username,String password) {
		ResponseResult rr = new ResponseResult();
		//假设root/1234是正确的帐号密码
		if("root".equals(username)) {
			if("1234".equals(password)) {
				rr.setState(1);
				rr.setMessage("登录成功！");
				
			}else {
				rr.setState(3);
				rr.setMessage("登录失败,密码错误!");
			}
		}else {
			rr.setState(2);
			rr.setMessage("登录失败,用户名错误！");
		}
		return rr;
	}
}
