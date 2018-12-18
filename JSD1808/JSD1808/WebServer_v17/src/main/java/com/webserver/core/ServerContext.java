package com.webserver.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 *����������Ϣ����
 * @author OldFarHigh
 *
 */
public class ServerContext {
	/*
	 * Servletӳ��
	 * key����Ӧ��uri·��
	 * value������������Servlet������
	 */
	private static Map<String,String> servletMapping = new HashMap<String,String>();
	static {
		initServletMapping();
	}
	/*
	 * ��ʼ��Servletӳ��
	 */
	private static  void initServletMapping() {
//		servletMapping.put("/myweb/reg", "com.webserver.servlets.RegServlet");
//		servletMapping.put("/myweb/login", "com.webserver.servlets.LoginServlet");
//		servletMapping.put("/myweb/showAllUser", "com.webserver.servlets.ShowAllUserServlet");
		/*
		 * ����conf/sevlets.xml�ļ�
		 * ����Ԫ���е�����<servlet>Ԫ�ػ�ȡ������������uri���Ե�ֵ��Ϊkey��
		 * ��class�����Ե�ֵ��Ϊvalue���浽servletMapping����ɳ�ʼ����
		 */
		
		try {
//			SAXReader read = new SAXReader();
//			Document doc = read.read(new FileInputStream("./conf/servlets.xml"));
//			Element root = doc.getRootElement();//��ȡ����ǩ
//			List<Element> servletlists =root.elements("servlet");//��ȡ�ӱ�ǩ
//			for (Element element : servletlists) {
//				String uri =element.attributeValue("uri");//��ȡuri���Ե�ֵ
//				String className =element.attributeValue("class");//��ȡclass���Ե�ֵ
//				servletMapping.put(uri, className);
//			}
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new FileInputStream("./conf/servlets.xml"));
			Element root = doc.getRootElement();
			List<Element> servlets = root.elements("servlet");
			for (Element element : servlets) {
				String uri = element.attributeValue("uri");
				String className = element.attributeValue("class");
				servletMapping.put(uri, className);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * ���ݸ�����uri��ȡ��Ӧ��Servlet��������������uri��Ч�򷵻�ֵΪnull
	 * @param uri
	 * @return
	 */
	public static String getServletNameByUri(String uri) {
		return servletMapping.get(uri);
	}
//	public static void main(String[] args) {
//		String  servletName = getServletNameByUri("/myweb/reg");
//		System.out.println("servletName:"+servletName);
//	}
}
