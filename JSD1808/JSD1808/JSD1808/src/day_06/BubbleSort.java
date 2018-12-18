package day_06;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = new int [] {15, 67, 26, 43, 61, 25, 84, 80, 34, 70};
		//数组赋值
		
		/*
		 for (int i = 0; i < arr.length; i++) {
			arr[i]=(int)(Math.random()*100);//生成0-99的随机数
			System.out.print(arr[i]+"\t");
		}
		*/
		//数组排序
		 for (int i = 0; i <3; i++) {//轮的比较
			for (int j = 0; j < arr.length-1-i; j++) {//次的比较
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			} 
		 }
			//输出数组，对数组赋值
			System.out.println("排序后");
		for (int i = 0; i <arr.length; i++) {
			System.out.print(arr[i]+"\t");
		
		}

	}

}
