package base.common;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import base.annotation.RequestMapping;

/**
 * 映射处理器：
 * 		建立请求路径与处理器的对应关系。
 * @author OldFarHigh
 *
 */
public class HandlerMapping {
	/*
	 * handlerMap用于存放请求路径与处理器的对应关系。
	 *  	注：
	 *  		Handler对象封装了处理器及Method对象
	 */
	private Map<String,Handler> handlerMap = new HashMap<String,Handler>();
	//依据请求路径返回Handler对象
	public Handler getHandler(String path) {
		return handlerMap.get(path);
	}
	/**
	 * 负责建立请求路径与处理器的对应关系
	 */
	public void process(List beans) {
		//遍历由处理器实例组成的集合
		for (Object bean : beans) {
			//获得Class对象
			Class clazz = bean.getClass();
			//获得处理器的所有方法
			Method[] methods = clazz.getDeclaredMethods();
			//遍历所有方法
			for (Method mh : methods) {
				//获得加载方法前的@RequestMapping注解
				RequestMapping rm = mh.getDeclaredAnnotation(RequestMapping.class);
				//获得请求路径
				String path = rm.value();
				System.out.println("path:"+path);
				//建立请求路径与处理器的对应关系
				handlerMap.put(path, new Handler(mh,bean));
				
				
			}
		}
		System.out.println("handlerMap:"+handlerMap);
	}

}
