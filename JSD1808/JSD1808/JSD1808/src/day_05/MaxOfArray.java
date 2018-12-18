package day_05;

public class MaxOfArray {

	public static void main(String[] args) {
		int[] arr = new int[10];//声明数组
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*100);//遍历整个数组，
			System.out.print(arr[i]+"\t");//输出每个元素的值
		}
		System.out.print("\n");
		int max = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]> max) {
				max = arr[i];
			}
		}
		System.out.println("最大值："+max);
	}

}
