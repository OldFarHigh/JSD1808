package string;
/**
 * int indexOf(String str)
 * 查找给定字符串在当前字符串中的位置，
 * 若当前字符串不包含该内容则返回值为-1；
 * @author OldFarHigh
 *
 */
public class IndexOfDemo {
	public static void main(String[] args) {
		//		          0123456789..
		String str = "thinking in java";
		//查找给定字符串在当前字符串中的位置
		int  index = str.indexOf("thinking");
		System.out.println(index);//0
		index = str.indexOf("in");
		System.out.println(index);//2
		//从指定位置开始查找第一次出现在给定字符的位置
		index  = str.indexOf("in",3);
		System.out.println(index);//5
		//查找最后一次出现在给定字符的位置
		index = str.lastIndexOf("in");
		System.out.println(index);//9
		
	}

}
