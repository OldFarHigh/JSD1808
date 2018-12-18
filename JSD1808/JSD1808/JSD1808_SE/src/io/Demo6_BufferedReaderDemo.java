package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 缓冲字符输入流
 * java.io.BufferedReader
 * 特点：可以按行读取字符串
 * @author OldFarHigh
 *
 */
public class Demo6_BufferedReaderDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 将当前源代码读取出来并输出到控制台
		 */
		FileInputStream fis = new FileInputStream("src/io/Demo5_PrintWriterDemo3.java");
		InputStreamReader isr = new  InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		/*
		 * BR提供的方法
		 * String readLine()
		 * 连续读取若干字符，直到读取了换行符位置为止，然后将读取的字符以字符串形式返回
		 * 注意：返回的字符串中不含有最后的换行符，当返回值为null时，表示流读取到了末尾。
		 */
		String str =null;
		while((str= br.readLine()) != null) {
			System.out.println(str);
		}
		br.close();
	}
}
