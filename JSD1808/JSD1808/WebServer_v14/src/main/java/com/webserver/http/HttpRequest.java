package com.webserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
//测试

/**
 * 解析请求对象
 * @author OldFarHigh
 *
 */
public class HttpRequest {
	/*
	 * 1、请求行相关信息定义
	 */
	private String method;//请求的方式
	private String url;//请求资源的抽象路径
	private String protocol;//请求使用的协议版本
	//请求路径 url中“？”左侧内容，没有“？”那么值与url一样
	private String requestURI;
	//请求路径url中“？”右侧内容，没有“？”那么值为nul
	private String queryString;
	//用于保存具体的每一个参数，key：参数名 value：参数值
	private Map<String,String> parameter = new HashMap<String,String>();
	/*
	 *2、 消息头相关信息定义
	 */
	//key:消息头的名字      value：消息头对应的值
	private Map<String,String> headers = new HashMap<String,String>();//
	/*
	 * 3、消息正文相关信息定义
	 */
	private byte[] content;
	
	//和连接相关的属性
	private Socket socket;//socket
	private InputStream in;//输入流
	/**
	 * 构造方法，创建HttpRequest实例的同时要求传入Socket实例。
	 * 该构造方法会通过Socket获取输入流、读取客户端发送过来的请求内容并解析来完成初始化
	 * 
	 * @param socket
	 * @throws EmptyRequestException 
	 */
	 public HttpRequest(Socket socket) throws EmptyRequestException {
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
	  * 1、解析请求行
	 * @throws EmptyRequestException 
	  */
	 private void parseRequestLine() throws EmptyRequestException  {//私有方法不对外，仅用于自身完成操作使用
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
			//若请求行内容是一个空串，则是空请求
			if("".equals(line)) {
				throw new EmptyRequestException();
			}
			/*
			 * 这里后期可能出现数组下标，因为HTTP协议允许客户端发送空请求
			 * （实际上连接后什么也没有发送，这时拆分后得不到三项）
			 * 后期解决。
			 */
			String[] arr = line.split("\\s");//按照空格拆分 转移字符//s代表空格
			this.method = arr[0] ;
			this.url = arr[1];
			this.protocol = arr[2];
			//进一步解析url
			parseUrl();
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
	  * 进一步解析url
	  */
	 private void parseUrl() {
		 System.out.println("进一步解析url。。。");
		 /*
		  * url可能存在两种情况：
		  * 带参数的或不带参数的。是否带参数可以通过查看当前url中是否含有“？”来得知
		  * 
		  * 如果该url不含有参数，那么直接将url赋值给属性resquestURI即可
		  * 若含有参数，那么就按照“？”将url拆分为来两部分
		  * 第一部分（“？”左侧内容）赋值给requestURI属性
		  * 第二部分（“？”右侧内容）赋值给queryString属性
		  * 然后还要对参数部分进一步解析：
		  * 因为参数部分的格式是固定的：
		  * name=value&name=value&...
		  * 所以我们可以将参数部分首先按照“&”进行拆分为若干段
		  * 每一段的内容应当为一个“name=value”，
		  * 然后我们将每一个参数再按照“=”拆分为参数名或参数值，
		  * 分别将他们当作key与value存入到属性parameter中问那称解析参数的工作。
		  * 
		  */
		 if(url.indexOf("?") !=(-1)) {//使用indexOf判断是否含有参数
				String[] data = url.split("\\?");//按照"?"拆分
				requestURI = data[0];//将左侧内容赋值给requestURI属性
				if(data.length>1) {//判断?后面是否有参数
					queryString = data[1];//将右侧内容赋值给queryString属性
					//对queryString解码，将%xx的内容转换为对应字符
					try {
						/*
						 * username=%E8%80%81%E6%B3%95%E6%B5%B7&password=123456&nickname=OldFarHigh&age=22
						 * username=老法海&password=123456&nickname=OldFarHigh&age=22
						 */
						System.out.println("解码前queryString:"+queryString);
						queryString =URLDecoder.decode(queryString,"UTF-8");//URLDecoder JAVA API自动转化
						System.out.println("解码后queryString:"+queryString);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					//3、进一步解析参数部分
					parseParameters(queryString);
				}
		 }else {
			 //不含有？
			 requestURI = url;
		 }
		 System.out.println("requestURI:"+requestURI);
		 System.out.println("queryString:"+queryString);
		 System.out.println("parameter:"+parameter);
		 System.out.println("解析url完毕！");
		 }
	 /*
	  * 解析参数：
	  * 参数是一个字符串，格式应当为：name=value&name=value&......
	  */
	 private void parseParameters(String line) {
		 String[] arr = line.split("&");//将右侧内容按照&拆分
			for (String str : arr) {
				String[] arr1 = str.split("=");//按照“=”将参数拆分成两部分
				if(arr1.length>1) {//判断该参数是否有值
					parameter.put(arr1[0], arr1[1]);
				}else {
					parameter.put(arr1[0], null);
				}
			}
	 }
	 /**
	  * 2、解析消息头
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
	  *3、解析消息正文 
	 * @throws IOException 
	  */
	 private void parseContent() throws IOException {
		 System.out.println("解析消息正文。。。");
		 /*
		  * 首先判断该请求是否含有消息正文，
		  * 判断依据是看当前请求的消息头中是否含有Content-Length
		  */
		 if(headers.containsKey("Content-Length")) {
			 System.out.println("此请求包含消息正文！-----------------------------------------》");
			 /*
			  * 获取消息正文的长度，并实际读取对应的字节量
			  */
			 int len =  Integer.parseInt(headers.get("Content-Length"));
			 byte[] data =new byte[len];
			 //将正文的内容读取出来
			 in.read(data);
			 //设置到消息正文对应的属性上
			 content =data;
			 //通过消息头获取该消息正文的类型
			 String type = headers.get("Content-Type");
			 /*
			  * 根据类型判定当前消息正文内容
			  */
			 //判断是否为表单提交的数据
			 if("application/x-www-form-urlencoded".equals(type)) {
				 /*
				  * 那么该正文是一行字符串，内容就是原GET请求表单时url中“？”右侧内容
				  */
				 String line = new String(content,"ISO8859-1");
				 System.out.println("正文内容："+line);
				 //解码
				 try {
					 line =URLDecoder.decode(line,"UTF-8");
				} catch (Exception e) {
					e.printStackTrace();
				}
				 System.out.println("解码后："+line);
				 //进一步解析参数
				 parseParameters(line);
			 }
			 
		 }
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
	 /**
		 * 解析参数
		 * 格式:name=value&name=value&...
		 * @param line
		 */
 

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
	public String getRequestURI() {
		return requestURI;
	}
	public String getQueryString() {
		return queryString;
	}
	/**
	 *根据给定的参数名获取对应的参数值
	 */
	public String getParameter(String name) {
		return parameter.get(name);
	}
	 
}