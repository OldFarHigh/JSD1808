package com.webserver.http;
import java.util.HashMap;
import java.util.Map;

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
		String fileName = "header.css";
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
		mimeTypeMapping.put("html","text/html");
		mimeTypeMapping.put("png", "image/png");
		mimeTypeMapping.put("jpg", "image/jpeg");
		mimeTypeMapping.put("gif", "image/gif");
		mimeTypeMapping.put("css", "text/css");
		mimeTypeMapping.put("js", "application/javascript");
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
