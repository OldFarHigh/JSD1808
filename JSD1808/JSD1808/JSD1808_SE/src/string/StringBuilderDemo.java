package string;
/**
 * 由于String的设计不适合频繁修改,对此java提供了一个
 * 用于编辑字符串内容的类：StringBuilder
 * StringBuilder内部维护了一个可变的字符数组，不会每次
 * 修改都来创建新对象，从而降低资源开销，提高执行效率
 * 其提供了方便编辑字符串内容的相关方法，包含：
 * 增、删、改、插等常见操作
 * @author OldFarHigh
 *
 */
public class StringBuilderDemo {
	public static void main(String[] args) {
		String str = "老衲爱java";
		/*
		 * 常见构造方法：
		 * StringBuilder():无参,默认表示空字符串
		 * StringBuilder(String str):表示给定内容
		 */
		StringBuilder sb = new StringBuilder(str);
		/*
		 * 老衲爱java
		 * 老衲爱java，老衲爱拉芳！
		 * append():当前字符串末尾追加给定内容
		 */
		sb.append("，老衲爱拉芳！");//添加指定内容
		System.out.println(sb);//老衲爱java，老衲爱拉芳！
		String s = sb.toString();//获取sb内部编辑后的字符串
		System.out.println(str);//老衲爱java
		System.out.println(s);//老衲爱java，老衲爱拉芳！
		/*
		 * 老衲爱java，老衲爱拉芳！
		 * 老衲爱java，老衲要找个好工作！
		 * replace():替换指定范围内的字符串
		 */
		sb.replace(7, 14, "，老衲要找个好工作！");
		System.out.println(sb.toString());//老衲爱java，老衲要找个好工作！
		/*
		 * delete():删除指定范围内的字符串
		 */
		sb.delete(0, 7);
		System.out.println(sb.toString());//，老衲要找个好工作！
		/*
		 * insert();在当前字符串中插入指定内容
		 */
		sb.insert(0,"骚太");
		sb.insert(5, "一定");
		System.out.println(sb.toString());//骚太，老衲一定要找个好工作！
	}
}
