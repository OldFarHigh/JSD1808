package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Demo03_CopyDemo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src = new RandomAccessFile("1bullet.png","r");
		RandomAccessFile desc = new RandomAccessFile("1bullet_cp.png","rw");
		long start = System.currentTimeMillis();//
		int d = -1;//设置初始值
		while ((d = src.read())!=-1) {
			desc.write(d);//保存每次读取到的字节
		}
		long end = System.currentTimeMillis();//赋值完毕后调用该方法
		System.out.println("复制完毕！耗时为："+(end-start)+"ms");
		src.close();
		desc.close();
	}
}
