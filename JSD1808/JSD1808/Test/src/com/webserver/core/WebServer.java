package com.webserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * webserver第一天
 * @author OldFarHigh
 *
 */
public class WebServer{
	private ServerSocket server;
	//构造方法，初始化服务端
	public WebServer() {
		try {
			server = new ServerSocket(8088);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//启动服务端，当有客户端连接时创建socket
	public void start() {
		try {
			System.out.println("等待客户端连接。。。");//打桩操作
			Socket socket= server.accept();//当有客户端连接时创建一个socket
			System.out.println("一个客户端连接了");//打桩操作
			
			InputStream in = socket.getInputStream();//从socket处接收输入流
			int d = -1;//开关，如果返回值是-1，则没有接收到数据
			while((d=in.read())!=-1) {
				char c = (char) d;
				System.out.println(c);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
			WebServer web = new WebServer();
			web.start();
			
	}
}
