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
			 * 2.2：从webapps目录中根据资源路径位置寻找请求的资源是否存在
			 */
			//2.1
			String url = request.getUrl();
			//2.2
			File file =new File("webapps"+url);
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