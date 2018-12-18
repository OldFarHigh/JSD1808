package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流完成复制操作
 * @author OldFarHigh
 *
 */
public class Demo03_CopyDemo {
	public static void main(String[] args) throws IOException  {
		/*
		 * 1、创建文件输入流读取原文件
		 * 2、创建文件输出流向复制文件中写
		 * 3、循环从源文件读取一组字节，然后写入到复制文件中完成复制工作
		 * 4、使用后将流关闭
		 * 
		 * 可参考使用RAF复制文件的操作。
		 * 
		 * 
		 */
		FileInputStream  fis = new FileInputStream("fos.txt");
		FileOutputStream fos = new FileOutputStream("fos_cp.txt");
		long start = System.currentTimeMillis();//记时开始
		byte[] data = new byte[100];//创建指定容量的容器
		int d = -1;
		//String str = new String(data,0,len,"UTF-8");
		while((d = fis.read(data))!=-1) {//装载数据，并返回容器的使用容量
			fos.write(data,0,d);//按照使用容量拆卸数据	
		}
		long end = System.currentTimeMillis();//记时结束
		System.out.println("复制完成！耗时："+(end-start)+"ms");
		fis.close();
		fos.close();
		
	}
}
