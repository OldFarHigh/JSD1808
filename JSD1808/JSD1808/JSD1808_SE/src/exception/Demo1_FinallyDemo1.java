package exception;
/**
 * finally块
 * finally块是异常处理机制的最后一块。它可以直接跟在try块之后或者最后一个catch块之后。
 * finally确保只要程序执行到try块中，那么finally块中的代码必定执行。
 * 所以通常我们将无关乎程序是否出现异常，都要执行的代码放在其中，比如IO操作后的关闭流。
 * @author OldFarHigh
 *
 */
public class Demo1_FinallyDemo1 {
	public static void main(String[] args) {
		System.out.println("程序开始了！");
		
		try {
	 		String str = "";
//			String str = null;
			System.out.println(str.length());
//			return;
		}catch(Exception e){
			System.out.println("程序出错了!");
		}finally {
			System.out.println("你好，我是finally！");
		}
		
		System.out.println("程序结束了！");
	}
}
