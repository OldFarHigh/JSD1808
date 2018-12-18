package ooday_08;
/**接口的练习*/
public class interfaceDemo {

	public static void main(String[] args) {
//		Inter4  o1 = new Inter4();//编译错误,接口类不能实例化
//		Inter4  o2 = new Doo();//向上造型
//		Inter3 o3 = new Doo();//向上造型
	}
}
interface Inter1 {//声明接口Inter1,包含常量PI和抽象方法show()
	public static  final double PI = 3.1415;//接口内部只能定义常量
	public abstract void show();//接口内只能定义没有实现的方法,所以public abstract可以省略
}
interface Inter2{
	public abstract void a();//抽象方法,不能有方法体
	public abstract void b();
}
class Aoo  implements Inter2{
	public void a() {};//实现接口必须对接口内部的方法重写
	public void b() {};
}
interface Inter3 {
	void c();
}
abstract class Boo  {
	abstract void d();
}
class Coo extends Boo implements Inter2 ,Inter3{
	public void a() {};//实现接口必须对接口内部的方法重写
	public void b() {}
	public void c() {}
	public void d() {}
}
interface Inter4 extends Inter3 {
	void e();
}
class Doo implements Inter4{
	public void c() {}
	public void e() {}
}


