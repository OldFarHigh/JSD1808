package day_06;

import java.util.Arrays;

//冒泡排序的第三次演示
public class BubbleSort_02 {

	public static void main(String[] args) {
		//创建存储数据的数组
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			//为数组中传入数据
			arr[i]=(int)(Math.random()*100);
		}
		//输出原数组的值
		System.out.println("原数组为："+Arrays.toString(arr));
		//对原数组进行冒泡排序
		//原数组应该比较的轮的次数
		for (int i = 0; i < arr.length; i++) {
			//原数组内数据每一轮比较的次数
			for (int j = 0; j < arr.length-1-i; j++) {
			 if(arr[j]>arr[j+1]) {
				 int t = arr[j];
				 arr[j] = arr[j+1];
				 arr[j+1] =t;
			 }
			}	
		}
		System.out.println("冒泡排序后数组为："+Arrays.toString(arr));
				

	}

}
