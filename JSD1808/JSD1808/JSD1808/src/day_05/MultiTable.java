package day_05;
//九九乘法表
public class MultiTable {

	public static void main(String[] args) {
		//2*9=18
		/*
		int num=9;
		for(int i=1;i<=num;i++) {
			System.out.print(i+"*"+num+"="+i*num+"\t");
		}
		*/
		
		for(int i=1;i<=9;i++) {
			for(int num=1;num<=i;num++) {
				System.out.print(num+"*"+i+"="+i*num+"\t");
		}
		System.out.println();//换行

	}
		/*
		 * i=1
		 * num=1;1*1=1;
		 * num=2;false
		 * 换行
		 * 
		 * i=2
		 * num=1;1*2=1
		 * num=2;2*2=4;
		 * num=3;false
		 * 换行
		 * 
		 * i = 3
		 * num=1;1*3=3
		 * num=2;2*3=6
		 * num=3;3*3=9	
		 * num=4;false
		 * 换行
		 */
}
}
