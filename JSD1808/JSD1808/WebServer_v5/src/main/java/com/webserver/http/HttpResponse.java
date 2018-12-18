package com.webserver.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 响应对象
 * @author soft01
 *
* 发送一个标准的响应内容
* 1：发送状态行
 * 2：发送响应头
 * 3：发送响应正文
*/
 
public class HttpResponse {
	/*
	 * 状态行相关信息
	 */
	
	/*
	 * 响应头相关信息
	 */
	
	/*
	 * 响应正文相关信息
	 */
	private File entity;//响应的实体文件
	///和连接相关的信息
	private Socket socket;//交互用的socket
	private OutputStream out;//输出流
	
	public HttpResponse(Socket socket) {//构造方法
		try {
			this.socket =socket;
			this.out = socket.getOutputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 将当前响应对象内容按照HTTP响应格式发送给客户端
	 */
	public void flush() {
		/*
		 * 1、发送状态行
		 * 2、发送响应头
		 * 3、发送响应正文
		 */
		sendStatusLine();
		sendHeaders();
		sendContent();
	}
	/**
	 * 发送状态行
	 */
	private void sendStatusLine() {
		//1、发送状态行
		String line = "HTTP/1.1 200 OK";//发送的内容
		println(line);
		
	}
	/**
	 * 发送响应头
	 */
	private void sendHeaders() {
		//2、发送响应头
				//Content-Type是告知客户端响应正文的数据类型
				//下面是指该正文是一个html页面
				 String  line ="Content-Type: text/html";
				 println(line);
			
				//Content-Length是告知客户端正文的长度，单位是字节
				line = "Content-Length:"+entity.length();
				println(line);

				//单独发送CRLF表示响应头发送完毕
				println("");
				
	}
	/**
	 * 发送响应正文
	 */
	private void sendContent() {
		//发送正文内容
				try(
						FileInputStream fis = new FileInputStream(entity);
			) {
					int len = -1;
					byte[] data =new byte[1024*10];
					while((len=fis.read(data) )!= -1) {
						out.write(data,0,len);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
	}
	/**
	 * 向客户端发送一行字符串（发送后会自动发送CRLF结尾）
	 * @param line
	 */
	private void println(String line) {
		try {
			out.write(line.getBytes("ISO8859-1"));
			out.write(13);//written CR
			out.write(10);//written LF
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 属性对应的get，set方法
	 */	
	public File getEntity() {
		return entity;
	}
	public void setEntity(File entity) {
		this.entity = entity;
	}
}
