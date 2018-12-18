package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用缓冲流提高读写效率
 * 
 * 缓冲流是一对高级流，使用它们读写数据时，无论我们的读写方式是单字节读写还是块读写，它都能提高读写效率
 * 
 * 在流链接中搭配不同的高级流可以简化我们对数据的读写操作
 * 所谓流链接：使用高级流链接其他流，最终链接在低级流上
 * 这样的串联操作可以对低级流上的数据进行一系列加工。
 * @author OldFarHigh
 *
 */
public class Demo04_CopeDemo2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream ("fos.txt");
		BufferedInputStream bis = new BufferedInputStream(fis) ; 
		
		FileOutputStream fos = new FileOutputStream("fos_cp2.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		int d= -1;
		/*
		 * 缓冲流实际将读写转换为了块读写操作，从而保证读写的效率
		 */
		while((d = bis.read()) != -1) {
			bos.write(d);
		}
		System.out.println("复制完毕！");
		
		bis.close();
		bos.close();
	}
}
