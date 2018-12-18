package dayTest_1016;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 创建用于处理客户端交互的线程
 * @author OldFarHigh
 *
 */
public class ClientHandler implements Runnable{
	//属性可以让所有方法访问
	private Socket socket;//socket进行C/S之间的交互
	private InputStream in;//输入流属性
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			//1、解析请求
			HttpRequest request = new HttpRequest(socket);
			//2、处理请求
			//3、响应客户端
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
