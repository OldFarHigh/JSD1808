package day_04;

import java.util.Scanner;

public class TestDemo_01 {

	public static void main(String[] args) {
		Scanner salaryScanner = new Scanner(System.in);
		System.out.println("请输入您的工资税前金额（￥）：");
		double salary = salaryScanner.nextDouble();
		double tax = 0.0;
		double taxIncome = salary - 3500;
		if(taxIncome<=0) {
			tax=0.0;
		}else if(taxIncome<=1500) {
			tax=taxIncome*0.03;
		}else if(taxIncome<=4500) {
			tax=taxIncome*0.1-105;
		}else if(taxIncome<=9000) {
			tax=taxIncome*0.2-555;
		}else if(taxIncome<=35000) {
			tax=taxIncome*0.25-1005;
		}else if(taxIncome<=55000) {
			tax=taxIncome*0.3-2755;
		}else if(taxIncome<=80000) {
			tax=taxIncome*0.35-5505;
		}else  {
			tax=taxIncome*0.45-13505;
		}
		System.out.println("你应该缴纳的个人所得税是："+tax);	
		salaryScanner.close();
	}
	
	
}
