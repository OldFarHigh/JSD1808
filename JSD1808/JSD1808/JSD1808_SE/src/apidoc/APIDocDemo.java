package apidoc;
/**
 *在类上面写文档注释,是用来说明当前类的设计目的,功能
 * @author OldFarHigh
 * @version 1.0	
 * @see	java.lang.String
 * @since JDK1.0
 *
 */
public class APIDocDemo {
	/**
	 * sayHello中使用的问候语
	 */
	public static final String INFO = "hello";
	/**
	 * 对给定用户添加问候语
	 * @param name 给定的用户名
	 * @return 添加了问侯语的字符串
	 */
	public String  sayHello(String name) {
		return "你好"+name;

	}

}
