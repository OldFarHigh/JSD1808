package integer;
/**
 * JDK1.5推出时，发布了一个新的特性：自动拆装箱
 * 该特性是编译器认可，而非虚拟机。编译器在编译源代码时
 * 发现基本类型和引用类型相互赋值时，会自动添加代码补全
 * 它们之间的转换操作
 * @author OldFarHigh
 *
 */
public class IntegerDemo2 {
	public static void main(String[] args) {
		int d = 123;//d为基本类型
		/*
		 * 这里触发了编译器自动装箱特性：
		 * 编译器会补全代码，将基本类型转换为包装类
		 * 下面的代码在编译后的class文件中为：
		 * Integer i =Integer.valueOf(d) ;
		 */
		Integer i = d;//i为引用类型
		//Integer i =Integer.valueOf(d) ;//在class文件中应编译为
		d = i;//引用类型和基本类型相互转换
		// d=i.intValue();//在class文件中应编译为
		/*
		 * 触发自动拆箱特性，编译器会改为：
		 * d=i.intValue();
		 */
		
	}
}
