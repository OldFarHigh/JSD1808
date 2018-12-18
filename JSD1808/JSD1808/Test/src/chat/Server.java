package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * 聊天室服务端
 * @author OldFarHigh
 *
 *第一天：實現服務端接收客戶端發送的消息
 *滿足多個客戶端正常連接服務端（多線程）
 *第二天：實現服務器向客戶端發送消息，
 *並做最後的清理操作
 *
 *
 */
public class Server {
	private ServerSocket server;//成员数据
	private PrintWriter[] allOut = {};//创建数组装载客户端发送的所有数据
	public  Server() { //构造方法：初始化服务端
		try {
			System.out.println("正在創建服務端：。。。");//打粧：開始創建服務端
			server = new ServerSocket(8088);//实例化服务端，连接本地端口，用以連接客戶端
			System.out.println("創建服務端成功：。。。");//打粧：成功創建服務端
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * 服务端運行
	 */
	public void  Start() {
		try {
			while(true) {
				System.out.println("等待連接：。。。");
				Socket socket = server.accept();//将服务端进入阻塞状态，等待连接
				System.out.println("一個客戶端連接成功：。。。");
				
			ClientHandler handler = new ClientHandler(socket);//當有客戶端連接時創建與客戶端交互的線程
			Thread t =  new Thread(handler);
			t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Server s = new Server();
		s.Start();

	}
	/*
	 * 內部類:創建滿足服務端與客戶端交互的線程
	 */
	private  class  ClientHandler implements Runnable {
		private Socket socket;//創建用於分配的線程
		private String host;
		//private String host;
		
		public ClientHandler(Socket socket) {
			super();
			this.socket = socket;
			InetAddress address = socket.getInetAddress();//socket通過InetAddress方法獲取地址信息
			host = address.toString();//將地址信息轉化爲String類型
		}
		public void run() {//重寫run方法，滿足線程的規定
			PrintWriter pw = null;
		try {
			//接收服务端发送来的消息
			InputStream in = socket.getInputStream();//線程開始創建接收信息字節輸入流
			InputStreamReader isr = new InputStreamReader(in,"UTF-8");//將字節輸入流轉換爲字符輸入流
			BufferedReader br = new BufferedReader(isr);//缓冲字符输入流
		//	String line = br.readLine();
		//	System.out.println("host:"+host+"說:"+line);
			//向客户端发送接收到的消息 
			OutputStream out = socket.getOutputStream();//创建字节输出流，用以发送消息
			OutputStreamWriter  osr = new OutputStreamWriter(out,"UTF-8");//将字节输出流转换为字符输出流
			BufferedWriter bw = new BufferedWriter(osr);//缓冲字符输出流
			pw  = new PrintWriter(bw,true);//自动行刷新的输出
			
			synchronized(allOut) {
				allOut = Arrays.copyOf(allOut, allOut.length+1);//数组进行扩容
				allOut[allOut.length-1]=pw;//将当前输出流装载进数组
				String line =null;
				while((line=br.readLine()) != null) {///如果接收到内容就转发给客户端 
					//pw.println(host+"说："+br.readLine());//直接转发会因为线程冲突问题，无法正确发送
					System.out.println("host:"+host+"說:"+line);//向服务端控制台输出客户端发送的数据
					for (int i = 0; i < allOut.length; i++) {//遍历数组获得输出数据
						allOut[i].println(host+"说："+line);
					}
				}
			}
			
		//	pw.println(br.readLine());//输出内容
		} catch (Exception e) {
			e.printStackTrace();
		}finally {//处理客户端断开连接后的操作
			for (int i = 0; i < allOut.length; i++) {
				if(allOut[i] == pw) {
					allOut[i] = allOut[allOut.length-1];
					break;
				}
			}
			allOut = Arrays.copyOf(allOut,allOut.length-1);
		}
			
		}
	
	}

}
 
