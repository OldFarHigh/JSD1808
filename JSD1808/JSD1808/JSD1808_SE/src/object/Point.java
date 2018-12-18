package object;
/**
 * Object是所有类的超类
 * 
 * 使用Point测试Object常见方法的重写
 * @author OldFarHigh
 *
 */
public class Point {//点
	private int x;
	private int y;
	
	
	public Point(int x, int y) {//构造方法
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * 重写toString 方法，方法应当包含当前对象的属性信息，
	 * 格式可以根据实际开发需求而定
	 */
	public String toString() {
		//（1，2）
		return "("+x+","+y+")" ; 
	}
	/**
	 * 重写equals方法
	 * equals的设计目的是比较对象的内容是否相同。
	 * 而这里的内容指的就是对象中的属性。
	 * 大部分情况下比较属性时都是所有属性进行比较，
	 * 但是这不是强制要求，可结合实际开发需求而定。
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if(obj == this) {
			return true;
		}
		if(obj instanceof Point) {
			Point p = (Point) obj;
			return this.x==p.x &&this.y == p.y;
		}
		return false;
	}
	
}
