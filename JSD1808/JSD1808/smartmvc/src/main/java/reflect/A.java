package reflect;

public class A {
	public void f1() {
		System.out.println("A's f1");
	}
	public String  f2() {
		System.out.println("A's f2");
		return "I'm f2";
	}
	public String  f3(String s1,int s2) {
		System.out.println("A's f3()");
		return s1+s2;
	}
}
