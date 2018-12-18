package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 通过类对象，可以获取其表示的类的一切信息
 * 类名，有哪些属性，哪些方法，哪些构造器等等。
 * 并其可以通过调用无参构造器快速实例化一个对象。
 * @author OldFarHigh
 *
 */
public class ReflectDemo2 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, Exception {
		Class cls = Class.forName("reflect.Person");
		/*
		 * 获取当前类定义的所有构造方法
		 * COnstructor的每一个实例表示这个类的一个构造方法
		 */
		Constructor[] arr = cls.getDeclaredConstructors();
		for (Constructor c : arr) {
			System.out.println(c);
		}
		/*
		 * 获取当前类的所有方法有两个方式：
		 * getDeclaredMethods()
		 * 获取当前自己定义的所有方法
		 * 
		 * getMethods()
		 * 获取当前类的所有方法（包括从超类继承下来的）
		 */
		Method[] arr1 = cls.getDeclaredMethods();
		for (Method m : arr1) {
			System.out.println(m);
		}
		/*
		 *public void reflect.Person.sayHi()
		 *public void reflect.Person.Person(java.lang.String)
		 *public void reflect.Person.Person()
		 *public void reflect.Person.sayHello()
		 */
		Method[] arr2 = cls.getMethods();
		for (Method methods : arr2) {
			System.out.println(methods);
		}
		/*
		 *public void reflect.Person.sayHi()
		 *public void reflect.Person.Person(java.lang.String)
		 *public void reflect.Person.Person()
		 *public void reflect.Person.sayHello()
		 *public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
		 *public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
		 *public final void java.lang.Object.wait() throws java.lang.InterruptedException
		 *public boolean java.lang.Object.equals(java.lang.Object)
		 *public java.lang.String java.lang.Object.toString()
		 *public native int java.lang.Object.hashCode()
		 *public final native java.lang.Class java.lang.Object.getClass()
		 *public final native void java.lang.Object.notify()
		 *public final native void java.lang.Object.notifyAll()
		 */
		Person p = new Person();
		System.out.println("p:"+p);//p:reflect.Person@6d06d69c
		/*
		 * Class提供了一个方法：newInstance
		 * 可以调用器表示的类的无参构造方法进行实例化，并将实例化的对象返回。
		 */
		Object obj = cls.newInstance();
		System.out.println("obj:"+obj);//obj:reflect.Person@7852e922
	}
	
}
