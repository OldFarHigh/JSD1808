package day_02;

public class DataTypeDemo {

	public static void main(String[] args) {
	/*
	int a = 250;
	//int b = 10000000000;
	System.out.println(5/2);//2
	System.out.println(2/5);//0
	System.out.println(2.0/5);//0.4
	int c = 2147483647;
	c = c+1;
	System.out.println("c=c+1="+c);//-2147483648
	c = c+1;
	System.out.println("c=c+2="+c);//-2147483647
	long d = 10000000000L;
	long e = 1000000000*2*10L;
	System.out.println("e="+e);//e=20000000000
	long f = 1000000000*3*10L;
	System.out.println("f="+f);//f=-12949672960
	long g = 100000000L*3*10;
	System.out.println("g="+g);//g=3000000000
	long h = System.currentTimeMillis();
	System.out.println("h="+h);
	double pi = 3.14;
	double i,j;
	i=6.0;
	j=4.9;
	System.out.println(i-j);//1.0999999999999996
	*/ 
	
		
		
		
		
		
		
		
		
	/*
		boolean b1 = true;
		boolean b2 = false;
		//boolean b3 = 3.14;//编译错误
		char c1 = '男';
		System.out.println(c1);
		char c2 = 'm';
		System.out.println(c2);
		char c3 = '5';
		
		System.out.println(c3);
		char c4 = ' ';
		//char c5 = '';//编译错误，必须要有字符
		//char c6 = '男性'；//编译错误，只能有一个字符
		char c7 = 98;
		System.out.println(c7);
		char c8 = '\'';
		System.out.println(c8);
		char c9= 97;
		System.out.println(c9);
	*/
		
	
	
		
	int a =6;
	long b = a;
	int c;
	c = (int)b;
	System.out.println("c="+c);//6
	long d = 10000000000L;
	int e = (int)d;
	System.out.println("e="+e);//e=1410065408溢出
	
	double f = 56.989;
	int g = (int)f;
	System.out.println("g="+g);//56损失
	
	byte b1,b2;
	b1=6;
	b2=8;
	byte b3 = (byte)(b1+b2);     
	System.out.println(b3);
	
	System.out.println(2+2);//4
	System.out.println(2+'2');//52
	System.out.println('2'+'2');//100
	System.out.println('A'+a);//71
	System.out.println('A'+'A');//130
	
	
	}

}
