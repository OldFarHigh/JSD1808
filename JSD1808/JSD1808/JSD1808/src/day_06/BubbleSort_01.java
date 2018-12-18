package day_06;

import java.util.Arrays;

//冒泡排序的原理
public class BubbleSort_01 {

	public static void main(String[] args) {
		//声明一个包含10个元素的数组
		int[] arr = new int[10];
		//为数组赋初值
		for (int i = 0; i < arr.length; i++) {
			arr[i] =(int)(Math.random()*100);
		}
		System.out.println("生成的新数组为："+Arrays.toString(arr));
		//对新数组进行排序
		//轮数比较的次数
		for (int i = 0; i < arr.length; i++) {
		//次数比较的次数
			for (int j = 0; j < arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]) {
					int t=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=t;
				}
			}
		}
		System.out.println("排序后的数组为："+Arrays.toString(arr));

	}

}
