package ooday_02;
//创建学生类
public class Student {
		//成员变量
		String name;
		int age;
		String address;
		Student(String name, int age , String address){//局部变量
			this.name = name;
			this.age = age;
			this.address = address;
		}
		Student(String name, int age){
			this(name,age,null);
			
		}
		Student(String name){
			this(name,0, null);
		}
		
		void study() {
			System.out.println(name+"在学习。");
		}
		void sayHi() {
			System.out.println("大家好，我叫"+name+",我今年"+age+"岁了,我家在"+address);
		}
}
