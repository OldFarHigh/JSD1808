package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie工具类，提供了一些方法，用于cookie的添加，查询和删除
 * @author OldFarHigh
 *
 */
public class CookieUtil {
	/**
	 * 封装的内容有：
	 * @param name
	 * @param value
	 * @param age
	 * @param path
	 * @param response
	 * @throws UnsupportedEncodingException
	 */
	public static void addCookie(String name,String value,
			int age,String path,HttpServletResponse response) 
					throws UnsupportedEncodingException {
		Cookie c = new Cookie(name,URLEncoder.encode(value,"UTF-8"));
		c.setMaxAge(age);
		c.setPath(path);
		response.addCookie(c);
	}
	/**
	 * 依据cookie的名称，读取cookie的值
	 * 如果找不到对应的cookie，返回null
	 * @param name
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String findCookie(String name,HttpServletRequest request) throws UnsupportedEncodingException {
		String value=null;
		Cookie[] cookies = request.getCookies();
		if(cookies !=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals(name)) {
					value = URLDecoder.decode(c.getValue(),"UTF-8");
				}
			}
		}
		return value;
	}
	public static void deleteCookie(String name,HttpServletResponse response,String path) {
		Cookie c = new Cookie(name,"");
		c.setMaxAge(0);
		c.setPath(path);
		response.addCookie(c);
	}
}
