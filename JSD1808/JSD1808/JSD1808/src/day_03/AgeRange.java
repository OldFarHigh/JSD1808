package day_03;

import java.util.Scanner;

public class AgeRange {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入您的年龄：");
		int age = scan.nextInt();
		System.out.println("您输入的年龄为："+age);
		System.out.println("您输入的年龄在18到50之间："+(age>=18 && age<=50));
		scan.close();
	}

}
