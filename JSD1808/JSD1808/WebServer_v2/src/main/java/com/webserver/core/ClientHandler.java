package com.webserver.core;
import java.io.IOException;
import java.io.InputStream;
/**
 * 处理客户端交互
 * @author OldFarHigh
 */
import java.net.Socket;

public class ClientHandler implements Runnable {
	private Socket socket;
	
	public	ClientHandler(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			InputStream in = socket.getInputStream();
//			int d = -1;
//			while((d=in.read())!=-1) {
//				char c = (char)d;
//				System.out.print(c);
//			}
			String line = readLine(in);
			System.out.println(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	/**
	 * 通过输入流读取客户端发送过来的一行字符串
	 * 以CRLF结尾为一行的结束，返回的字符串不含有最后的CRLF
	 * @param in
	 * @return
	 */
public String readLine(InputStream in)  throws IOException{
		int  d = -1;//每次读取到的字节
		char c1='a',c2='a';//c1表示上次读取的字节，c2表示本次读取的字节
		StringBuilder builder = new StringBuilder();//用来拼接读取到的一行字符串
		while((d =  in.read()) != -1) {
			c2  = (char) d;
			if(c1 == 13 &&c2 == 10 ) {
				break;
			}
			builder.append(c2);
			c1 =c2;
		}
		return builder.toString().trim();
	}
}
