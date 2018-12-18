package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 刪除集合元素
 * @author OldFarHigh
 *
 */
public class RemoveDemo {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(2,3));
		c.add(new Point(3,4));
		c.add(new Point(4,5));
		c.add(new Point(5,6));
		System.out.println(c);
		
		Point p = new Point(1,2);
		/*
		 * remove()方法刪除元素時是刪除與給定元素equals比較爲true的元素。
		 * 注意：List集合而言，若存在重複元素，只刪除一個。
		 */
		c.remove(p);
		System.out.println(c);
	}
}
