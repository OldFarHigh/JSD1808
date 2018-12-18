package dayTest_1016;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 请求对象，解析对象
 * @author  OldFarHigh
 *
 */
public class HttpRequest {
	//连接相关的属性
	private Socket socket;//处理交互的socket
	private InputStream in;//接收输入流的InputStream
	/*
	 * 请求对象内容有三部分：
	 * 1、请求行
	 * 2、消息头
	 * 3、消息正文
	 */
	//定义请求行信息的三个组成部分
	private String method;//请求的方式
	private String url;//请求资源的抽象路径
	private String protocol;//请求使用的协议版本
	
	public HttpRequest(Socket socket) {//构造方法，初始化请求响应操作
		
		try {
			this.socket = socket;
			this.in = socket.getInputStream();
			//解析对象的方法
			parseRequestLine();
			parseHeaders();
			parseContent();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

		private void parseRequestLine() {//解析请求行
			System.out.println("正在解析请求行。。。");
			try {
				String line = readLine();
				System.out.println(line);
				String[] arr = line.split("\\s");
				this.method = arr[0];
				this.url = arr[1];
				this.protocol = arr[2];
				System.out.println("mthod:"+method);
				System.out.println("url:"+url);
				System.out.println("protocol:"+protocol);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("请求行解析完成！");
		}
		private void parseHeaders() {//解析消息头
			System.out.println("正在解析消息头。。。");
			System.out.println("消息头解析完成！");
		}
		

		private void parseContent() {//解析消息正文
			System.out.println("正在解析消息正文。。。");
			System.out.println("消息正文解析完成！");
		}
		/*
		 * 创建读取信息请求的方法，因为请求每一行都是CRLF结尾的
		 */
		public String readLine() throws IOException {
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
		/*
		 * 获取请求行信息的方法
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

}

