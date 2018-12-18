package com.webserver.core;

import java.io.File;
import java.io.IOException;
import java.net.Socket;

import com.webserver.http.EmptyRequestException;
import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;
import com.webserver.servlets.HttpServlet;
import com.webserver.servlets.LoginServlet;
import com.webserver.servlets.RegServlet;
import com.webserver.servlets.ShowAllUserServlet;
/**
 * ����ͻ��˽���
 * @author ta
 *
 */
public class ClientHandler implements Runnable{
	private Socket socket;
	
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			//1׼������
			//1.1��������
			HttpRequest request = new HttpRequest(socket);
			//1.2������Ӧ
			HttpResponse response = new HttpResponse(socket);
			
			//2��������
			/*
			 * 2.1:ͨ��request��ȡ�������Դ·��
			 * 2.2:�жϸ������Ƿ�Ϊ����һ��ҵ�񣬲�����ִ��2.3
			 * 2.3:��webappsĿ¼�и�����Դ·��λ��Ѱ�� 
			 *     �������Դ�Ƿ����
			 */
			//2.1
			String uri = request.getRequestURI();
			
			
			//2.2
			//�鿴�������Ƿ�Ϊҵ��
//			if("/myweb/reg".equals(uri)) {//�鿴�������Ƿ�Ϊһ��ע��ҵ��
//				RegServlet servlet = new RegServlet();
//				servlet.service(request, response);//�������ҵ��
//				//System.out.println("����ע�ᣡ��������");
//			}else if("/myweb/login".equals(uri)) {//�鿴�����Ƿ�Ϊһ����¼ҳ��
//				System.out.println("��ʼ�����¼ҵ�񡣡���������");
//				LoginServlet servlet =new LoginServlet();
//				servlet.service(request, response);//��������¼ҵ��
//				System.out.println("�����¼ҵ����ɡ�������������");
			String servletName = ServerContext.getServletNameByUri(uri);
			if(servletName != null) {
				System.out.println("׼�����䣺"+servletName);
				Class cls = Class.forName(servletName);
				HttpServlet servlet = (HttpServlet)cls.newInstance();
				servlet.service(request, response);
			}else {
				//2.3
				File file = new File("webapps"+uri);
				//�ж��û��������Դ�Ƿ����?
				if(file.exists()) {
					System.out.println("����Դ���ҵ�!");
					//������Դ��Ӧ���ͻ���
					response.setEntity(file);					
				}else {
					System.out.println("����Դ������!");
					response.setStatusCode(404);
					response.setEntity(new File("webapps/root/404.html"));
				}	
			}
			//3��Ӧ�ͻ���
			response.flush();
			
		} catch (EmptyRequestException e) {
			System.out.println("������");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//��Ӧ��Ϻ���ͻ��˶Ͽ�����!
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}




