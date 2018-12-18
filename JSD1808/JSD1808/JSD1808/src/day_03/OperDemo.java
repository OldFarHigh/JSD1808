package day_03;

import java.util.Scanner;

public class OperDemo {

	public static void main(String[] args) {
	/*
		System.out.println(5%3);//2
		System.out.println(9%3);//0
		System.out.println(3%6);//3
		int a = 5;
		a++;
		System.out.println(a);//6
		int b = 5;
		b++;
		System.out.println(b);//6
		int c = 5;
		int d = c++;
		System.out.println(c);//6
		System.out.println(d);//5
		int e = 5;
		int f = ++e;
		System.out.println(e);//6
		System.out.println(f);//6
		int g,h;
		g = h = 5;
		System.out.println(("g--=")+(g--));//"g--"=5
		System.out.println("G="+g);//"g"=4
		System.out.println("--h="+(--h));//"--h"=4
		System.out.println(h);//"h"=4
		int i ;
		i = 100;
		System.out.printlnd();
	*/
	/*
		int a = 10 , b = 100 ,c = 10;
		System.out.println(a>b && b>c );//false
		System.out.println(a>b || b>c);//true
		System.out.println(a>=b && b>=c);//false
		System.out.println(a>=b|| b>=c);//true
		System.out.println(a>b && b<c );//false
		System.out.println(a>b || b<c);//false
		System.out.println(a>=b && b<=c);//false
		System.out.println(a>=b|| b<=c);//false
		System.out.println(a<b && b<c);//false
		System.out.println(a<b || b<c);//false
		System.out.println(a<=b && b<=c);//fasle
		System.out.println(a<=b || b<=c);//true
		System.out.println(a<b && b>c);//true
		System.out.println(a<b || b>c);//true
		System.out.println(a<=b && b>=c);//true
		System.out.println(a<=b || b>=c);//true
		System.out.println(a<=b && b<=c);//false
		System.out.println(a<=b || b<=c);//true
		boolean n = a<b || c++ >10;
		System.out.println(n);//false 
		System.out.println(c);//10，发生短路了
	*/
		/*
		//面试题：如下代码哪句错误？为什么错？怎么改？
		short s = 5;
 		s += 5; //编译正确，自带强制转换
		s = s+5;//编译错误
		*/
		/*
		int a = 5;
		a += 20;
		System.out.println("a += "+a);//a += 25
		a *= 4;
		System.out.println("a *= "+a);//a *= 100
		a /= 10;
		System.out.println("a /= "+a);//a /=10
		int age =22;
		System.out.println("age="+age);//age=20
		System.out.println("我的年龄是:"+age);//我的年龄是22
		System.out.println("我今年"+age+"岁了");//我今年22岁了
		System.out.println(10+20+""+30);//"3030"
		System.out.println(""+10+20+30);//"102030"
		System.out.println(10+20+30+"");//"60"
		*/
		/*
		int b=8;
		int c=5;
		int max = b>c?b:c;
		System.out.println(max);
		*/
		/*
		int b=8;
		int c=5;
		int max; 
		System.out.println("MAX的值为："+(b >c?b:c));
		*/
		/*
		 第三题：
		Scanner numScanner =  new Scanner(System.in);
		//Scanner bScanner =  new Scanner(System.in);
		System.out.println("请依次输入两个整数：a,b(以空格隔开)");
		int a = numScanner.nextInt();
		int b = numScanner.nextInt();
		//int b = bScanner.nextInt();
		int max = a>b?a:b;
		System.out.println("最大的整数为："+max);
		*/
		/*
		 * 第四题
		 */ 
	Scanner numScanner = new Scanner(System.in);
	System.out.println("请依次输入三个整数：a,b,c(以空格隔开)");
	int a = numScanner.nextInt();
	int b = numScanner.nextInt();
	int c = numScanner.nextInt();
	System.out.println("您输入的是：");
	System.out.println("a="+a+",b="+b+",c="+c);
	int max=0;
 	if(a>b) { //需要将a与b的值进行交换
		max = a ;//a的值赋给max
		a = b;//b的值赋给a
		b = max;// 最大值为b
	}else {
		max = b;//b为最大时不需要改变
	}
	if(a>c) {
		max = a;//将最大值a赋给max；
		a = c ;//将小的c值赋给a；
		c = max;//将最大值max赋给c
	}else {
		max = c;//c为最大值时不需要改变
	}
	if(b>c) { 
		max = b; //
		b=c;    //先将小的值c赋给b 
		c=max;     //将最大值赋给c
	  }else {
		 max = c;//c为最大值时不需要改变
	  }
	System.out.println("升序排列后，结果为：");
	System.out.println("a="+a+",b="+b+",c="+max);
	numScanner.close();
	}
	
}
