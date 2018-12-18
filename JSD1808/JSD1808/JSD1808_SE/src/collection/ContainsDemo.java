package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合可以判斷是否包含給定元素，方法爲：
 * boolean contains(Object o)
 * 當包含給定元素時返回true
 * @author OldFarHigh
 *
 */
public class ContainsDemo {
	public static void main(String[] args) {
		Collection<Point>c = new ArrayList<Point>();
		c.add(new Point(1,2));
		c.add(new Point(2,3));
		c.add(new Point(3,4));
		c.add(new Point(4,5));
		c.add(new Point(5,6));
		System.out.println(c);
		
		Point p = new Point(1,2);
		/*
		 * 集合的contains方法判斷時式是使用元素equals的比較結果進行的
		 * 當給定元素與集合現有元素存在equals比較爲true的情況時便返回true
		 */
		boolean contains = c.contains(p);
		System.out.println("包含："+contains);
		
	}
}
