package cn.tedu.spring;


/**
 * 当没有显式的添加构造方法时
 * 编译器会自动添加公有的、无参数的构造方法。
 * 反之，当已经显式的添加构造方法时
 * 编译器不会另行添加任何构造方法
 * @author OldFarHigh
 *
 */
	public class User {

	public User() {
		super();
	}
	public User(Object obj) {
		
	}
}
