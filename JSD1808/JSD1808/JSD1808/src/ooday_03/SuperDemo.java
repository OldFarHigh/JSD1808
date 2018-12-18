package ooday_03;

public class SuperDemo {
	public static void main(String[] args) {
		//Boo b = new Boo();
		//Doo d = new Doo();
		
		}
}
//默认调用超类的构造方法
class Aoo{
	Aoo(){
		System.out.println("演示：超类的构造方法");
	}
}
class Boo extends Aoo{
	Boo(){
		//super();//默认调用超类的构造方法，且super必须在第一行
		System.out.println("演示：派生类的构造方法");
	}
}
//超类有无参的构造函数时
class Coo{
	Coo( String name){
		System.out.println("你好："+name);
	}
}

class Doo extends Coo{
	
	Doo(){
		super("骚灰");
	}
}