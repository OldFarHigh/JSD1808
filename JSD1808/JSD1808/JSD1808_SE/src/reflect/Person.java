package reflect;
/**
 * 
 * @author OldFarHigh
 *
 */
public class Person {
	public Person() {
		
	}
	public  Person(String string) {
		
	}
	public void sayHello() {
		System.out.println("Hello!!");
	}
	public void sayHi() {
		System.out.println("Hi!!");
	}
	public void sayHello(String name) {
		System.out.println("大家好，我是："+name);
	}
	public void sayHello(String name,int age) {
		System.out.println("大家好，我是："+name+"，我今年"+age+"岁了！");
	}
}
