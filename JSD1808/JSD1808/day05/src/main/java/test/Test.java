package test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test {
	public static void main(String[] args) throws UnsupportedEncodingException  {
		String str= "范传奇";
		String str1 = URLEncoder.encode(str,"utf-8");
		System.out.println("str1:"+str1);
		String str2 = URLDecoder.decode(str1,"UTF-8");
		System.out.println("str2:"+str2);
	}
}
