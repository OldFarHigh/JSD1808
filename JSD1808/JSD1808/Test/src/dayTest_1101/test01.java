package dayTest_1101;

public class test01 {
	public static void main(String[] args) {
		String str  = "ab"+"c";
		String str1 = "abc";
		System.out.println(str==str1+":"+str.equals(str1));
		System.out.println(str==str1);
		System.out.println(str.equals(str1));
	}
}
