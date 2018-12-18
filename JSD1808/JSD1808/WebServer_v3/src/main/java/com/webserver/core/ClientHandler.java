package com.webserver.core;
import java.io.IOException;
import java.io.InputStream;
/**
 * 处理客户端交互
 * @author OldFarHigh
 */
import java.net.Socket;

import com.webserver.http.HttpRequest;

public class ClientHandler implements Runnable {
	private Socket socket;
	
	public	ClientHandler(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			//1、解析请求
			HttpRequest request = new HttpRequest(socket);
			//2、处理请求
			//3、响应客户端
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	
}