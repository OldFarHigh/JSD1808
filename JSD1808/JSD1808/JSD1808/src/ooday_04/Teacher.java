package ooday_04;

public class Teacher extends Person {
	double salary;
	public Teacher(String name, int age, String address, double salary) {
		super(name, age, address);
		this.salary = salary;
	}
	void sayHi() { //重写方法：方法名相同，参数列表相同，方法体不同
		System.out.println("您的名字是:"+name+",年龄是:"+age+",家庭住址是:"+address+",工资是:"+salary);
	}
	
	
}
