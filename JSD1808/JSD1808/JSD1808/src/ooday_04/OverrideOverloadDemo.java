package ooday_04;

public class OverrideOverloadDemo {

	public static void main(String[] args) {
		Go goo =new Go();
		Eo o = new Fo();
		goo.test(o);//重载看参数类型，重写看对象类型
	}

}
class  Go{
	void test(Eo o) {
		System.out.println("超类型参数");
		o.show();
		}
	void test(Fo o) {
		System.out.println("派生类型参数");
		o.show();
	}
}
class Eo{
	void show() {
		System.out.println("超类show ");
	}
}
class Fo extends Eo{
	void show() {
		System.out.println("派生类show ");
	}
}
