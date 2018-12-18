package string;

import java.util.Arrays;

/**
 * String 支持正则表达式方法2：
 * String[] split(String regex)
 * 将当前字符串按照满足正则表达式的部分进行拆分，
 * 将拆分后的内容以String数组形式返回
 * 
 * @author OldFarHigh
 *
 */
public class SplitDemo {
	public static void main(String[] args) {
	String str = "abc123def456ghi";
	//按照数字拆分
	//String[] arr = str.split("[0-9]+");
	String[] arr = str.split("\\d+");
	System.out.println(arr.length);//3
	System.out.println(Arrays.toString(arr));//[abc, def, ghi]
	/**
	 * 在拆分时，若连续匹配到拆分内容，则中间会拆分出一个空字符串
	 * 但是在字符串末尾连续匹配的话，拆分的空字符串会全部忽略
	 */
	str = "......1,2,3,4,5,6,7,8,9";
	arr = str.split("\\.");//按照.来拆分
	System.out.println(arr.length);//7，连续匹配到拆分内容，拆分出一个空字符串
	System.out.println(Arrays.toString(arr));//[, , , , , , 1,2,3,4,5,6,7,8,9]
	str = "1,2,3,4,5......,6,7,8,9";
	arr = str.split("\\.");//按照.拆分
	System.out.println(arr.length);//7
	System.out.println(Arrays.toString(arr));//[1,2,3,4,5, , , , , , ,6,7,8,9]
	str = "1,2,3,4,5,6,7,8,9......";
	arr = str.split("\\.");
	System.out.println(arr.length);//1
	System.out.println(Arrays.toString(arr));//[1,2,3,4,5,6,7,8,9]
	
	}
}
