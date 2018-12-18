package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie工具类
 * 封装
 * 		1）添加cookie的方法
 * 		2）删除cookie的方法
 * 		3）查询cookie的方法
 * @author OldFarHigh
 *
 */
public class CookieUtil {
	/**
	 * 添加cookie的方法
	 * @param name
	 * @param value
	 * @param age
	 * @param path
	 * @throws UnsupportedEncodingException 
	 */
	public static void addCookie(String name,String value,int age,String path,HttpServletResponse response) throws UnsupportedEncodingException {
		Cookie c = new Cookie(name,URLEncoder.encode(value,"UTF-8"));
		c.setMaxAge(age);
		c.setPath(path);
		response.addCookie(c);
	}
	/**
	 * 删除cookie的方法
	 * @param name
	 * @param response
	 * @param path
	 */
	public static void deleteCookie(String name,HttpServletResponse response,String path){
		Cookie c  = new Cookie(name,"");
		c.setMaxAge(0);
		c.setPath(path);
		response.addCookie(c);
	}
	/**
	 * 查询给定name的value值
	 * @param name
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String findCookie(String name,HttpServletRequest request) throws UnsupportedEncodingException {
		String value =null;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(Cookie c : cookies) {
				if(c.getName().equals(name)) {
					value = URLDecoder.decode(c.getValue(),"UTF-8");
				}
			}
		}
		return value;
	}
}
