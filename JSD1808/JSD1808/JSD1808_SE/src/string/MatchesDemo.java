package string;
/**
 * String 支持正则表达式的方法一：
 * boolean matches(String regex)
 * 使用给定的正则表达式验证当前字符串是否满足格式要求
 * 满足则返回true，不满足则返回false
 * 
 * 需要注意！！！
 * 给定的正则表达式，无论是否添加了边界匹配符（^。。。。$）
 * 都是做全匹配验证
 * @author OldFarHigh
 *
 */
public class MatchesDemo {
	public static void main(String[] args) {
		String mail = "jinshantemple@9sxy.cn";
		/*
		 * (a-zA-Z0-9_)+@[a-zA-Z0-9]+(\.[a-zA-Z]+)+
		 */
		String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
		boolean match =mail.matches(regex);
		if (match) {
			System.out.println("是邮箱！");
		}else {
			System.out.println("不是邮箱！");
		}
	}
}
