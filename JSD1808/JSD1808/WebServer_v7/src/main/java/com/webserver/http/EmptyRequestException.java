package com.webserver.http;
/**
 * 空请求异常
 * 当客户端发送空请求时，HttpRequest的构造方法会抛出该异常。
 * @author OldFarHigh
 *
 */
public class EmptyRequestException  extends Exception{
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;

	public EmptyRequestException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmptyRequestException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public EmptyRequestException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmptyRequestException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EmptyRequestException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
