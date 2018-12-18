package com.webserver.core;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
				/*
				 * 发送一个标准的响应内容
				 * 1：发送状态行
				 * 2：发送响应头
				 * 3：发送响应正文
				 */
				OutputStream out = socket.getOutputStream();
				//1、发送状态行
				String line = "HTTP/1.1 200 OK";//发送的内容
				out.write(line.getBytes("ISO8859-1"));//发送字节
				out.write(13);//writeen CR
				out.write(10);//written LF
				//2、发送响应头
				//Content-Type是告知客户端响应正文的数据类型
				//下面是指该正文是一个html页面
				line ="Content-Type: text/html";
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);//writeen CR
				out.write(10);//written LF
				
				//Content-Length是告知客户端正文的长度，单位是字节
				line = "Content-Length:"+file.length();
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);//written CR
				out.write(10);//written LF
				//单独发送CRLF表示响应头发送完毕
				out.write(13);//written CR
				out.write(10);//written LF
				
				//发送正文内容
				FileInputStream fis = new FileInputStream(file);
				int len = -1;
				byte[] data =new byte[1024*10];
				while((len=fis.read(data) )!= -1) {
					out.write(data,0,len);
				}
			}else{
				System.out.println("该资源未找到！");
			}
			//3、响应客户端
		} catch (Exception e) {
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