package day_07;

import java.util.Scanner;

//1、主方法
//2、随机生成的字符数组
//3、接收用户输入的字符数组
//4、进行对比，记录结果
public class GuessingGame {
	//主方法
	public static void main(String[] args) {
		/*
		char[] chs =  {'A','B','C','D','E'};
		char[] input = {'M','D','C','B','Q'};
		int[] result = check(chs,input);
		System.out.println(result[0]+","+result[1]);
		*/
		/*
		char[] chs =generator();
		System.out.println(chs);
		*/
		Scanner scan = new Scanner(System.in);//接收用户输入的数据
		char[] chr = generator();//调用方法生成新的随机数组
		System.out.println(chr);//输出生成的随机方法的数组的值。作弊
		int count =0;
		while(true) {//生成死循环，直到用户猜对为止
			System.out.println("请开始您的表演！");
			String str = scan.next().toUpperCase();//接收用户输入的字符串
			char[] input = str.toCharArray();//将用户输入的字符串数据转换为字符数组
			if(str.equals("EXIT")) {
				System.out.println("再见，拜拜！");
				break;
			}
			int[] result =check(chr,input);//对比随机数组和用户输入的数组
			if(result[1]==chr.length) {//如果两个数组的对比结果是字符相等，位置也相等，则可判断
				int score = 100*chr.length-count*10;//计算得分
				System.out.println("恭喜您猜对了！得分为："+score);
				break;
			}else {//如果算错了，继续进行循环
				count++;
				System.out.println("您猜错了，本次结果为：字符猜对个数为："+result[0]+"位置猜对个数为"+result[1]);
			}
		}
		scan.close();
		
	}
	
	
	//随机生成字符数组
	public static char[] generator() {
		char[] chs =new char[5];//定义随机数组
		char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                'W', 'X', 'Y', 'Z' };//随机数组内所有的内容
		boolean[] flags = new boolean[letters.length];//设置开关，将被使用过的数变为被使用的状态，避免重复
		for (int i = 0; i < chs.length; i++) {
			int index ;//定义一个下标，对应数组内的数
			do{
				index = (int)(Math.random()*letters.length);//随机生成index下标，在0-25范围内下标代表字母
			}while(flags[index]==true);
			chs[i] = letters[index];//基与index下标赋给chs数组初值
			flags[index]=true;//将被使用过的下标，变为使用状态true
		/*
		 * i=0，index=0 ,				chs[0]='A',  			flags[0]  =true;
		 * i=1, index=25,				chs[1]='Z',				flags[25] =true;
		 * i=2,	index=0/25/0/25/25/4	,	chs[2]='D',				flags[4]  =true;   ,
		 * i=3,	index=0/4/0/25/25/3 ,	chs[3]='C',				flags[3]  =true;
		 * i=4, index=0/4/25/3/4/5 ,		chs[4]='E',				flags[5]  =true;
		 */
		}
		return chs;
	}
	//对比：随机数组chs和用户输入的数组input
	public static int[] check(char[] chs,char[] input) { //定义check方法
		int[] result =new int[2];//result[0]为字符对的，result[1]为位置对的
		for (int i = 0; i < chs.length; i++) {//随机数组的比较
			for (int j = 0; j < input.length; j++) {//用户输入数组的比较
				if(chs[i] == input[j]) {//字符对
					result[0] ++;//字符对，结果加1
					if(i==j) {//数组对
						result[1]++;//字符对且位置对，结果加1
					}
					break;//如果字符相等，就跳出当次循环，后面的不再比较
					
				}
			}
		}
		return result;
	}
	
	

}
