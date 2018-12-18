package raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 修改昵称
 * 
 * 程序启动后，要求用户输入要修改昵称的用户名
 * 以及新的昵称。然后将该用户昵称进行修改操作
 * 若输入的用户名不存在，则提示"无此用户"。
 * @author ta
 *
 */

public class Demo11_UpdateDemo {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入用户名:");
		String username = scanner.nextLine();
		
		System.out.println("请输入新的昵称:");
		String nickname = scanner.nextLine();
		
		RandomAccessFile raf= new RandomAccessFile("user.dat","rw");
		//开关，表示是否有修改过信息
		boolean update = false;
		for(int i=0;i<raf.length()/100;i++) {
			//先将指针移动到该条记录的开始位置
			raf.seek(i*100);
			//读取用户名
			byte[] data = new byte[32];
			raf.read(data);
			String name = new String(data,"UTF-8").trim();
			if(name.equals(username)) {
				//修改昵称
				//1先移动指针到昵称的位置
				raf.seek(i*100+64);
				//2重新写昵称32字节
				data = nickname.getBytes("UTF-8");
				data = Arrays.copyOf(data, 32);
				raf.write(data);
				System.out.println("修改完毕!");
				update = true;
				break;
			}
		}
		if(!update) {
			System.out.println("无此用户!");
		}
		raf.close();
		scanner.close();
	}
}
		