package day_06;

public class MethodDemo {
	//有参数的更灵活
	//定义无参无返回值的
	public  static void sayHi() {
		System.out.println("大家好，我叫骚太，我今年10岁了");
		}
	//定义有参无返回值的
	public static void sayHello(String name) {
		System.out.println("大家好，我叫"+name+"，我今年10岁了");
	}
	//定义有参两个返回值的
	public static void sayHello(String name,int age) {
		System.out.println("大家好，我叫"+name+"，我今年"+age+"岁了");
	}
	//定义无参有返回值的
	public static String getName() {
		//return;//必须有返回值
		//return 8.88;//返回值必须与返回值类型匹配
		return "骚太";//有返回值，且返回值类型匹配 1）return结束方法的执行
					//2）返回值结果给调用方	
	}
	//定义有参有返回值的数
	public static int plus(int num1,int num2) {
		int num = num1+num2;
		return num;//返回的是num里面的那个数
	}
	//
	public static String plus(String name,int age,int number) {
		String n =name+age+number;
		return n;
	}
	public static void main(String[] args) {
		sayHi();
		sayHello("骚太");
		sayHello("骚太", 10);
		String  n="骚太";
		int a=10;
		sayHello(n);
		sayHello(n,a);
		String name = getName();//getName方法的调用
		System.out.println(name);
		int b = plus(5,5);
		System.out.println(b);//10
		int m=5,n1=6;
		int c= m+n1;
		System.out.println(c);//1
	}
	

}
