package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取文件数据
 * @author OldFarHigh
 *
 */
public class Demo02_ReadDemo {
	public static void main(String[] args) throws IOException  {
		/*
		 * 从raf.bat中读取数据
		 */
		RandomAccessFile raf = new RandomAccessFile("raf.bat","rw");
		/*
		 * int read()
		 * 从文件中读取1个字节，并以int形式返回。若返回值为-1，则表示读取到了文件末尾
		 * 00000000 00000000 00000000  00000001
		 */
		raf.write(0); 
		int d = raf.read();
		System.out.println(d);//读取内容
		
		d = raf.read();//读取内容
		System.out.println(d);//
		raf.close();//关闭
	}
}
