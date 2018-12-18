package day_06;

import java.util.Arrays;

public class GenerateArray_Test {
	//定义有参数的有返回值的方法
	public static int[] generatorArray(int length,int max) {
		int[]arr =new int[length];
		//随机生成0-99以内的数字
		for (int i = 0; i < length; i++) {
			arr[i] =(int)(Math.random()*max);
		}
		return arr;
	}
	public static void main(String[] args) {
		//调用generatorArray的方法
		int[] arr=generatorArray(6,100);
		System.out.println("生成的数组为："+Arrays.toString(arr));
		

	}

}
