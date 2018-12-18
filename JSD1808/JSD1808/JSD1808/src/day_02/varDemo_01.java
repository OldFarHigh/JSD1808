package day_02;

import java.util.Scanner;



public class varDemo_01 {
			public static void main(String[] args) {
				/*
				int a;
				int b,c;
				int d = 36;
				int e;
				e = 36;
				int f=5;
				int g = f+20;
				System.out.println(g);
				f=f+20;
				System.out.println(f);
				//int h =3.14;
				//System.out.println(i);
				double i;
				i=1.0/3.0;
				System.out.println(i);
				//System.out.println(i);
				//int A245456;
				//int $3.141592653;
				//int _3.141592653;
				//int 3.141592653;
				*/
				System.out.println(5+6+""+5+6);//运算符优先级
				Scanner aScanner =  new Scanner(System.in);
				//Scanner bScanner =  new Scanner(System.in);
				System.out.println("请依次输入两个整数：a,b(以空格隔开)");
				int a = aScanner.nextInt();
				int b = aScanner.nextInt();
				//int b = bScanner.nextInt();
				int max = a>b?a:b;
				System.out.println("最大的整数为："+max);
				aScanner.close();
			}
}
