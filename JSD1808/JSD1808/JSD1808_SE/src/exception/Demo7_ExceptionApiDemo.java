package exception;
/**
 * 异常常用方法
 * @author OldFarHigh
 *
 */
public class Demo7_ExceptionApiDemo {
	public static void main(String[] args) {
		System.out.println("程序开始了！");
		try {
			String str = "a";
			System.out.println(Integer.parseInt(str));
		} catch (Exception e) {
			e.printStackTrace();	//输出错误堆栈信息，有助于定位错误并改正
			String str = e.getMessage();
			System.out.println(str);
		}
		System.out.println("程序结束了！");
	}
}
