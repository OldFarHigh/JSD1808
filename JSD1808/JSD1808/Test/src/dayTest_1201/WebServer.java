package dayTest_1201;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.webserver.core.ClientHandler;

public class WebServer {
	//全局变量 
	private ServerSocket server;
	//构造方法,初始化服务端
	public void webServer() {
		try {
			server = new ServerSocket(8088);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//启动方法
	public void start() {
		try {
			//while(true) {
				System.out.println("等待客户端连接了。。。");
				Socket  socket = server.accept();
				System.out.println("客户端连接了。。。");
		//	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		WebServer server =  new WebServer();
		server.start();
	}
}
