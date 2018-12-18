package oo.day_01;
//学生类的测试
public class StudentTest {

	public static void main(String[] args) {
		//创建一个成员变量有传值的学生对象stu
		Student stu = new Student();
		stu.name = "骚太";
		stu.age = 25;
		stu.address = "桃村";
		stu.study();
		stu.sayHi();
		//创建一个没有值的成员变量的学生对象stu1
		Student stu1 = new Student();
		stu1.study();
		stu1.sayHi();
		//创建三个对象
		Student stu01 = new Student();
		Student stu02 = new Student();
		Student stu03 = new Student();
		//给创建的三个对象成员变量传值
		stu01.name = "骚太";
		stu02.name = "骚灰";
		stu03.name = "老法海";
		
		stu01.age = 21;
		stu02.age = 22;
		stu03.age = 23;
		
		stu01.address ="桃村";
		stu02.address = "杞县";
		stu03.address = "金山寺";
		
		stu01.study();
		stu02.study();
		stu03.study();
		
		stu01.sayHi();
		stu02.sayHi();
		stu03.sayHi();
		
	}

}
