package common;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import annotation.RequestMapping;
/**
 * HandlerMapping 
 * 		作用是维护一个Http请求和Controller映射关系列表（Map）
 * 		Dispatcher控制器可以将用户请求映射到Controller组件上
 * @author OldFarHigh
 *
 */
public class HandlerMapping {
	
	private Map<String,Handler> handlerMap  = new HashMap<String,Handler>();
	public Handler getHandler(String path) {
		return handlerMap.get(path);
		
	}
	public void process(List beans) {
		//遍历处理器实例
		for (Object bean : beans) {
			//获得Class对象
			Class clazz = bean.getClass();
			//通过Class对象获得处理器的所有方法
			Method[] methods = clazz.getDeclaredMethods();
			//遍历所有的方法
			for (Method mh : methods) {
				//获得方法前的所有@RequestMapping注解
				RequestMapping rm = mh.getDeclaredAnnotation(RequestMapping.class);
				//通过注解的属性值获得路径
				String path = rm.value();
				//打桩输出路径
				System.out.println("smartmvc-test's path:"+path);
				//将请求路径和处理器的对应关系放在散列表中
				handlerMap.put(path, new Handler(mh,bean));
			}
		}
		System.out.println("smartmvc-test's handlerMap:"+handlerMap);
	}

}
