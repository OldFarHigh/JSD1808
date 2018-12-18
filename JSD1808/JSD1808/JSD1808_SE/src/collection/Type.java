package collection;
/**
 * 泛型、
 * JDK5推出的一个特性，又称为参数化类型。
 * 允许使用者在使用一个类的时候指定其定义的属性，方法的参数以及返回值的类型。
 * 这样可以使得程序使用更灵活
 * @author OldFarHigh
 *
 */
public class Type<E> {
	/*
	 * 实际上编译后，Type类型名后面没有<E>
	 * 而：
	 * private E x;
	 * 会被改为
	 * private Object x;
	 */
	private E x;
	private E y;
	/*
	 * 参数也会改为：
	 * public Type(Object x , Object y){}
	 * 
	 * 下面的方法同理，返回值若是E，也会被改为Object
	 * 
	 */
	public Type(E x, E y) {
		super();
		this.x = x;
		this.y = y;
	}
	public E getX() {
		return x;
	}
	public void setX(E x) {
		this.x = x;
	}
	public E getY() {
		return y;
	}
	public void setY(E y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Type [x=" + x + ", y=" + y + "]";
	}
	
}
