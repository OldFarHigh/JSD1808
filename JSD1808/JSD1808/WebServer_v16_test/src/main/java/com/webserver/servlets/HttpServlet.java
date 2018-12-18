package com.webserver.servlets;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

/**
 * 所有Servlet的超类
 * @author OldFarHigh
 *
 */
public  abstract class HttpServlet {
	public abstract void service(HttpRequest request,HttpResponse response);
}