package day_04;

import java.util.Scanner;

public class GuessingDoWhileDemo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		int number =(int)(Math.random()*1000+1);//定义随机数1000-1
		System.out.println(number);//输出随机数
		int guess ;
		do
		{
		System.out.println("请输入您猜的数:");
		guess = scan.nextInt();
		if(guess==0) {
			break;
		}
		if(guess>number){
			System.out.println("大");
			
		}else if(guess<number){
			System.out.println("小");
			
		}
	}while(guess!=number);
		if(guess == number) {
			System.out.println("恭喜您猜对了!");
		}else {
			System.out.println("请继续努力！");
		}
		scan.close();
}
}
