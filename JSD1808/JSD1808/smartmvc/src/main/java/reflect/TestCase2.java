package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCase2 {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class clazz = Class.forName("reflect.B");//动态加载B类
		Object obj = clazz.newInstance();
		
		Method[] methods = clazz.getDeclaredMethods();
		for(Method mh  : methods) {
			//获得加在该方法前的@Test注解
			Test test = mh.getDeclaredAnnotation(Test.class);
			System.out.println("test:"+test);
			//只执行带有@Test注解的方法
			if(test != null) {
				mh.invoke(obj);
				//读取@Test注解的属性值
				String vl = test.value();
				System.out.println("vl:"+vl);
			}
		}
		
	}
	
}	
