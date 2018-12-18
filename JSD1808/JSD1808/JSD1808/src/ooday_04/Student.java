package ooday_04;

public class Student  extends Person{
	int stuId;
	public Student(String name, int age, String address,  int stuId) {
		super(name, age, address);
		this.stuId = stuId;
	}
	void sayHi() {
		System.out.println("您的名字是:"+name+",年龄是:"+age+",家庭住址是:"+address+",学生ID是:"+stuId);
	}
	
	
}
