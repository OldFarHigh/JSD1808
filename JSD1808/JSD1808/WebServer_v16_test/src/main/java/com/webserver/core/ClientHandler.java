package com.webserver.core;
import java.io.File;
import java.io.IOException;

/**
 * 处理客户端交互
 * @author OldFarHigh
 */
import java.net.Socket;

import com.webserver.http.EmptyRequestException;
import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;
import com.webserver.servlets.LoginServlet;
import com.webserver.servlets.RegServlet;
import com.webserver.servlets.ShowAllUserServlet;

public class ClientHandler implements Runnable {
	private Socket socket;
	
	public	ClientHandler(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			//1、准备工作
			//1.1解析请求
			HttpRequest request = new HttpRequest(socket);
			//1.2创建响应
			HttpResponse response = new HttpResponse(socket);
	
			//2、处理请求
			/*
			 * 2.1：通过request获取请求的资源路径
			 * 2.2：判断该请求是否为请求一个业务，不是则执行2.3
			 * 2.3：从webapps目录中根据资源路径位置寻找请求的资源是否存在
			 */
			//2.1
			 String uri = request.getRequestURI();
			System.out.println("uri:******"+uri);
			//2.2
			 if("/myweb/reg".equals(uri)) {//查看该请求是否为一个注册业务
				RegServlet servlet = new RegServlet();
				servlet.service(request, response);//处理具体业务
				//System.out.println("处理注册！！！！！");
			}else if("/myweb/login".equals(uri)) {//查看请求是否为一个登录页面
				System.out.println("开始处理登录业务。。。。。。");
				LoginServlet servlet =new LoginServlet();
				servlet.service(request, response);//处理具体登录业务
				System.out.println("处理登录业务完成。。。。。。。");
			}else if("/myweb/showAllUser".equals(uri)){
				System.out.println("开始处理信息业务。。。。");
				ShowAllUserServlet servlet = new ShowAllUserServlet();
				servlet.service(request, response);
				System.out.println("信息业务处理完成！");
			}else {
				//2.3
				//不是注册业务执行2.3
				File file =new File("webapps"+uri);
				//判断用户请求的资源是否存在
				if(file.exists()) {
					System.out.println("该资源已找到了！");
					//将该资源响应给客户端
					response.setEntity(file);
				}else{
					System.out.println("该资源未找到！");
					response.setStatusCode(404);
					response.setEntity(new File("webapps/root/404.html"));
				}
			}
			//3、响应客户端
			response.flush();
			} catch(EmptyRequestException e) {
			System.out.println("空请求");
			}catch (Exception e) {
				e.printStackTrace();	
		}finally {
			try {
				socket.close();//响应完毕后与客户端断开连接!
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	


	
}