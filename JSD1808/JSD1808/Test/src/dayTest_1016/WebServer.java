package dayTest_1016;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * webserver第一天
 * @author OldFarHigh
 *
 */
public class WebServer{
	private ServerSocket server;
	//构造方法，初始化服务端
	public WebServer() {
		try {
			server = new ServerSocket(8088);//ServerSocket
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//启动服务端，当有客户端连接时创建socket
	public void start() {
		try {
			System.out.println("等待客户端连接。。。");//打桩操作
			Socket socket= server.accept();//当有客户端连接时创建一个socket
			System.out.println("一个客户端连接了");//打桩操作
			//创建ClientHnadler实现数据交互的操作
			ClientHandler handler = new ClientHandler(socket);
			Thread t1 = new Thread(handler);
			t1.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
			WebServer web = new WebServer();
			web.start();
			
	}
}
