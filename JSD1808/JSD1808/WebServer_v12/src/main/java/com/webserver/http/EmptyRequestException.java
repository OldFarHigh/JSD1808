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
		
	}

	public EmptyRequestException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmptyRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyRequestException(String message) {
		super(message);
	}

	public EmptyRequestException(Throwable cause) {
		super(cause);
	}
}
