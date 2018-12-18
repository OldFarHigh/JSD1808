package com.webserver.servlets;
import java.io.File;
import java.io.RandomAccessFile;
/**
 * 并在该类中定义service方法（与RegServlet方法定义相同）
*	在该方法中首先通过request获取用户名及密码
*	然后通过RandomAccessFile读取user.dat文件，
*	顺序读取每个用户名的名字与该用户名比对，
*	若找到则比对密码，若密码输入正确则跳转登录成功页面。
*	若密码输入错误，或该用户在user.dat文件中不存在，则跳转登录失败页面。
 */

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

public  class LoginServlet extends HttpServlet {
	public void service(HttpRequest request,HttpResponse response) {
		System.out.println("开始处理登录信息");
		String name = request.getParameter("username");//获取登录信息中的名字数据
		String password = request.getParameter("password");//获取登录信息中的密码数据

		try (RandomAccessFile raf = new RandomAccessFile("user.dat","r"))//通过文件流读取user的注册文件
		{	
			//检查用户是否存在
		//	boolean check = false;
			for (int i = 0; i <raf.length()/100; i++){
				raf.seek(100*i);
				byte [] arr = new byte[32];//创建空的数组用来装载数据
				raf.read(arr);//读取用户名
				String getname = new String(arr,"UTF-8").trim();//转换读取到的用户名
				if(getname.equals(name)) {//如果用户名相同，则进行比较
					//check =true;
//					raf.seek(32);//指针往后32位
//					byte [] arr1= new byte[32];//创建空的数组用来装载数据
//					raf.read(arr1);
					raf.read(arr);
					String getpassword = new String(arr,"UTF-8").trim();
					if(getpassword.equals(password)) {//如果密码一样则跳转成功页面
						/*
						 * 需要注意，重定向中指定的相对路径是针对浏览器的。
						 * 而浏览器之前的请求路径是请求当前Servlet时的路径
						 * http://localhost:8088/myweb/reg
						 * 所以当前目录是：
						 * http://localhost:8088/myweb
						 * 对此，我们指定重定向路径如：login_success.html
						 * 浏览器在接收到后，就会自动请求：
						 * http://localhost:8088/myweb/login_success.html
						 */
						response.sendRedirect("login_success.html");//重定向登录成功页面
					//	response.setEntity(new File("webapps/myweb/login_success.html"));
					}else {
						response.sendRedirect("login_fail02.html");
//						response.setEntity(new File("webapps/myweb/login_fail02.html"));
					}
					break;
				}else {//不同则跳转失败界面
					response.sendRedirect("login_fail01.html");
//					response.setEntity(new File("webapps/myweb/login_fail01.html"));
				}

			}	
				System.out.println("处理登录完毕！");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


}

