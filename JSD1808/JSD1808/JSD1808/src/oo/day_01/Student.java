package oo.day_01;
//创建学生类
public class Student {
		String name;
		int age;
		String address;
		void study() {
			System.out.println(name+"在学习。");
		}
		void sayHi() {
			System.out.println("大家好，我叫"+name+",我今年"+age+"岁了。");
		}
}
