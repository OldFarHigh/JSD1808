package day_05;
//数组演示
public class ArrayDemo {

	public static void main(String[] args) {
		/*生成一个10为数的随机数组
		int[] arr = new int [10];
		for(int i=0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*10);
			System.out.print(arr[i]);
			}
		*/
//		int[] arr1 = new int[10];
//		int[] arra = new int[100];
//		int[] arrb = new int[1000];
//		int[] arr2 = new int[] {2,5,8,9};
//		int[] arrc = new int[] {1,2,3,4};
//		int[] arrd = new int[] {3,4,5,6};
//		int[] arr3 = new int[4];
//		arr3 = new int[]{2,5,8,9};
//		int[] arre = new int[5];
//		arre = new int[]{3,4,5,6};
		int[] arr = new int[3];
		arr[0] = 100;
		arr[1] = 200;
		arr[2] = 300;
		//arr[3] = 400;//运行错误，角标越界！
		System.out.println(arr.length);
		System.out.println(arr[arr.length-1]);
		
		
	}

}
