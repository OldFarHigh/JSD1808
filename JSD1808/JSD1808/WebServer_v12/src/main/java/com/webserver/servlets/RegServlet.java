package com.webserver.servlets;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

/**
 * 处理注册业务
 * @author OldFarHigh
 *
 */
public class RegServlet {
	/**
	 * 处理具体业务操作的方法
	 */
	public void service(HttpRequest request, HttpResponse response) {
		/*
		 * 处理业务流程
		 * 1：通过HttpRequest获取用户提交的表单信息
		 * 2：将信息写入文件包存
		 * 3：响应客户端注册结果的页面
		 */
		try (
				RandomAccessFile raf = new RandomAccessFile("user.dat","rw");
			){	
			System.out.println("ResServlet:开始处理注册");
			/*
			 * 1、通过request.getParameter获取表单提交的数据
			 * 这里传递的参数应当与reg.html页面表单中对应输入框的名字一致（name="xxxx",输入框name属性的值）
			 */
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String nickname = request.getParameter("nickname");
			int age =Integer.parseInt(request.getParameter("age")	);
			
			//验证是否为重复用户
			boolean check =false;
			for (int i = 0; i < raf.length()/100; i++) {
				raf.seek(100*i);//每次移动指针到名字位置
				byte[] arr = new byte[32];//创建数组
				raf.read(arr);//将名字的数据装载进数组
				String name = new String(arr,"UTF-8").trim();//加载名字
				if(name.equals(username)) {//如果用户名字相同
					check = true;//有此用户了
					break;
				}
			}
			if(check == true) {
				//直接调转提示用户已存在的界面
				response.setEntity(new File("webapps/myweb/reg_fail.html"));
			}else {//如果用户不存在，将注册信息存入文件并跳转注册完成页面
				/*
				 * 2、将该用户信息写入文件uesr.dat中
				 * 	每条记录占用100字节
				 * 其中：username，password，nickname为字符串，
				 * 各占用32字节，age为int值占用4字节
				 */
				raf.seek(raf.length());//先将指针移动到文件末尾
				
				byte[] data = username.getBytes("UTF-8");//写用户名
				data = Arrays.copyOf(data, 32);//数组扩容到32字节
				raf.write(data);//写入该32字节
				
				data = password.getBytes("UTF-8");//写密码
				data = Arrays.copyOf(data, 32);//继续扩容
				raf.write(data);//写入该32子节
				
				data = nickname.getBytes("UTF-8");//写昵称
				data = Arrays.copyOf(data, 32);//再次扩容
				raf.write(data);//写入该32子节
				
				raf.writeInt(age);//写入年龄
				
				
//				System.out.println(username+","+password+","+nickname+","+age);
				//3、响应客户端注册成功的页面
				response.setEntity(new File("webapps/myweb/reg_success.html"));	
			}
			System.out.println("RegServlet:处理注册完毕");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
