package raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 修改昵称
 * 
 * 程序启动后，要求用户输入要修改的用户名，以及新的昵称然后对该用户进行修改
 * 若输入的用户名不存在，则提示无此用户。
 * @author OldFarHigh
 *
 */
public class UpdateDemo {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要修改的用户名：");	
		String username =sc.nextLine();
		System.out.println("请输入新的昵称");
		String nickname = sc.nextLine();
		RandomAccessFile raf = new RandomAccessFile("user.dat","rw");
		boolean update = false;//添加开关，用以甄别是否被修改
		for (int i = 0; i < raf.length()/100; i++) {
			raf.seek(i*100);//将指针调到用户名的 位置
			byte[] data = new byte[32];
			raf.read(data);
			String str =new String(data,"UTF-8").trim();
			if(str.equals(username)) {//如果用户名相同
				raf.seek(i*100+64);//将指针调到修改昵称的位置
				data = nickname.getBytes("UTF-8");//将昵称写入
				data = Arrays.copyOf(data, 32);//数据扩容
				raf.write(data);//写出数据
				System.out.println("修改完毕！");
				update =true;
				break;
			}
			}//for循环结束
			if(!update) {
				System.out.println("无用户名");
			}
		raf.close();
		sc.close();
		
	}
}
