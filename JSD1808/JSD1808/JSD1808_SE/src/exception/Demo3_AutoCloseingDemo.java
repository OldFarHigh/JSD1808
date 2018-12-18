package exception;

import java.io.FileOutputStream;

/**
 * 自动关闭特性
 * JDK7之后推出的，使得我们在IO操作中的异常处理写法更简洁。	
 * @author OldFarHigh
 *
 */
public class Demo3_AutoCloseingDemo {
	public static void main(String[] args) {
		try (
				/*
				 * 这里实现了AutoCloseable接口的类的可以定义在这里，
				 * 所有的流和RandomAccessFile都实现了该接口
				 * 编译器最终会将代码改为传统的try-catch-finally的形式，
				 * 并在fianlly中关闭这里定义的流。
				 * 
				 * 				 
				 */
			FileOutputStream fos = new FileOutputStream("fos.dat"))
		{
			fos.write(1);
		} catch (Exception e) {
			System.out.println("恭喜您，出错了!");
		}
	}
}
