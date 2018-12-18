package day_05;

public class ForDemo {

	public static void main(String[] args) {
		int sum = 0;
		for(int i=1000;i>=0;i--) {
			sum = sum +i;
			
		}
		System.out.println("sum="+sum);
		/*
		 * 	      sum=0;
		 * i=1000 sum=1000;
		 * i=999  sum=1000+999;
		 * i=998  sum=1000+999+998;
		 * i=...  sum=1000+999+998+...;
		 */
		int n = 1;
		int jia = 0;
		while(n<=100) {
			jia +=n ;
			n++;
		}
		System.out.println("jia="+jia);
}
}
