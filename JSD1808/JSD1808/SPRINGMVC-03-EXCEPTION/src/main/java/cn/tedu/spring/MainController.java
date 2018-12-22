package cn.tedu.spring;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class MainController {
	@ExceptionHandler(RuntimeException.class)
	public String handleNullPointException(Exception e) {
		if(e instanceof NullPointerException) {
			return "ex_null_new";	
		}else if(e instanceof ArrayIndexOutOfBoundsException){
			return "ex_array_new";
		}
		return null; 
	}
	@ExceptionHandler({IndexOutOfBoundsException.class,ClassCastException.class})
	public String handleException(Exception e) {
		//判断异常种类并处理
		if(e instanceof ArrayIndexOutOfBoundsException) {
			//数组下标越界异常，转发到ex_array
			return "ex_array";
		}
		//暂不关心正常执行时如何返回
		return null;
	}
	
		@RequestMapping({"null.do","pointer.do"})
		public String showNull(String username) {
			//产生异常
				username.length();
			//暂不关心正常执行时如何返回
			return null;
		}
		
		@RequestMapping("array.do")
		public String showArray() {
			//产生异常
			int[] array = {};
			System.out.println(array[100]);
			//暂不关心正常执行时如何返回
			return null;
		}
}		
