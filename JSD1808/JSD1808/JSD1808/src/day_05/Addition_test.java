package day_05;

import java.util.Scanner;

public class Addition_test {

	public static void main(String[] args) {
		System.out.println("请开始你的表演：");
		Scanner scan = new Scanner(System.in);
		int score = 0;//定义得分
		//System.out.println(a);
		//int b =(int)(Math.random()*10+1);//10		
		for(int i=1;i<=10;i++) {
			//1.出题 //2.答题 //3.判题
			int a=(int)(Math.random()*100);//生成99以内的随机数
			int b=(int)(Math.random()*100);//同上
//			int result = a+b;//存和
			
			System.out.println("("+i+")"+a+"+"+b+"=?");//1.出题
			int answer = scan.nextInt();				//2.答题
			if(answer == -1) {						//-1退出
				break;
			}
			if(answer ==a+b) {						//2.判断
				System.out.println("对");
				score += 10;
			}else {
				System.out.println("错");
			}
		}
		System.out.println("得分为："+score);
		scan.close();
	}
		}
		

