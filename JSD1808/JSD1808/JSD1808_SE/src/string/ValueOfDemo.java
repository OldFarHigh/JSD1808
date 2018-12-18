package string;
/**
 * static String valueOf()
 * 该方法用若干的重载，参数囊括基本类型及引用类型
 * 但是方法的作用是同样的，将给定的内容转换为字符串形式
 * 比较常用的是将基本类型转换为字符串
 * @author OldFarHigh
 *
 */
public class ValueOfDemo {
	public static void main(String[] args) {
		int a = 123;
		String str = String.valueOf(a);
		System.out.println(str);//123
		
		str = a+"";
		System.out.println(str);//123
		
		double d = 123.123;
		str = String.valueOf(d);
		System.out.println(str);//123.123
		

	}

}
