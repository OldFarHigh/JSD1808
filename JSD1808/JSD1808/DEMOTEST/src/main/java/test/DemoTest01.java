package test;

import java.util.Arrays;
/**
 * 统计一个英文大写字母组成的字符串中每个字母的数量
 * @author OldFarHigh
 * 'A' 65-65 counter[0]++
 * 'B' 66-65 counter[1]++
 * 'C' 67-65 counter[2]++
 * 'D' 68-65 counter[3]++
 * 'E' 69-65 counter[4]++
 * 'F' 70-65 counter[5]++
 * ... ...
 */
public class DemoTest01 {
	/*
	 * 统计一个整数字符串中每个字符的数量
	 */
	public static void main(String[] args) {
		//要统计的字符串
		String str = "ASDJIKHLKHLKHFLKHLKSHLIGFHSLIHFOYHLIKGHIKSHGKH";
		//存储统计结果的数组，一个字母对应一个位置
		int[] counter = new int[26];
		//遍历字符串
		for (int i = 0; i < str.length(); i++) {
			//字符串中每个位置的字符
			char c = str.charAt(i);
			//字符减去ASCII中A对应的数字，对应存出结果的数组的位置
			counter[c-'A']++;
		}
		System.out.println(Arrays.toString(counter));
	}
}