package integer;
/**
 * 由于java中8个基本类型不能直接参与面向对象的开发（不具备面向对象的特性）
 * 因此java为这8个基本类型分别提供了对应的引用类型，我们称它们为：包装类
 * @author OldFarHigh
 *
 */
public class IntegerDemo1 {
	public static void main(String[] args) {
		/*
		 * 基本类型转换为包装类
		 * 
		 */
//		Integer i1 = new Integer(123);//输出false
//		Integer i2 = new Integer(123);//输出true
		
		//推荐使用静态方法valueOf进行转换
		Integer i1 = Integer.valueOf(127);
		Integer i2 = Integer.valueOf(127);
		//valueOf创建整数包装类会缓存一字节内的整数,超过一字节的==相比会错误
		System.out.println(i1==i2);//true
		System.out.println(i1.equals(i2));//true
		//Double则是直接使用new实例
		Double d1 = Double.valueOf(1.0);
		Double d2 = Double.valueOf(1.0);
		System.out.println(d1==d2);//false
		System.out.println(d1.equals(d2));//true
		
		/*
		 * 包装类转换为基本类型
		 * 大往小转可能会丢失精度
		 */
		int d = i1.intValue();
		System.out.println(d);//127
		
		double dou = i1.doubleValue();
		System.out.println(dou);//127.0
		/*
		 * 数字的包装类提供了两个常量
		 * MAX_VALUE,MIN_VALUE分别表示对应基本类型的取值范围
		 */
		//获取int最大值和最小值
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		System.out.println("MAX="+max+",MIN="+min);
		//获取byte最大值和最小值
		byte bmax = Byte.MAX_VALUE;
		byte bmin = Byte.MIN_VALUE;
		System.out.println("bMax="+bmax+"，bMIN="+bmin);
	}
}
