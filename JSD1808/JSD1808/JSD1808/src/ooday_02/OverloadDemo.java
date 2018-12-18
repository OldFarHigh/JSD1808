package ooday_02;
/*
 * 1)一个文件中可以包含多个类
 * 2)public修饰的类只能有一个
 * 3)public修饰的类名必须与文件名一致
 * 
 */
class Aoo{
	void say() {};
	void say(String name) {};
	void say(int age) {};
	void say(String name,int age) {};
	void say(int age, String name) {};
	//int say() {};//编译错误，重载与返回值类型无关
	//void say(String address) {};//编译错误，重载与参数名无关，与参数类型有关
}

class Boo{
	
}
/*
 * public Coo{ 
 *     编译错误，public修饰的类只能有一个，public修饰的类名必须与文件名一致
 * }
 */
	

public class OverloadDemo {

	public static void main(String[] args) {
		Aoo a = new Aoo();
		a.say();
		a.say("骚太");
		a.say(17);
		a.say("骚太", 17);
		a.say(17, "骚太");

	}

}
