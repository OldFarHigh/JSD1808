package day_06;

import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("GuessingGame>欢迎尝试猜字符游戏！");
		int level = 5;
		do{
			System.out.print("GuessingGame>请输入游戏级别（5、7、9）？");
			 level = scan.nextInt();
		}while(level!=5&&level!=7&&level!=9	); 
		scan.close();	
			
		

	}

}
