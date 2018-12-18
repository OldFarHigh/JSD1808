package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 转换流:唯一链接在字节流上的字符流
 * InputStreamReader 和 OutputStreamWriter之所以称为“转换流”，
 * 是因为其他高级字符流都只能链接在其他的字符流上，而不能直接链接在字节流上
 * 而转换流是唯一可以链接在字节流上的字符流，而它们本身是字符流，
 * 可以供其他字符流链接，从而起到承上启下的作用，对此我们在使用字符流操作时
 * 它们在流链接中是用衔接字节流与字符流的桥梁。负责将字符与字节流之间相互转换。
 * @author OldFarHigh
 *
 */

public class Demo2_InputStreamReaderDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 从osw.txt文件中读取文本数据
		 */
		FileInputStream fis = new FileInputStream("osw.txt");
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
		 
	
		/*
		 * int read()
		 * 字符流定义的该方法是读取一个字符，实际从数据源读取了几个字节取决于字符集
		 * 但是当读取到该字符后在java内部都是以unicode编码保存，就变为固定的2字节的char类型了。
		 */
//		int d = -1;//初始值		
//		while((d= isr.read()) != -1) {//读取字符，并用读取的长度判断是否到末尾
//			char c = (char)d;//转换字符
//			System.out.print(c);			
//		}
		char []  data = new char[100];
		int len = isr.read(data);
		String str = new String(data,0,len);
		System.out.println(str);
		
		isr.close();
	}
}
