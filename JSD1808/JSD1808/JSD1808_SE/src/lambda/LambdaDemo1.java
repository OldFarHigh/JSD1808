package lambda;
/**
 * lambda表达式
 * lambda是JDK8之后推出的一个特性，让我们可以以函数编程
 * 
 * lambda可以更简单的完成匿名内部类创建
 * 
 * 语法规则：
 * ([参数列表])->{
 * 方法体
 * }
 * 
 * 使用lambda创建的匿名内部类所属结构必须只能有一个抽象方法，否则无法使用。
 * @author OldFarHigh
 *
 */
public class LambdaDemo1 {
	public static void main(String[] args) {
		/*
		 * Runnable的创建
		 */
		Runnable r1 = new Runnable() {
			public void run() {
				System.out.println("大家好，我是骚太！");
			}
		};
		Runnable r2 =()->{
			System.out.println("大家好，我是骚灰！");
		};
		/*
		 * 如果方法中只有一句代码，那么lambda中的“{}”可以省略
		 */
		Runnable r3 = ()->System.out.println("大家好，我是老法海！");
		
		
	}
}
