package exception;
/**
 * finally常见的一个面试题
 * 1）finally 里加return后的输入结果
 * 2）请分别描述：final，finally，finalize
 * fianl：
 * finally：
 * finlize：方法是Object提供的方法，详细参看文档。
 * 			   当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法。
 * @author OldFarHigh
 *
 */
public class Demo4_FinallyDemo3 {
	public static void main(String[] args) {
		System.out.println(test("0")+","+test(null)+","+test(""));
		//0，1，2
		//在finally里加上return后所有返回值变为finally的返回值 3，3，3
	}
	public static int test(String str) {
		try {
			System.out.println("test方法执行了！");//打桩！
			return str.charAt(0) - '0';
		} catch(NullPointerException e){
			System.out.println("出现了空指针！");//打桩！
			return 1;
		} catch (Exception e) {
			System.out.println("出现了异常！");//打桩！
			return 2;
		} finally{
			System.out.println("执行了finally！");//打桩！
//			return 3;//执行后，会将返回值变为3
		}
	}
	
}
