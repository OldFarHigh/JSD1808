package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * 使用缓冲输出流写出字符串时的缓冲区问题
 * @author OldFarHigh
 *
 */
public class Demo05_BufferedOutputStream_flush {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("bos.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		bos.write("色即是空，空即是色！".getBytes("UTF-8"));
		/*
		 * void flush()
		 * 缓冲流的flush方法会强制将缓冲区中已经缓存的数据一次性写出
		 * 频繁调用flush会降低写效率，但是可以保证写出数据的即时性，结合实际需求使用该方法
		 */
		bos.flush();
		System.out.println("写出完毕！");
		/*
		 * 缓冲流的close发明画法中会自动调用一次flush
		 */
		bos.close();
	}
}
