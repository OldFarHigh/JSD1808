package raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 完成用户注册功能
 * 用户信息包含：用户名，密码，昵称，年龄
 * 
 * 其中除了年龄为int外，其余为字符串String
 * 每条记录占用100字节，其中：用户名，密码，昵称各占用32字节，年龄是固定的4字节
 * 
 * 由于字符串的实际字节量取决于字符的多少，为了格式的统一
 * 便于读取，也为了后期可以修改字符串内容，我们常见的做法是：对字符串“留白”
 * 将字符串的长度定的大一些，并且为固定值
 * 
 * 
 * @author OldFarHigh
 *
 */
public class Demo09_RegDemo {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("欢迎注册!");
		System.out.println("请输入用户名：");
		String username = scanner.nextLine();
		System.out.println("请输入密码：");
		String password = scanner.nextLine();
		System.out.println("请输入昵称：");
		String nickname = scanner.nextLine();
		System.out.println("请输入年龄 ：");
		int age = Integer.parseInt(scanner.nextLine());
		RandomAccessFile raf =  new RandomAccessFile("user.dat","rw");
		//将指针移到文件末尾
		raf.seek(raf.length());
		
		//写用户名
		byte[] data = username.getBytes("UTF-8");
		//数组扩容
		data  = Arrays.copyOf(data, 32);
		//写出数据
		raf.write(data);
		
		//写密码
		data = password.getBytes("UTF-8");
		data  = Arrays.copyOf(data, 32);
		raf.write(data);
		
		//写昵称
		data = nickname.getBytes("UTF-8");
		data  = Arrays.copyOf(data, 32);
		raf.write(data);
		
		//写年龄
		raf.writeInt(age);
		
		System.out.println("注册完成！");
		raf.close();
		scanner.close();
	}
}
