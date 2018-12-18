package ooday_02;
//null和引用类型化等号的演示
public class NullRefDemo {
	public static void main(String[] args) {
	Student stu = new Student("骚太");	
	System.out.println(stu.name);//zhangsan
	stu = null;//空，没有指向任何对象
	//System.out.println(stu.name);//编译错误，NullPointerException
	Student stu1 = new Student("骚太");
	Student stu2 = stu1;//指向对象stu1
	stu1.age = 25;
	stu2.age = 18;
	System.out.println(stu1.age);//18
	int a = 10;
	int b = a;//赋值
	 a=25;
	System.out.println(a);//25
	System.out.println(b);//10
	
	}

}
