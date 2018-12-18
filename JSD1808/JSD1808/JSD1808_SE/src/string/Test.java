package string;

public class Test {

	public static void main(String[] args) {
		String u1 = "www.baidu.com";
		String u2 = "http://www.tedu.cn";
		String u3 = "http://www.sina.com.cn";
		String s1 = getHostName(u1);
		String s2 = getHostName(u2);
		String s3 = getHostName(u3);
		System.out.println(s1);//baidu
		System.out.println(s2);//tedu
		System.out.println(s3);//sina

	}
	public static String getHostName(String url) {
	//	String str = new String(url);
		 int index1  =url.indexOf(".");//查找第一个出现.的位置
		// int index2  =url.lastIndexOf(".");//查找最后一个出现.的位置
		 //int index3  =url.indexOf(".com.cn");//查找出现给定字符的位置
		 int end = url.indexOf(".",index1+1);
		 /*
		 String sub = null;//给定存储查找字符的字符串
		 if(index3 == -1) {//如果字符串中不存在.com.cn则判断.出现的位置
			 sub = url.substring(index1+1, index2);//index+1 从.的位置后后一位开始
		 }else {				//如果字符串中存在.com.cn则判断.com.cn出现的位置
			 sub = url.substring(index1+1,index3);//含头不含尾
		 }
		 */
		 return url.substring(index1+1,end);
	}

}
