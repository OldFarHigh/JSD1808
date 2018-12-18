package raf;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * java.io.RandomAccessFile
 * 专门用来读写文件数据的API，RAF基于指针对文件数据读写
 * 可以移动指针读写任意位置，所以可以灵活的对文件数据进行编辑工作
 * 创建RAF时有两种常见模式：
 * r：只读模式
 * rw：读写模式
 * @author OldFarHigh
 *
 */
public class Demo01_RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 向当前目录中的文件raf.bat中写入一个字节
		 * 
		 * 创建RandomAccessFile时常用的构造方法
		 * RandomAccessFile(String path,String mode)
		 * RandomAccessFile(File file,String mode)
		 * 
		 * mode:模式，可以用"rw","r"
		 * 注意：如果是只读模式时，文件不存在时会抛出异常，
		 * 若读写模式，则会在不存在时自动件该文件创建出来
		 */
		RandomAccessFile raf = new RandomAccessFile("raf.bat","rw");
		/*
		 * void write(int d)
		 * 向文件中写入1个字节，写入的是给定的int值所对应的2进制的“低8位”
		 * 												   VVVVVVVV
		 * 00000000 00000000 00000000 00000001
		 */
		raf.write(1);
		raf.write(10);
		raf.write(100);
		System.out.println("写出完毕！");
		raf.close();
	}
}
