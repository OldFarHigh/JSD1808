package reflect;

public class B {
	//缺省值为value，如果不为value 必须加上属性名。 多个属性名用" ， "分隔开
	@Test("balabala")
	public void  m1() {
		System.out.println("B's m1()");
	}
	
	public void m2() {
		System.out.println("B's m2()");
	}
	
	@Test("bilibili")
	public void hello(){
		System.out.println("B's hello()");
	}
	
}
