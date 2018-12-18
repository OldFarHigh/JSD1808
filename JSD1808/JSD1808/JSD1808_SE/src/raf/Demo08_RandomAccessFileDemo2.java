package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RAF读写基本类型数据，以及RAF基于指针的读写操作
 * RAF总是在指针指向位置要么读，要么写一个字节，
 * 并且无论是读还是写进行后，指针都会自动向后移动一个字节
 * @author OldFarHigh
 *
 */
public class Demo08_RandomAccessFileDemo2 {
	public static void main(String[] args) throws IOException {
		
		RandomAccessFile raf = new RandomAccessFile("raf.bat","rw");
		/*
		 * long getFilePoint()
		 * 获取当前RAF的指针位置
		 */
		long pos = raf.getFilePointer();//获取指针位置的方法
		System.out.println("pos:"+pos);
		int max  = Integer.MAX_VALUE;
		/*
		 * 写出int的最大值max
		 * 		1				2				3				4
		 * 01111111 11111111 11111111 11111111 
		 * max>>>24
		 * 												   VVVVVVVV
		 * 01111111 11111111 11111111 11111111 
		 * 移动位数
		 * 
		 */
		raf.write(max>>>24);//移动三个字节的位置写出第四个字节的内容
		System.out.println("pos:"+raf.getFilePointer());
		raf.write(max>>>16);//移动两个字节的位置写出第三个字节的内容
		System.out.println("pos:"+raf.getFilePointer());
		raf.write(max>>>8);	 //移动一个字节的位置写出第二个字节的内容
		System.out.println("pos:"+raf.getFilePointer());
		raf.write(max);      	//写出第一个字节后8位的内容
		System.out.println("pos:"+raf.getFilePointer());
		raf.writeInt(max);    //一次性写4个字节，将给定的int值写出
		System.out.println("pos:"+raf.getFilePointer());
		/*
		 * RAF对基本类型的写出方法都有提供
		 */
		raf.writeLong(122310L);
		System.out.println("pos:"+raf.getFilePointer());
		raf.writeDouble(123.123);
		System.out.println("pos:"+raf.getFilePointer());
		System.out.println("写出完毕！");
		/*
		 * void seek(long pos)
		 * 移动指针到指定位置
		 */
		raf.seek(0);//移动指针到文件的开始
		System.out.println("pos:"+raf.getFilePointer());
		/*
		 * RAF也提供了读取基本类型数据的方法
		 * int readInt()
		 * 连续读取4字节并还原int值。
		 * 若在读取4个字节的过程中发现读取到文件末尾，则直接抛出异常
		 * EOFExeption   EOF:end of file
		 * 注：这个方法并不会以返回-1表示文件末尾， 而是直接抛异常
		 * 原因在于这里是真实读取4字节的int值。那么在读取的数据中可能读取到int型-1的
		 * 所以就不能再用int型-1表示文件末尾了
		 */
		//读取int
		int d = raf.readInt();
		System.out.println(d);
		//读取long
		raf.seek(8);//移动指针到指定位置
		long l = raf.readLong();
		System.out.println(l);
		System.out.println("pos:"+raf.getFilePointer());
		//读取double
		double dou = raf.readDouble();
		System.out.println(dou);
		System.out.println("pos:"+raf.getFilePointer());
		
		/*
		 * 修改long值为456
		 */
		//1、移动指针到long指针所在的位置
		raf.seek(16);
		//2、重写写8字节，将原long值覆盖
		raf.writeLong(456);
		System.out.println("修改完毕！");
		raf.seek(16);
		l = raf.readLong();
		System.out.println(l);
		raf.close();
		
	}
}
