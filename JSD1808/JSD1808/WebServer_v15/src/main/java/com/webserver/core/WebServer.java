package com.webserver.core;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * WebServer主类
 * @author soft01
 *
 */
public class WebServer{
	private ServerSocket server;
	/*
	 * 初始化服务器
	 */
	public WebServer() {
		try {
			server = new ServerSocket(8088);//实例化服务端，连接本地端口，用以连接客户端。
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * 服务器启动
	 */
	public void start(){
		try {
			/*
			 * 暂时不启用接收多次客户端连接的操作
			 */
		while(true) {
				System.out.println("等待客户端连接。。。");//打桩操作
				Socket socket = server.accept();//阻塞状态监听端口是否被连接，连接后返回创建一个socket与客户端交互
				System.out.println("一个客户端连接了。。。");//打桩操作
				
				//启动一个线程处理与该客户端的交互
				ClientHandler handler = new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
				//socket.close();	
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void run() {
		
	}
	public static void main(String[] args) {
		WebServer  wb = new WebServer();
		wb.start();
	}
	
}
