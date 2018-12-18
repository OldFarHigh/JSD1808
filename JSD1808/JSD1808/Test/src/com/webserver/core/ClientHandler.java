package com.webserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 创建用于处理客户端交互的线程
 * @author OldFarHigh
 *
 */
public class ClientHandler implements Runnable{
	private Socket socket;
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/*
	 * 创建读取信息请求的方法，因为请求每一行都是CRLF结尾的
	 */
	public String readLine(InputStream in) throws IOException {
		int d = -1;
		char c1 = 'a', c2='a';
		StringBuilder builder = new StringBuilder();
		while((d=in.read())!= -1) {
		c2 = (char)d;
		if(c1 ==13&& c2==10) {
			break;
		}
		builder .append(c2);
		c1=c2;
		}
		return builder.toString().trim();
		
	}
}
