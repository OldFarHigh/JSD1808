package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * @author OldFarHigh
 *
 */
public class Demo {
	public static void main(String[] args) {
		int a  = 1;
		String b = "hello";
		Point p = new Point(1,2);
		Collection<Point> c = new ArrayList<>();
		c.add(p);
		test(a,b,p,c);
		System.out.println(a);
		System.out.println(b);
		System.out.println(p);
		System.out.println(c);
		
		
		}
	public static void  test(int a ,String b ,Point p ,Collection<Point> c) {
		a = 2;
		b = b+"world";
	
		p.setX(a);
		c.clear();
		
		p = new Point(3,4);
		c.add(p);
		p.setX(5);
		c = new ArrayList<Point>();
		p = new Point(6,7);
		c.add(p);
		System.out.println("a:"+a);
		System.out.println(b);
		System.out.println(p);
		System.out.println(c);
	}
}
