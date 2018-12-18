package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合存放的是元素的引用
 * @author OldFarHigh
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection<Point>  c = new ArrayList<Point>();
		Point p = new Point(1,2);
		
		c.add(p);
		
		System.out.println("p:"+p);//p:(1,2)
		System.out.println("c:"+c);//c:(1,2)
		
		p.setX(2);
		
		System.out.println("p:"+p);//p:(2,2)
		System.out.println("c:"+c);//c:(2,2)
		
		
	}
}
