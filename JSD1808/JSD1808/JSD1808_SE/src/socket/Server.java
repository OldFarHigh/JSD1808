package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
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
 */
public class Server {
	/*
	 * 运行在服务端的java.net.ServerSocket
	 * 主要有两个作用：
	 * 1：向系统申请服务端口，客户端就是通过该端口与服务端建立连接的。、
	 * 2：监听服务端口，一旦客户端发起连接则会自动创建一个Socket与该客户端进行交互。
	 */
	private ServerSocket server;
	/*
	 * 创建数组用于保存所有ClientHandler对应的输出流，便于所有ClientHandler获取，
	 * 以广播消息给所有的客户端
	 * 由于内部类可以访问外部类的属性，对此经常可以在外部类上定义属性
	 * 作为所有内部类的公共区域来共享它们的信息使用。
	 */
	private PrintWriter[] allOut = {};
	/**
	 * 构造方法：初始化服务端
	 */
	public Server() {
		try {
			/*
			 * 实例化ServerSocket的同时向系统申请服务端口。
			 * 若端口已经被其他应用程序所占用时会抛出地址被使用的异常。
			 */
			System.out.println("正在启动服务端。。。。");
			server = new ServerSocket(8088);
			System.out.println("服务端启动完毕。。。。");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 服务端开始工作的方法
	 */
	public  void start() {
		try {
			/*
			 * Socket accept()
			 * 该方法是一个阻塞方法，当调用后就开始等待客户端的连接，直到一个客户端连接，
			 * 那么该方法会返回一个socket，服务端可以通过这个Socket与刚建立连接的客户端进行交互。
			 * 
			 */
			while(true) {
				System.out.println("主线程：等待客户端连接。。。。");
				Socket socket = server.accept();
				System.out.println("主线程：一个客户端连接了！");	
				
				//启动一个线程来处理该客户端交互
				ClientHandler  handler = new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
			
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}

	/**
	 * 该线程的任务为与指定客户端进行交互
	 * @author OldFarHigh
	 */
	 private class ClientHandler implements Runnable{
		 private Socket socket;//分配线程
		 private String host;//客户端的地址信息
		 public ClientHandler(Socket socket) {
			 this.socket = socket;
			InetAddress address =  socket.getInetAddress(); //通过Socket获取远端计算机地址信息
			host = address.getHostAddress();//获取远端计算机IP地址的字符串形式
		 }
		 public void run() {//重写run方法
			 PrintWriter pw = null;
			 try {
				 //通过Socket获取输出流，用于给客户端发送消息
				 OutputStream out = socket.getOutputStream();
				 OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
				 BufferedWriter bw = new BufferedWriter(osw);
				 pw = new PrintWriter(bw,true);
				 /*
				  * 多個ClientHandler不能同時向數組添加元素否則會出現併發安全問題。
				  * 對此，下面的代碼要保證同步運行.
				  */
				 synchronized(allOut) {
					// 将该输出流存入allOut数组中，以便其他ClientHandler也可以将消息转发给的当前客户端
					 allOut = Arrays.copyOf(allOut, allOut.length+1);//数组扩容
					 allOut [allOut.length-1] = pw;//将当前输出流存入数组
				 }
				
				 /*
					 * 通过Socket获取输入流
					 * InputStream getInputStream（）
					 * 通过这个流就可以读取客户端发送过来的消息
				 */
					InputStream in = socket.getInputStream();//字节输入流，接收发送的数据
					InputStreamReader isr = new InputStreamReader(in,"UTF-8");//转换流，字符流读取数据，定义字符集
					BufferedReader br = new BufferedReader(isr);//缓冲字符输入流
					
					
					/*
					 * 服务端通过br.readLine方法读取客户端发送过来的一行字符串时，当客户端断开连接时，
					 * 客户端在不同的操作系统上，服务端这边的反应是不同的：
					 * 在windows的客户端断开连接时，服务端这边通常readLine方法会直接抛出异常
					 * 在linux的客户端断开连接时，服务端这边的常见反应是readLine方法返回为null
					 */
					String line =null;
					while((line = br.readLine() )!= null  ) {
						System.out.println("host"+host+"说："+line);
						//	pw.println(host+"说："+line);//回复客户端
						synchronized(allOut) {
							for (int i = 0; i < allOut.length; i++) {//遍历数组获取某个客户端发送的数据，向所有客户端转发
								allOut[i].println(host+"说："+line);
							}
						}
						
					}	
					
			} catch (Exception e) {
				e.printStackTrace();
			}finally {//处理当前客户端断开连接后的操作
				//將該PW從數組中刪除
				synchronized(allOut) {
					for (int i = 0; i < allOut.length; i++) {//遍歷allOut數組，獲得pw數據
						if(allOut[i]==pw) {//數據吻合
							allOut[i] =allOut[allOut.length-1];//將其與最後一個元素交換
							break;//跳出遍歷
						}
					}
					allOut = Arrays.copyOf(allOut, allOut.length-1);//縮容
				}
				
				//System.out.println("有一個人退出了");//打粧： 告知服務端
				try {
					socket.close();//關閉socket釋放資源   
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			 }
		 }
}