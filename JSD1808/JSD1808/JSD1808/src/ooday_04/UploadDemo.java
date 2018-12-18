package ooday_04;
//向上造型的演示
public class UploadDemo {
	public static void main(String[] args) {
		Aoo a = new Aoo();//创建一个超类对象
		a.a = 10;
		a.show();
		
		Boo b = new Boo();//创建一个派生类对象
		b.a = 100;//派生类可以调用超类的成员变量
		b.b = 200;//调用自身的成员变量
		b.show();//派生类可以调用超类的方法
		b.test();//调用自身的方法
		
		Aoo ab = new Boo();//向上造型
		ab.a = 300;
		//ab.b = 100;//编译错误，能访问什么成员，要看引用的是什么类，只能引用的类中包含的成员
		ab.show();//调用A类的方法
		//ab.test();//编译错误
	}

}
class Aoo{ //超类
	int a ;
	void show() {
		
	}
}
class Boo extends Aoo{//派生类
	int b ;
	void test() {
		
	}
}
