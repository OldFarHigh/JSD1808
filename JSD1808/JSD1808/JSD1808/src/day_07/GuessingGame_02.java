package day_07;
	
	public class GuessingGame_02 {
	
		//生成随机数组chs
	public static  char[] generator() {
		char[] chs =new char[5];
		char[] letter= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','D','U','V','W','X','Y','Z'};
		int index;
		boolean[] flags = new boolean[letter.length];//制作一个查重的开关，默认所有都是false状态
		for (int i = 0; i < chs.length; i++) {
			do {
				 index=(int)(Math.random()*26);
			}while(flags[index]==true);
			chs[i] = letter[index];
			flags[index] = true;
		}
		return chs;
	}
	//进行数组的对比
	public static int[] check (char[ ] chs,char[ ] input) {
		int[] result = new int[2];
		return result;
	}
	//主方法
	public static void main(String[] args) {
		/*生成随机数组的
		char[] chs = generator();
		System.out.println(chs);
		*/
		}
	
}
