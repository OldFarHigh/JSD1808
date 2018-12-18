package day_06;

public class MthodDemo_01 {
	//定义无参无返回值的函数
	public static void sayHi() {
		System.out.println("大家好，我叫骚太，我今年10岁了");
	}
	//定义有一个参数无返回值的函数
	public static void sayHello(String name) {
		System.out.println("大家好，我叫"+name+",我今年10岁了");
	}
	//定义有两个参数无返回值的函数
	public static void sayHello(String name,int age){
		System.out.println("大家好，我叫"+name+"，我今年"+age+"岁了");
	}
	//定义有返回值，无参数的函数
	public static int number() {
		return 10;
	}
	//定义有返回值，且有一个参数的函数
	public static int number(int a) {
		return a;
	}
	//定义有返回值，且有两个参数的函数
	
	public static void main(String[] args) {
		sayHi();
		sayHello("骚太");
		//sayHello("骚太"，10);
	}

}
