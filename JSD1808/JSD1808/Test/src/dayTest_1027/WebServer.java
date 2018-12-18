package dayTest_1027;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * WebServer主类
 * @author OldFarHigh
 *
 */
public class WebServer {
	private ServerSocket server;
	
	public WebServer() {
		try {
			server = new ServerSocket(8088);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void start() {
		try {
			System.out.println("等待客户端连接。。。。");
			Socket socket = server.accept();//进入阻塞状态等待连接
			System.out.println("一个客户端连接了。。。");
		   
			ClientHandler handler = new ClientHandler(socket);
			Thread t = new Thread(handler);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		WebServer web = new WebServer();
		web.start();
	}

}
