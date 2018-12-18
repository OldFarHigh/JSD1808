package io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 完成简易记事本工具
 * 输入文件名，对文件写操作，之后输入的每行字符串都按行写入到文件中
 * 当输入exit时程序退出
 * 
 * 注：创建PrintWriter使用流链接
 * @author OldFarHigh
 *
 */
public class Demo5_PrintWriterDemo3 {
	public static void main(String[] args) throws IOException {
		/*
		 * 
		 */
		System.out.println("请输入文件名：");
		Scanner sc  =new Scanner(System.in);
		String filename  = sc.nextLine();
		
		FileOutputStream fos = new  FileOutputStream(filename,true);//文件流，字节流
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");//转换流，字符流
		BufferedWriter bw = new BufferedWriter(osw);//缓冲流，字符流
		PrintWriter pw = new PrintWriter(bw,true);//输出流，可以自动行刷新，字符流
		/*
		 * 在流链接中创建PrintWriter时，支持第二个参数，
		 * 该参数为boolean类型，若为true，则表示创建的PrintWriter为自动行刷新模式
		 * 即：每当调用println方法写出一行字符串后就会自动进行flush操作
		 * 注：调用print方法是不会flush的
		 */
		System.out.println("请输入您要编辑的内容：");
		while(true) {
			String words = sc.nextLine();
			if("exit".equals(words)){
				System.out.println("退出！");
				break;
			}
				pw.println(words);
			//	pw.flush();
		}
		System.out.println("再见！");
		pw.close();
		sc.close();
	}
}
