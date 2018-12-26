package test;
/**
 * 7进制解析
 * @author OldFarHigh
 *
 */
public class DemoTest03 {
	/*
	 * 解析7进制，如：7进制“123”，解析为：66
	 * 注意：不能使用JavaAPI解析。
	 */
	public static void main(String[] args) {
		
		String str = "123";
		int n = parseInt(str,7);
		System.out.println(n);
		
		//str = "123";
		//int n = Integer.parseInt(str,7);
		//System.out.println(n);
		
	}

	static int parseInt(String str,int base){
		
		int weight = 1;//权
		int sum =0;//存放解析结果
		for (int i= str.length()-1;i>=0;i--) {
			char c = str.charAt(i);
			int n = c- '0';
			sum += n*weight;
			weight *=base;
		}
		return sum;
	}
}
