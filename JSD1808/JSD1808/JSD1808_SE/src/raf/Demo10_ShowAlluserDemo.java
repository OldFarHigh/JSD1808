package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 显示所有用户信息
 * @author OldFarHigh
 *
 */
public class Demo10_ShowAlluserDemo {
		public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("user.dat","r");
		for (int i = 0; i < raf.length()/100; i++) {
			//1、创建装载32字节的数组
			byte[] data = new byte[32];
			//2、读取数组长度的字节并装载
			raf.read(data);
			//3、将字节数组还原为用户名字符串
			String username = new String(data,"UTF-8").trim();
		
			//4、读取并装载下一个数组
			raf.read(data);
			//5、将字节数组还原为密码字符串
			String password = new String (data,"UTF-8").trim();
			
			
			//6、读取并装载下一个数组
			raf.read(data);
			//7、将字节数组还原为昵称字符串
			String nickname = new String (data,"UTF-8").trim();
			
			//8、读取整数 年龄
			int age = raf.readInt();
			System.out.println(username+","+password+","+nickname+","+age);
			
		}
		raf.close();
	}
}
