package exception;
/**
 * java异常处理机制中的try-catch
 * 语法：
 * try{
 * 		 可能出现的异常
 * }catch(xxxException e){
 * 		 当 try中出现的XXXXExceptiom后的解决办法
 * }
 * @author OldFarHigh
 *
 */
public class Demo01_TryCatchDemo {
	public static void main(String[] args) {
		System.out.println("我要进来了！");
		try {
			String str = "很不错的风格";
			/*
			 * 当JVM执行到某一句话时若发现了某种异常时，JVM便会实例化对应异常的实例，
			 * 并将整个代码的执行过程设置进去，然后将该异常抛出来。
			 * 
			 */
			System.out.println(str.length());
			System.out.println(str.charAt(0));
			System.out.println(Integer.parseInt(str));
			/*
			 * try语句块中代码出错，以下的内容都不会运行
			 */
			System.out.println("!!!!!");
		}catch(NullPointerException e ) {
			System.out.println("出现了！空指针");
		}catch(StringIndexOutOfBoundsException e) {
			System.out.println("字符串下标越界了！");
			/*
			 * 应当养成一个好习惯，在最后一个catch中捕获Exception,
			 * 这样可以避免因为一个未捕获的异常导致程序中断。
			 */
		}catch(Exception e ) {
			System.out.println("反正就是出了个错！");
		}
		
		
		
		System.out.println("我就蹭蹭不进去！");
	
	}
}
