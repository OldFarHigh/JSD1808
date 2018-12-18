package day_07;

import java.util.Scanner;

//猜字符游戏
public class GuessingGame_01 {
	//主方法：
	public static void main(String[] args) {
		/*对比数组结果的单元测试
		char[] chs = new char[] {'A','C','D','B','E'};
		char[] input = new char[] {'C','B','D','F','E'};
		int[] result =  check(chs,input);
		System.out.println("字符对的个数为："+result[0]+",位置对的个数为："+result[1]);
		*/
		/*生成随机数组的单元测试
		char[] chr =generator();
		System.out.println(chr);
		*/
		Scanner scan = new Scanner(System.in);
		char[] chr = generator();
		System.out.println(chr);
		while(true) {
			System.out.println("请开始你的表演：");
			String  str = scan.next().toUpperCase();//接收用户输入的字符串
			char[] input = str.toCharArray();//将用户输入的字符串转化为字符数组
			if(str.equals("EXIT")) {
				System.out.println("请您下次再来！");
				break;	
			}
			int[] result = check(chr,input);
			int count = 0;
			if(result[1]==chr.length) {
				int score =100*chr.length-count*10;
				System.out.println("恭喜您全部正确,得分为："+score);
				break;
			}else {
				count++;
				System.out.println("字符值正确的有"+result[0]+"个，位置正确的有"+result[1]+"个");
			}
		}
		scan.close();
	}
	//生成随机数组
	public static char[] generator() {
		char[] chs =new char[5];
		char[] letter={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','D','U','V','W','X','Y','Z'}; 
		boolean[] flags = new boolean[letter.length];//定义一个数组开关，如果某个字符出现过，就对其进行true操作
		int index;//定义一个下标
		for (int i = 0; i < chs.length; i++) {
			do {
				index =(int)(Math.random()*letter.length);//生成下标，每个下标对应数组中的一个字符	
			}while(flags[index]==true);//当生成的字符已经出现过时，就会继续随机，直到随机的数未出现时结束
			chs[i]  = letter[index];//将生成的下标在letter数组中找到对应的字符，并赋给chs数组
			flags[index] = true;//将已经生成的字符进行标记操作，确保不会重复使用
		}
		return chs;
		
		
	}
	//对比：
	public static int[] check(char[] chs,char[] input) {
		int[] result =new int[2];//定义数组存储比较结果
		for (int i = 0; i < chs.length; i++) {//遍历随机生成的数组内的数据
			for (int j = 0; j < input.length; j++) {//遍历用户输入的数据
			if(chs[i]==input[j]) {//字符对比
				result[0]++;//记录+1
				if(i == j) {//位置对比
				result[1]++;//记录+1
			}break;//如果对比后有相同的就退出比较，避免重复
			}
			}
		}
		return result;
	}
	
}
