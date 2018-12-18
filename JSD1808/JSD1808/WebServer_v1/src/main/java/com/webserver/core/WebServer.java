package com.webserver.core;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author OldFarHigh
 *
 */
public class WebServer{
	private ServerSocket server;
	/*
	 * 初始化服务器
	 */
	public WebServer() {
		try {
			server = new ServerSocket(8088);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * 服务器启动
	 */
	public void start(){
		try {
			System.out.println("等待客户端连接。。。");
			Socket socket = server.accept();
			System.out.println("一个客户端连接了。。。");
			InputStream in = socket.getInputStream();
			int d = -1;
			while((d=in.read())!=-1) {
				char c = (char)d;
				System.out.print(c);
			}
			//socket.close();
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
