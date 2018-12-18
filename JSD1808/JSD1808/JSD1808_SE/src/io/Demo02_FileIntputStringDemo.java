package io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 文件流读取数据
 * @author OldFarHigh
 *
 */
public class Demo02_FileIntputStringDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis =  new FileInputStream("fos.txt");
		
		byte[] data = new  byte[1000];//在文件流中不提供length获取文件的数据长度，可以设置一个偏大的数来接收
		int len = fis.read(data);//获取读取到数据的返回值
		
		String str = new String(data,0,len,"UTF-8");//String的另一个构造方法，指定数据，数据的指定位置开始，指定位置结束，字符集
		System.out.println(str); 
		
		fis.close();
		
		
	}
}
