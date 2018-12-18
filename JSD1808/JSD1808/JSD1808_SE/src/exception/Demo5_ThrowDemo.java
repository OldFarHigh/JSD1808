package exception;
/**
 * 通常遇到以下两种情况是我们会主动向外抛出异常、
 * 1：当遇到满足语法要求但是不符合业务逻辑要求时，可以主动抛出异常。
 * 2：确实程序出现了异常，但是异常不应当在当前代码片段中被解决时可以对外抛出。
 * @author OLdFarHigh
 *
 */
public class Demo5_ThrowDemo {
	public static void main(String[] args) {
		System.out.println("程序开始！");
		//以第一种情况演示异常的抛出
		Demo5_Person  p = new Demo5_Person();
		try {
			/*
			 * 当调用一个含有throws声明异常抛出的方法时，编译器要求我们必须处理该异常，而处理的方式有两种：
			 * 1、使用try-catch捕获并处理该异常。
			 * 2、在当前方法上技术使用throws声明该异常的抛出。
			 * 具体选取哪种取决于异常解决的责任问题。
			 * 注意：不要在main方法上使用throws！
			 */
			p.setAge(1000);
		} catch (IllegalAgeException e) {
			System.out.println("出错了！");
		}
		System.out.println("年龄："+p.getAge());
		System.out.println("程序结束！");
	}
}
