package dayTest_1101;

public class test {
	public static void main(String[] args) {
		new Sub();
	}

}
class Sub extends Super{
	int a = 5;
	public Sub()  {
		super();
	}
	public void test() {
		System.out.println(a);
	}
}
class Super{
	int a = 6;
	public Super() {
		test();
	}
	public void test() {
		System.out.println(a);
	}
}