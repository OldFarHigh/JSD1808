package day_03;

import java.util.Scanner;

public class LeapYear {//判断闰年

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入年份：");
		int year = scan.nextInt();
		//System.out.println("您输入的年份为："+year);
		/*三目运算符
		boolean flag = (year%4 == 0 && year%100 != 0) || year%400 == 0;
		String str1 ="您输入的"+year+"是闰年";
		String str2 ="您输入的"+year+"不是闰年";
		String str = flag ? str1:str2;
		System.out.println(str);
		*/
		if((year%4==0 && year%100!=0) || (year%400==0)){
			System.out.println("您输入的年份"+year+"是闰年");
		}else {
			System.out.println("您输入的年份\""+year+"\"不是闰年");
		}
		scan.close();
	}

}
