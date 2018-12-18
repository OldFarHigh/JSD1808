package io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 在流链接中使用PrinterWriter
 * @author OldFarHigh
 *
 */
public class Demo4_PrintWriterDemo2 {
	public static void main(String[] args) throws IOException{
		FileOutputStream fos = new  FileOutputStream("pw.txt",true);//文件流，字节流
		OutputStreamWriter osw = new OutputStreamWriter(fos);//转换流，字符流
		BufferedWriter bw = new BufferedWriter(osw);//缓冲流，字符流
		PrintWriter pw = new PrintWriter(bw);//输出流，字符流
		
		pw.println("鸳鸯双栖蝶双飞");
		System.out.println("写出完毕！");
		
		pw.close();
		
	}
}
