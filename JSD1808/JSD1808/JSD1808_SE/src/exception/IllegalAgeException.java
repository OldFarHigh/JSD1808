package exception;
/**
 * 自定义异常
 * 
 * 自定义异常通常用来说明业务逻辑异常
 * 
 * 年龄不合法的异常
 * @author OldFarHigh
 *
 */
public class IllegalAgeException  extends Exception{

	/**
	 * 生成序列化的版本号
	 */
	private static final long serialVersionUID = 1L;

	public IllegalAgeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
