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
	//public static void main(String[] args) {
	//	String fileName = "header.css";
		//根据文件名的后缀，获取对应的mime类型
		
		//String Type =getMimeType(ext);
		//System.out.println(Type);
	//	String[] arr = fileName.split("\\.");
	//	System.out.println(arr.length);
	//	String file = arr[1];	
//		String Type = getMimeType(file);
//		System.out.println(Type);
//	}
	/**
	 * 介质类型映射
	 * key:资源后缀名
	 * value：对应的mime类型定义（Content-Type对应的值）
	 */
	private static Map<String,String> mimeTypeMapping = new HashMap<String,String>();
	
	static {
		//初始化静态资源
		//1、初始化mime类型
		initMimeTypeMapping();
	}
	private static void initMimeTypeMapping() {
//		mimeTypeMapping.put("html","text/html");
//		mimeTypeMapping.put("png", "image/png");
//		mimeTypeMapping.put("jpg", "image/jpeg");
//		mimeTypeMapping.put("gif", "image/gif");
//		mimeTypeMapping.put("css", "text/css");
//		mimeTypeMapping.put("js", "application/javascript");
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
	 * 根据资源后缀获取对应的mime类型
	 * @param ext
	 * @return
	 */
	public static String getMimeType(String ext) {
		
		return mimeTypeMapping.get(ext);
	}
}
