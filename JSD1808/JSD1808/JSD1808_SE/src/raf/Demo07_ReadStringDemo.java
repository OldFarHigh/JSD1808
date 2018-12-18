package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取字符数据
 * @author OldFarHigh
 *
 */
public class Demo07_ReadStringDemo {
		public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf.txt","r");
		/*
		 * 读取一个字节
		 * 问题：应当读取几个字节？
		 * 除非了解该字符集编码规则。否则无法确定应当读取多少个字节
		 * 
		 */
		byte [] data = new byte[(int)raf.length()];//RAF也有length方法，获取其读写的文件夹长度
		raf.read(data);//读取指定长度的数据
		String str = new String(data,"UTF-8");
		System.out.println(str);
		raf.close();
		
	}
}
