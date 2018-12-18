package com.webserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 请求对象
 * @author OldFarHigh
 *
 */
public class HttpRequest {
	/*
	 * 请求行相关信息定义
	 */
	private String method;//请求的方式
	private String url;//请求资源的抽象路径
	private String protocol;//请求使用的协议版本
	/*
	 * 消息头相关信息定义
	 */
	//key:消息头的名字      value：消息头对应的值
	private Map<String,String> headers = new HashMap<String,String>();//
	/*
	 * 消息正文相关信息定义
	 */
	
	//和连接相关的属性
	private Socket socket;//socket
	private InputStream in;//输入流
	/**
	 * 构造方法，创建HttpRequest实例的同时要求传入Socket实例。
	 * 该构造方法会通过Socket获取输入流、读取客户端发送过来的请求内容并解析来完成初始化
	 * 
	 * @param socket
	 */
	 public HttpRequest(Socket socket) {
		 try {
			this.socket = socket;
			 this.in = socket.getInputStream();//通过socket获取输入流
			 /*
			  * 解析一个请求的过程
			  * 1：解析请求行
			  * 2：解析消息头
			  * 3：解析消息正文
			  */
			 parseRequestLine();
			 parseHeaders();
			 parseContent();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	 /**
	  * 解析请求行
	  */
	 private void parseRequestLine() {//私有方法不对外，仅用于自身完成操作使用
		 System.out.println("解析请求行。。。");
		 /*
		  * 1、先通过输入流读取第一行发送过来的字符串
		  * 2、按照空格拆分这行字符串，这样应当会拆分出三部分
		  * 3、分别将这三部分内容设置到对应属性上
		  * 	  method ,		url , 		protocol
		  */
		 
		try {
			String line = readLine();
			System.out.println("请求行："+line);
			/*
			 * 这里后期可能出现数组下标，因为HTTP协议允许客户端发送空请求
			 * （实际上连接后什么也没有发送，这时拆分后得不到三项）
			 * 后期解决。
			 */
			String[] arr = line.split("\\s");//按照空格拆分 转移字符//s代表空格
			this.method = arr[0] ;
			this.url = arr[1];
			this.protocol = arr[2];
			//System.out.println(arr.length);
			System.out.println("method:"+method );
			System.out.println("url:"+url);
			System.out.println("protocol:"+protocol);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 System.out.println("解析请求行完毕！");
	 }
	 /**
	  * 解析消息头
	  */
	 private void parseHeaders() {
		 System.out.println("解析消息头。。。");
		 /*
		  * 由于解析请求行操作中通过readLine方法读取了请求的第一行内容（请求行内容），
		  * 那么在这里继续调用readLine方法通过输入流读取的每一行内容应该都是一个消息头。
		  * 所以在这里循环读取每一行内容，直到循环值为空字符串时停止（返回空字符串说明单独读取了一个CRLF）
		  * 然后将每个消息头按照“：”进行拆分，并将消息头的名字作为key，将消息头的值作为value，
		  * 保存到属性headers这个Map中
		  */
		
		 
		 while(true) {
			 try {
				 while(true) {
						String line = readLine();
						if("".equals(line)) {
							break;
						}
						String[] data = line.split(":\\s");
						headers.put(data[0], data[1]);
					}
					System.out.println("headers:"+headers);
				 	
				 	
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			break;
		 }
		 
		 System.out.println("解析消息头完毕！");
	 }
	 /**
	  *解析消息正文 
	  */
	 private void parseContent() {
		 System.out.println("解析消息正文。。。");
		 
		 System.out.println("解析消息正文完毕！");
	 }
	 /**
		 * 通过输入流读取客户端发送过来的一行字符串
		 * 以CRLF结尾为一行的结束，返回的字符串不含有最后的CRLF
		 * @param in
		 * @return
		 */
	 public String readLine()  throws IOException{
			//return null;
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
	

	 /*
	  * 以下为属性的get方法
	  * 请求中的属性不需要对外提供set方法，因为请求对象表示的是客户端发送过来的请求内容。
	  * 所以无需外界对这些属性赋其他值。
	  */
	public String getMethod() {
		return method;
	}


	public String getUrl() {
		return url;
	}


	public String getProtocol() {
		return protocol;
	}
	/**
	 * 根据给定的消息的名字获取对应消息头的值
	 * @param name
	 * @return
	 */
	public String getHeader(String name) {
		return headers.get(name);
	}
	 
}