package ooday_04;

public class OverrideDemo {
	public static void main(String[] args) {
		}
	}
//超类大 ， 派生类小
class  Eoo {
	void show() {}
	double say() {return 0.0;}
	Foo test() {return null;}
	Eoo sayHi() {return null;}
}
class Foo extends Eoo{
	//void show() {}//编译正确，与void值相等
	//int show() {} //编译错误，与void值必须相等
	//int say() {return 0;}//编译错误，基本类型必须相等
	//Eoo test() {return null;}//编译错误，派生类方法的返回值类型是引用类型的必须小于或等于超类的
	Foo sayHi() {return null;}//编译正确，返回值类型小于或等于都可以;
}