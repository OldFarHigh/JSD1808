package chat;


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
 *通过 socket 进行服务端与客户端的通讯
 *
 *第一天：客戶端向服務端發送消息
 *滿足連接客戶端後，可以正常向服務端發送（輸出流）
 *第二天：客戶端接收
 *在控製臺輸入內容，發送到服務端
 *從服務端接收消息內容
 */
public class Client {
	Scanner sc = new Scanner(System.in);
	private Socket socket;//声明变量：传输的数据
	/*
	 * 对客户端进行初始化操作，实例化socket
	 */
	public Client() {//构造方法：用来进行初始化
		try {//通过try-catch捕获异常，必备的操作
			System.out.println("连接服务端。。");//打桩操作，正确运行
			 socket = new Socket("localhost",8088);//实例化Socket，传入服务端的地址，服务端的端口
			 System.out.println("连接成功。。");
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * 
	 */
	public void  Start() {
		try {
			ServerHandler sh = new ServerHandler();//创建线程方法
			Thread t = new Thread(sh);//加载进线程
			t.start();//启动线程
			OutputStream out = socket.getOutputStream();//字節輸出流
			OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");//轉換流，將字節流轉換爲字符流
			BufferedWriter br = new BufferedWriter(osw);//緩衝字符輸出流（輸出過程中，只有滿足一定數量的內容纔會輸出）
			PrintWriter pw = new PrintWriter(br,true);//連接在緩衝字符輸出流的自動行刷新的緩衝字符流
			
			
			//pw.println("HelloWorld!");//向服務端发送数据
			
			while(true) {
				System.out.println("请输入您要发送的数据：");
				String str = sc.nextLine();//控制臺輸入信息
				pw.println(str);//向服務端發送数据
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
			Client c = new Client();
			c.Start();
	}
	private class ServerHandler implements Runnable{//内部类创建线程接收服务器的返回消息
		public void run() {
			try {
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in,"UTF-8");
				BufferedReader br = new BufferedReader(isr);
				
				String message = null;
				while((message = br.readLine())!=null) {
					System.out.println("服务器返回："+message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}


