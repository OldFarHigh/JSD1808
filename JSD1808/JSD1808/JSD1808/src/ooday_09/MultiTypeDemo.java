package ooday_09;
/**多态的演示*/
public class MultiTypeDemo {
	public static void main(String[] args) {
		Aoo o = new Boo();//向上造型,定义的父类型变量o引用的是Boo()类型
//		Boo o1= (Boo) o;//父类型变量o指向的子类类型对象就是Boo,所以子类类型变量o1从父类类型变量o可以进行强制转换
//		Inter1 o2 = (Inter1) o;//父类型变量o指向的对象Boo实现了Inter1类型
		//Coo o3 = (Coo) o;//运行错误,ClassCastException类型转换异常
		if(o instanceof Coo) {//false
//			Coo o4 = (Coo) o;
		}else {
			System.out.println(222);
		}
	}
}
interface Inter1{
	
}
class Aoo{
	
}
class Boo extends Aoo implements Inter1{//有继承有实现
	
}
class Coo extends Aoo{
	
}