package com.webserver.http;
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
 * HTTP协议相关信息定义。
 * 获取mime类型的方法
 * @author OldFarHigh
 * 
 * 
 * 
 *html  text/html
 *png   image/png
 *jpg    image/jpeg
 *gif     image/gif
 *css    text/css
 *js	   application/javascript
 */
public class HttpContext {
//	public static void main(String[] args) {
//		String fileName = "header.css";
//	//根据文件名的后缀，获取对应的mime类型
//		String[] arr = fileName.split("\\.");//以 。为拆分符
//		System.out.println(arr.length);//输出拆分后数组的长度
//		String file = arr[1];	
//		String Type = getMimeType(file);
//		System.out.println(Type);
//}
	/**
	 * 介质类型映射
	 * key:资源后缀名
	 * value：对应的mime类型定义（Content-Type对应的值）
	 */
	private static Map<String,String> mimeTypeMapping = new HashMap<String,String>();
	/**
	 * 状态代码与描述的映射
	 * key：状态代码
	 * value：状态描述
	 */
	private static Map<Integer,String> statusCodeReasonMapping = new HashMap<Integer,String>(); 
	
	static {
		//初始化静态资源
		//1、初始化mime类型的映射
		initMimeTypeMapping();
		//2、初始化状态代码与描述的映射
		initStatusCodeReasonMapping();
	}
	/**
	 * 根据资源后缀获取对应的mime类型
	 * @param ext
	 * @return
	 */
	public static String getMimeType(String ext) {
		return mimeTypeMapping.get(ext);
	}
	/**
	 * 根据给定的状态代码获取其对应的状态描述
	 * @param statusCode
	 * @return
	 */
	public static String getStatusReason(int statusCode) {
		return statusCodeReasonMapping.get(statusCode);
	}
	
	/*
	 * 用于初始化mime类型的映射
	 */
	private static void initMimeTypeMapping() {
		/*
		 * 初始化过程
		 * 1：解析conf/web.xml
		 * 2：获取该文件中根标签下所有名为<mime-mapping>的子标签
		 * 		 注意：根标签下不止有<mime-mapping>名字的子标签，还有其他的。
		 * 		 所以获取所有字标签时，必须指定名字
		 * 3：遍历每一个<mime-mapping>中间的文本作为key，
		 * 		 将其子标签<extension>中间的文本作为key。
		 * 		 将其子标签<mime-type>中间的文本作为value。
		 * 		 存入到mimeTypeMapping这个Map中完成初始化。
		 * 
		 * 解析后该mimeTypeMapping中应当有1000多个元素。
		 */
		try {
			SAXReader reader = new SAXReader();//创建SAXReader
			Document doc = reader.read(new FileInputStream("conf/web.xml"));//读取指定文件conf/web.xml
			Element root = doc.getRootElement();//获取根标签
			List<Element> emplist = root.elements("mime-mapping");//获取根标签下名为“mime-mapping”的子标签
			//遍历所有的子标签
			for (Element empEle : emplist) {
//				Element extensionEle = empEle.element("extension");
//				String extension  = extensionEle.getTextTrim();//获取子标签<extension>中间的文本
//				Element mimeEle = empEle.element("mime-type");
//				String mime = mimeEle.getText();//获取子标签<mime-type>中间的文本
				String extension = empEle.elementText("extension");//获取子标签<extension>中间的文本字符串赋给extension
				String mime = empEle.elementText("mime-type");//获取子标签<mime-type>中间的文本字符串赋给mime
				mimeTypeMapping.put(extension, mime);
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 初始化状态代码与描述的映射
	 */
	private static void initStatusCodeReasonMapping() {
		statusCodeReasonMapping.put(200, "ok");
		statusCodeReasonMapping.put(201,"Created");
		statusCodeReasonMapping.put(202, "Accepted");
		statusCodeReasonMapping.put(204,"NO Content");
		statusCodeReasonMapping.put(301, "Moved Permanently");
		statusCodeReasonMapping.put(302,"Moved Temporarily");
		statusCodeReasonMapping.put(304,"Not Modified");
		statusCodeReasonMapping.put(400,"Bad Request");
		statusCodeReasonMapping.put(401,"Unauthorized");
		statusCodeReasonMapping.put(403,"Forbidden");
		statusCodeReasonMapping.put(404,"Not Found");
		statusCodeReasonMapping.put(500,"Internal Server Error");
		statusCodeReasonMapping.put(501,"Not Implemented");
		statusCodeReasonMapping.put(502," Bad Gateway");
		statusCodeReasonMapping.put(503,"Service Unavailable");
		
	}
}
