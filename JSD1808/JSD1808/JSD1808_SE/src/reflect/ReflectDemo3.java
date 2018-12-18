package reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 通过反射的方式调用方式
 * @author OldFarHigh
 *
 */
public class ReflectDemo3 {
	public static void main(String[] args) throws Exception {
		Person  p = new Person();
		System.out.println("p："+p);
		p.sayHello();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入要加载的类的完全限定名：");
		String name = scan.nextLine();
		System.out.println("请输入要加载的方法名：");
		String methodName = scan.nextLine();
		/*
		 * 利用反射方式
		 */
		//1、加载类对象
		Class cls = Class.forName(name);
		//2、通过类对象实例化
		Object obj = cls.newInstance();
		System.out.println("obj："+obj);
		//3、获取无参的sayHello方法
		Method method = cls.getDeclaredMethod(methodName, null);
		//4、调用该方法
		method.invoke(obj, null);
		/*
		 * Method类的每一个实例用于表示一个类中的一个方法其提供了动态调用该方法的操作：
		 * invoke(Object o ,Object[] arg)
		 * 第一个参数为调用哪个实例的对应方法，第二个参数为调用该对应方法时传递的实际参数。
		 */
		/*
		 * 利用反射方式创建
		 */
		//1、加载类对象
		Class cls1 = Class.forName("reflect.Person");
		//2、通过类对象实例化
		Object obj1 = cls1.newInstance();
		//3、获取无参的sayHi()方法
		Method m = cls1.getDeclaredMethod("sayHello", String.class);
		//4、调用该方法
		m.invoke(obj1, "张三");
	}
}
