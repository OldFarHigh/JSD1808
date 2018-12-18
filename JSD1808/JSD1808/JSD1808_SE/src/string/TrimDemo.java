package string;
/**
 * String trim()
 * 去除当前字符串两边的空白字符
 * 返回字符串的副本，忽略前导空白和尾部空白。
 * @author OldFarHigh
 *
 */
public class TrimDemo {
	public static void main(String[] args) {
		String str = "			hello			";
		String trim =  str.trim();
		System.out.println(str);//			hello			
		System.out.println(trim);//hello
	}

}
