 package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


/**
 * 聊天室客户端
 * @author OldFarHigh
 *
 */
public class Client {
	/**
	  * java.net.Socket
	  * 封装了TCP通讯协议的细节操作。
	  *  java中完成TCP协议通讯就依靠这个API即可，使用它与服务端链接后，
	  *  通过操作两个流即可完成与服务端的数据交换
	  */
	private Socket socket;
	/**
      * 构造方法，用来初始化客户端
      */
	public Client() {
		try {
			/*
			 * 实例化Socket时传入两个参数
			 * 1：服务端的IP地址信息
			 * 2：服务端的服务端口号
			 * 
			 * 通过IP地址可以找到服务端的计算机，通过端口号可以找到运行在服务端机器上的服务端应用程序
			 * 
			 * 实例化的过程就是连接的过程，若连接失败会抛出异常。
			 */
			System.out.println("正在连接服务器。。。。。。");
			socket = new Socket("172.18.35.2",8088);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 客户端开始工作的方法
	 */
	public void start(){	
		try {
			//先启动用于读取服务端消息的线程
			ServerHandler handler = new ServerHandler();
			Thread t = new Thread(handler);
			t.start();
			Scanner sc = new Scanner(System.in);
			/*
			 * sccket提供的方法：
			 * OutputStream getOutputStream()
			 * 该方法可以获取一条字节输出流，通过这个流写出的数据会被发送给远端
			 * （这里相当于发送给了服务端）
			 * 
			 */
			OutputStream out = socket.getOutputStream();//字节输出流，获取输出的数据
			OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");//转换输出流，指定字符集，确保发送的准确性
			BufferedWriter bw = new BufferedWriter(osw);//缓冲字符输出流
			PrintWriter pw = new PrintWriter(bw,true);//按行输出字符，true自动行刷新
			
			
			//pw.println("老法海进入聊天室！");//向服务端输出一句话
			
			
		//	sc.close();
			while(true) {
			//	System.out.println("请输入您要发送的内容：");
				String line  = sc.nextLine();
				pw.println(line);//向服务端输出信息
				sc.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Client client = new Client();
		client.start();
	}
	/*
	 * 该线程负责循环读取服务端发送过来的消息
	 */
	private class ServerHandler implements Runnable{
		public void run() {
			try {
				//通过Socket获取输入流读取服务端发送过来的消息
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in,"UTF-8");
				BufferedReader br = new BufferedReader(isr);
				
				String message = null;
				while((message = br.readLine())!=null) {//循环读取服务端发送过来的每行字符串
					System.out.println(message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
