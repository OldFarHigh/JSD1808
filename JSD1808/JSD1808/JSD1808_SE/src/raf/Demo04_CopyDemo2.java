package raf;


import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 提高每次读写的数据量，减少实际发生的读写次数，可以提高读写效率
 * 单字节读写的模式，	   一般称为：随机读写
 * 一组一组字节读写的模式一般称为：块读写
 * @author OldFarHigh
 *
 */
public class Demo04_CopyDemo2 {
	 public static void main(String[] args) throws IOException {
		/*
		 * RandomAccessFile 提供了读写的方法
		 * int read (byte[] data)
		 * 一次性读取给定字节数组总长度的字节量并存入到该数组中
		 * 返回值为实际读取到的字节量，若返回值为-1，
		 * 则表示文件末尾(本次没有读取到任何字节)
		 * 
		 * void write (byte[] data)
		 * 一次性将给定的字节数组中所有字节写出
		 * 
		 * void write(byte[] data,int index, int len)
		 * 将给定字节数组从下标index处开始的连续len个字节一次性写出
		 */
		 RandomAccessFile src = new RandomAccessFile("1bullet.png","r");
		 RandomAccessFile desc = new RandomAccessFile("1bullet_cp2.png","rw");
		 byte[] data = new byte[1024*10];//定义字节数组每次读写
		 long  start = System.currentTimeMillis();
		 int len = -1;//设定初始值
		 while((len =src.read(data) )!= -1) {//当给定的数组不为空时,不到文件末尾
			 desc.write(data, 0, len);//将给定的数组data从0到len个字节一次性写出到desc中
		 }
		 long end =System.currentTimeMillis();
		 System.out.println("复制完毕！耗时为："+(end-start)+"ms");
			src.close();
			desc.close();
	}
}
