package base.common;

import java.lang.reflect.Method;

/**
 * 该类封装了处理器及方法对象，目的是为了方便利用java反射去调用处理器的方法。
 * @author OldFarHigh
 *
 */
public class Handler {
	private Method mh;
	private Object obj;
	
	
	public Handler(Method mh, Object obj) {
		this.mh = mh;
		this.obj = obj;
		
	}
	public Method getMh() {
		return mh;
	}
	public Object getObj() {
		return obj;
	}
	public void setMh(Method mh) {
		this.mh = mh;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
}
