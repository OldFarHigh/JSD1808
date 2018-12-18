package day_06;

import java.util.Arrays;

public class SmallOfArray {

	public static void main(String[] args) {
		int[] arr = new int[10];//创建一个数组
		for (int i = 0; i < arr.length; i++) {
			arr[i] =(int)(Math.random()*100);	
			
		}
		//定义最小值
		int min=arr[0];
		//输出数组的值
		System.out.print("数组中的数据为:"+Arrays.toString(arr));
		for (int i = 1; i < arr.length; i++) {
//			for (int j = 0; j < arr.length-1; j++) {
				if(min>arr[i]) {
					 min = arr[i];}
		}
		System.out.println("\n"+"最小值为："+min);//输出最小值
		//新数组扩容
		arr =Arrays.copyOf(arr, arr.length+1);
		//将最小值添加到数组的最后
		arr[arr.length-1]=min;
		//输出新数组的值
		System.out.println("新数组中的数据为："+Arrays.toString(arr));
		
		

	}

}
