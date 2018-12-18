package dayTest_1029;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 解析浏览器发送来的请求
 * @author OldFarHigh
 *
 */
public class HttpRequest {
	private Socket socket;
	private InputStream in;
	//请求行的属性
	private String method;
	private String url;
	private String porotol;
	//消息头的属性
	private Map<String,String> headers = new HashMap<String,String>();
	//消息正文的属性
	
	public HttpRequest(Socket socket) {
		try {
			this.socket = socket;
			this.in =socket.getInputStream();
			parseRequestLine();
			parseHeaders();
			parseContent();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void parseRequestLine() {//私有方法，仅用于服务端自身解析操作。解析请求行
		System.out.println("开始解析请求行。。。。");
		try {
			String line = readLine();
			System.out.println("请求行："+line);
			String[] arr = line.split("\\s");
			this.method = arr[0];
			this.url = arr[1];
			this.porotol = arr[2];
			System.out.println("method:"+method);
			System.out.println("url:"+url);
			System.out.println("porotol:"+porotol);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("解析请求行完毕！");

	}
	private void parseHeaders() {//解析消息头
		System.out.println("开始解析消息头。。");
		try {
			while(true){
				String line = readLine();
				if("".equals(line)) {
					break;
				}
				String[] data = line.split(":\\s");
				headers.put(data[0], data[1]);
			}
			System.out.println("headers:"+headers);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("解析消息头完毕");
	}
	private void parseContent() {//解析消息正文
		System.out.println("开始解析消息正文。。");
		try {
			String line = readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("解析消息正文完毕！");
	}
	public String readLine() throws IOException {
		int d = -1;
		char c1='a',c2='a';
		StringBuilder builder = new StringBuilder();
		while((d=in.read()) != -1) {
			c2=(char)d;
			if(c1==13&&c2==10) {
				break;
			}
			builder.append(c2);
			c1=c2;
		}
		return builder.toString().trim();
	}
	public String getMethod() {
		return method;
	}
	public String getUrl() {
		return url;
	}
	public String getPorotol() {
		return porotol;
	}
	public String  getHeaders(String name) {
		return headers.get(name);
	}
	
}
