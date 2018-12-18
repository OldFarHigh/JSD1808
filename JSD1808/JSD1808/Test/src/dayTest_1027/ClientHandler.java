package dayTest_1027;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 用于处理与一个客户端的交互工作
 * @author 
 *
 */
public class ClientHandler implements Runnable {
	private Socket socket;
	
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			HttpRequest request = new HttpRequest(socket);
			
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
	

	}

