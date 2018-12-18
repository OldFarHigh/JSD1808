package dayTest_1024;

import java.lang.reflect.Method;

/**
 * 反射
 * 
 * @author OldFarHigh
 *1、加载类对象
 *2、实例化类对象
 *3、获取方法
 *4、调用方法
 */
public class Reflect {
	public static void main(String[] args) throws Exception {
		Class cls = Class.forName("dayTest_1024.Person");
		Object obj = cls.newInstance();
		Method m = cls.getDeclaredMethod("sayHello", String.class,int.class);
		m.invoke(obj, "老法海",22);
	}
}
