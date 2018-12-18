package raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 简易记事本工具
 * 程序启动后，要求用户输入一个文件名，然后对该文件机进行写操作
 * 之后用户输入的每行字符串都顺序写入到该文件中，当用户单独输入了
 * “exit”时，程序退出。
 * @author OldFarHigh
 *
 */
public class Demo06_Note {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		System.out.println("请输入您要操作的文件名：");
		String name = sc.nextLine();
		//String str = sc.toString();
		RandomAccessFile raf = new RandomAccessFile(name,"rw");
		System.out.println("请输入字符：");
		while(true) {
		String words = sc1.nextLine();
		if(words.equals("exit")) {
			System.out.println("程序退出！");
			break;
		} else{
		byte[] data = words.getBytes("UTF-8");
		raf.write(data);
		/*
		words = "/t";
		data =words.getBytes("UTF-8");
		raf.write(data);
		*/
		}
	}	
		System.out.println("欢迎您下次光临！");
		raf.close();
		sc.close();
		sc1.close();
	}
}
