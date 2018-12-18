package day_04;

import java.util.Scanner;

public class Guessing {

	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		 //Math.random()---取值范围0.0～0.99999999999
		 int number = (int)(Math.random()*1000+1);//1-1000以内的数
		 System.out.println(number);//作弊
		 /*
		 System.out.println("请输入您猜想的数字：");
		 int guess = scan.nextInt();
		 */
		 /*不带大小提示的
		 while(guess!=number) {
			 System.out.println("您猜错了，请您继续。");
			 guess = scan.nextInt();
		 }
		 System.out.println("恭喜您猜对了哦！");
		 */
		 /*带大小提示的。
		 while(guess!=number) {
			 if(guess==0){
				 break;
			 }
			 if(guess>number) {
				 System.out.println("您输入的数字偏大！");
			 }else {
				 System.out.println("您输入的数字偏小！");
			 }
			 System.out.println("请您继续猜吧！");
			 guess = scan.nextInt();
		 }
		 if(guess==number) {
			 System.out.println("恭喜您猜对了！");
		 }else {
			 System.out.println("欢迎您下次光临!");
		 }
		 */
		 /*
		 int guess;
		 do {
			 System.out.println("请输入您猜想的数字：");
			 guess = scan.nextInt();
			 if(guess==0){
				 break;
			 }
			 if(guess>number) {
				 System.out.println("您输入的数字偏大！");
			 }else if(guess<number){
				 System.out.println("您输入的数字偏小！");
			 }
			 }while(guess!=number);
		 if(guess==number) {
			 System.out.println("恭喜您猜对了！");
		 }else {
			 System.out.println("欢迎您下次光临!");
		 }
		 */
		 int guess;
		 do {
			 System.out.println("请输入您猜的数：");
			 guess = scan.nextInt();
			 if(guess==0) {
				 break;
			 }
			 if(guess>number) {
				 System.out.println("您猜的数偏大！");
			 }else if(guess<number) {
				 System.out.println("您猜的数偏小！");
			 }
		 }while(guess!=number);
		 if(guess==number) {
			 System.out.println("恭喜您猜对了!");
		 }else {
			 System.out.println("欢迎您下次光临！");
		 }
		 scan.close();
	}
}
