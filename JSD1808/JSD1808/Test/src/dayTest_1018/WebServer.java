package dayTest_1018;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器的主类
 * @author soft01
 *
 */
public class WebServer {
	private ServerSocket server;
	/*
	 * 创建构造方法，初始化服务器
	 */
	public WebServer() {
		  try {
			server = new ServerSocket(8088);//初始化server,创建服务端，连接端口
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	/*
	 * 启动服务器，进入阻塞状态，当有客户端连接时，创建socket用以连接交互
	 */
	public void start() {
		try {
		//	while(true) {
				System.out.println("打桩操作：等待服务端连接！");
				Socket socket = server.accept();//服务端进入阻塞状态，当服务端被连接时，创建一个socket用以连接
				System.out.println("打桩操作：服务端连接完成");
		//	}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		

	}

}
