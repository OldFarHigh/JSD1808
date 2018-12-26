package test;

import java.util.Arrays;

/**
 * 统计数字字符串中每个数字的个数
 * @author OldFarHigh
 *
 */
public class DemoTest02 {
	
	/*
	 * 统计一个数字字符串中每个数字的个数
	 */
	public static void main(String[] args) {
		String str = "01289512345678932136216854787891641324564346789745613543135765135465635456";
		int[] counter = new int[10]; 
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			counter[c-'0']++;
		}
		System.out.println(Arrays.toString(counter));
		System.out.println((int)'0');//48
		System.out.println((int)'A');//65
		System.out.println((int)'a');//97
	}
}
