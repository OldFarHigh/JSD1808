package day_06;
import java.util.Arrays;
import java.util.Scanner;

public class MaxOfArray {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("请输入您希望的整数：（将输出范围内随机数的最大值）");
		int a = scan.nextInt();
		int[] arr =new int[a];
		int max=0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*100);
			System.out.print(arr[i]+"\t");
			if (arr[i]>max) {
				max = arr[i];
			}
		}
		scan.close();
		System.out.println("\n"+"max="+max);
		//数组的扩容
		arr  = Arrays.copyOf(arr, arr.length+1);
		//最大值赋给max
		arr[arr.length-1] = max;
		//新数组的赋值
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
			
		}
		System.out.println();
		//数组的复制
		/*
		int[] a0={10,20,30,40,50};
		int[] a1=new int[6];
		System.arraycopy(a0, 0, a1, 1, 4);
		for (int i = 0; i < a1.length; i++) {
			System.out.print(a1[i]+"\t");
		}
		*/
		//数组排序
		/*
		int[] arr=new int[] {10,30,40,50};
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if (arr[j]>arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1]=arr[j] ;
					arr[j]= temp;
				}
			}
		
		}
		System.out.println("排序后：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		*/
/*
 * 练习：
 *	1)完成经典案例：------		
 */
		
		
	}

}
