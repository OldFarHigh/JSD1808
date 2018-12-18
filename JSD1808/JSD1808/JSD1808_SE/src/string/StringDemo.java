package string;
/**
 * JVM对String有一个优化措施，即:常量池
 * java推荐我们使用"字面量"形式创建字符串对象,因为当我们这样做时,
 * 虚拟机会首先检查常量池中是否创建过该内容的字符串对象,若有,则直接重用对象
 * 这样做可以减少内存中出现大量内容一样的字符串对象而带来的资源消耗等问题.
 * @author OldFarHigh
 * @version 1.1
 * @see java.lang.String
 * @since JDK1.0
 *
 */
public class StringDemo {
	public static void main(String[] args) {
		String s1 = "OldFarHigh";
		String s2 = "OldFarhigh01";
		String s3 = "OldFarHigh";//重用s1对象
		String s4 ="OldFarHigh";//重用s1对象
		String s5 = new String("OldFarHigh");
		//new则强制创建新对象，不能再重用原来对象的地址值
		System.out.println(s1==s2);//false
		System.out.println(s1==s3);//true
		System.out.println(s2==s3);//false
		System.out.println(s1==s4);//true
		System.out.println(s1==s5);//false
		System.out.println(s1.equals(s5));//true
		/*
		 * 字符串时不变对象，创建后内容不可改变，
		 * 若改变必须创建新对象
		 */
		s1 = s1+"!";//s1修改后创建了新的对象
		System.out.println("s1="+s1);//s1=OldFarHigh!
		//s1已经不再和s2使用同一个对象
		System.out.println(s1==s2);//false
		/*
		 * 编译器有一个优化措施，在编译源代码时若发现一个计算表达式参与的值都是字面量时，
		 * 会直接进行计算并将结果编译到class文件中，所以下面的代码会被编译器改为：
		 * 	String s6 = "OldFarHigh";
		 * 有时候用一个计算表达式更能说明赋值的意义，而编译器会在编译时进行计算，
		 * 对于JVM运行代码时没有任何差别。
		 */
		String s6 = "Old"+"FarHigh";
		System.out.println("s6="+s6);
		System.out.println(s3==s6);//true
		
		String s = "Old";
		String s7 = s+"FarHigh";
		System.out.println("s7="+s7);
		System.out.println(s3==s7);//false
		int a = 1;
		a = a+1;
		System.out.println(a);
	}

}
