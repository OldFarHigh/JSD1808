package dayTest_1022;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端主程序
 * @author OldFarHigh
 *
 */
public class WebServer {
	private ServerSocket server;
	public void WebServer() {//构造方法
		try {
			server = new ServerSocket(8088);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void start() {//服务端启动的方法
		System.out.println("服务端启动中。。。");
		try {
			Socket socket =server.accept();//服务端启动后进入阻塞状态
			InputStream in = socket.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("服务端启动完成了！");
	}
	public static void main(String[] args) {
		WebServer web = new WebServer();
		web.start();

	}

}
