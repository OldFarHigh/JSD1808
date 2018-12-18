package day_04;

import java.util.Scanner;

public class GuessingWhileDemo {

	public static void main(String[] args) {
		
			Scanner Scan = new Scanner(System.in);
			int number =(int)(Math.random()*10001+1);
			 System.out.println(number);
			 System.out.println("请输入您猜的数：");
			 int guess = Scan.nextInt() ;
			 while(guess != number) {
				 if(guess == 0) {
					break;
				 }
				 if(guess>number){
					 System.out.println("您输入的数偏大！");
				 }else{
					 System.out.println("您输入的数偏小");
				 	}
				 System.out.println("请您继续猜吧");
				 guess = Scan.nextInt();
			 }
			 if(guess == number) {
				 System.out.println("恭喜您猜对了！");
			 }else {
				 System.out.println("请您下次努力！");
			 }
			 Scan.close();
			 
		
	}
}
		

