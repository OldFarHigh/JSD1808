package io;


import java.io.IOException;
import java.io.PrintWriter;

/**
 * java.io.PrintWriter
 * 具有自动行刷新的缓冲字符输出流
 * 注：java.io.BufferedWriter是缓冲字符输出流，PW总是会在内部链接它来完成缓冲工作，
 * 而PW在其基础之上还支持自动的行刷新操作，所以更为常用
 * 
 * 缓冲字符输出流除了写出字符效率高之外，还可以按行写出字符串（写出一
 * 个字符串后会自动添加换行符）
 * @author OldFarHigh
 *
 */
public class Demo3_PrintWriterDemo {
	public static void main(String[] args) throws IOException {
	/*
	 * pw提供了直接写文件的构造方法
	 * PrintWriter(String path)
	 * PrintWriter(File file)
	 * 
	 * 也支持重载构造方法，第二个参数为字符集，
	 * 这样就可以按照指定的字符集将字符写入文件
	 * 	
	 */
	//向pw.txt文件中写字符串
		PrintWriter  pw = new PrintWriter("pw.txt","UTF-8");
		
		pw.println("如果那两个字没有颤抖！");
		pw.println("我不会发现我难受！");
		pw.println("如果对于明天没有要求！");
		pw.println("牵牵手就像旅游！");
		pw.println("成千上万个门口");
		pw.println("总有一个人要先走");
		
		System.out.println("写出完毕！");
		pw.close();
	}
}
