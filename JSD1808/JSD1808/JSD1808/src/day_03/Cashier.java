package day_03;

import java.util.Scanner;

public class Cashier {//收银程序

	public static void main(String[] args) {
		Scanner priceScanner = new Scanner(System.in);
		System.out.println("请输入单价：");
		double price =priceScanner.nextDouble();
		Scanner numberScanner = new Scanner(System.in);
		System.out.println("请输入数量：");
		int number = numberScanner.nextInt();
		Scanner moneyScanner = new Scanner(System.in);
		System.out.println("请输入收款金额：");
		double money = moneyScanner.nextDouble();
		//System.out.println("应收款金额为："+(price*number));//计算总价为：单价*数量
		//System.out.println("找零为："+(money-price*number));
		double totalPrice = price*number;
		if(totalPrice >500) {
			totalPrice *=0.8;
		}
		double change = money - totalPrice;
		if(change>=0) {
			System.out.println("应收款金额为："+totalPrice+"，应找零为："+change);
			System.out.println("ERROR!您的钱不太够哦！还需要"+(totalPrice - money));
		}
		priceScanner.close();
		numberScanner.close();
		moneyScanner.close();
		
		/*
		Scanner numScanner = new Scanner(System.in);
		System.out.println("请输入您要验证的数:");
		int num = numScanner.nextInt();
		if(num%2==0) {
			System.out.println("您输入的这个数是偶数");
		}else {
		System.out.println("您输入的这个数是奇数");
		}
		*/
	}

}
