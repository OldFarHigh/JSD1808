package cn.tedu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 控制器类的基类
 * @author OldFarHigh
 *
 */
@Controller
abstract class BaseController {
	
	protected void run() {
		
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String handleNullPointException(Exception e) {
		if(e instanceof NullPointerException) {
			return "ex_null_new";	
		}else if(e instanceof ArrayIndexOutOfBoundsException){
			return "ex_array_new";
		}
		return null; 
	}
}
