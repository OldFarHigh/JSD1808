package cn.tedu.spring;

public class Student {

	public Student() {
		super();
		System.out.println("创建Student对象。。。");
	}

	//初始化方法
	public void init() {
		System.out.println("Student.init()...");
	}
	//销毁方法
	public void destroy() {
		System.out.println("Student.destroy()...");
	}
}
