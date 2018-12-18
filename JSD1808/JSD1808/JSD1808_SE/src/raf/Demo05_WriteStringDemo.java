package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 使用RAF读写字符串
 * @author OldFarHigh
 *
 */
public class Demo05_WriteStringDemo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf =  new RandomAccessFile("raf.txt","rw");
		String str = "我可以接受你的所有，所有小脾气。";
		/*
		 * String 提供了将字符串转换为字节的方法
		 * byte[] getBytes():按照系统默认字符集转换
		 * byte[] getBytes(String csn):按照指定的字符集将字符串转换为字节，常见的字符集
		 * GBK:国标编码，英文1字节，中文2字节
		 * UTF-8:对unicode进行编码的字符集，也称为万国码
		 * 			其中英文1字节，中文3字节，其他国家文字占用不等的文字量
		 */
		byte[] data = str.getBytes("UTF-8");//将字符串按照指定字符集转换为字节
		raf.write(data);//写出数据
		
		str = "我可以带你去吃很多，很多好东西！";
		data = str.getBytes("UTF-8");//将字符串按照指定字符集转换为字节
		raf.write(data);//写出数据
		raf.close();
		System.out.println("写出完毕！");
	}
}
