package reflect;

import java.lang.reflect.Method;

/**
 * 调用有参数的方法
 * @author OldFarHigh
 *
 */
public class ReflectDemo4 {
	public static void main(String[] args) throws Exception {
		Person p = new Person();
		p.sayHello("OldFarHigh");
		
		Class cls = Class.forName("reflect.Person");
		Object obj = cls.newInstance();
		//获取sayHello(String)
//		Method m = cls.getDeclaredMethod("sayHello", String.class);
		Method m = cls.getDeclaredMethod("sayHello", Class.forName("java.lang.String"));
		m.invoke(obj, "张三");
		//获取sayHello(String,int)
		Method m1 = cls.getDeclaredMethod("sayHello", String.class,int.class);
		m1.invoke(obj, "张三",22);
	}
}
