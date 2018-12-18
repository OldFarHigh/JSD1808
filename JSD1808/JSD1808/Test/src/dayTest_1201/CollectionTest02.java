package dayTest_1201;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合存放的是元素的引用
 * @author OldFarHigh
 *
 */
public class CollectionTest02 {
	public static void main(String[] args) {
		Collection<Point> c = new ArrayList<Point>();
		Point  p = new Point(1,2);
		c.add(p);
		System.out.println("c:"+c);//[Point [x=1, y=2]]
		System.out.println("p:"+p);//Point [x=1, y=2]
		
		p.setX(2);
		
		System.out.println("c:"+c);//c:[Point [x=2, y=2]]
		System.out.println("p:"+p);//p:Point [x=2, y=2]
		
	}
}
