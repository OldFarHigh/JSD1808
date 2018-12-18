package string;
/**
 * String toUpperCase()
 * String toLowerCase()
 * 将当前字符串中的英文部分转换为全大写或全小写
 * @author OldFarHigh
 *
 */
public class ToUpperCaseDemo {

	public static void main(String[] args) {
		String str = "Thinking In Java";
		
		String upper = str.toUpperCase();
		System.out.println(upper);//THINKING IN JAVA
		
		String lower = str.toLowerCase();
		System.out.println(lower);//thinking in java
		

	}

}
