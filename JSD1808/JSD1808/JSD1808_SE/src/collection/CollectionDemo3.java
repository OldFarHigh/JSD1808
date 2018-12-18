package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 *集合操作：
 *boolean addAll(Collection<? extends E> c): 将给定集合中的所有元素添加到当前集合中
 *boolean containsAll(Collection<?> c):判断当前集合是否包含给定集合的所有元素
 *boolean removeAll(Collection<?> c):从当前集合中删除与给定集合共有的元素
 * @author OldFarHigh
 *
 */
public class CollectionDemo3 {
	public static void main(String[] args) {
		Collection<String> c1 = new ArrayList<String>();
		c1.add("java");
		c1.add("c");
		c1.add("c++");
		System.out.println("c1:"+c1);//c1:[java, c, c++]
		
		Collection<String> c2 = new HashSet<String>();//无序集
		c2.add("android");
		c2.add("ios");
		c2.add("java");
		System.out.println("c2："+c2);//c2:[java, android, ios]
		/*
		 * 将给定集合中的所有元素添加到当前集合中，类似于集合的并集
		 */
//		c2.addAll(c1);//如果是set集合中添加重复元素，会自动忽略重复元素
//		System.out.println("c2:"+c2);//c2:[c++, java, c, android, ios]
		c1.addAll(c2);
		System.out.println("c1:"+c1);//c1:[java, c, c++, java, android, ios]
		
		Collection<String> c3 = new ArrayList<String>();
		c3.add("java");
		c3.add("c++");
		System.out.println("c3:"+c3);
		/*
		 * 判断当前集合是否包含给定集合的所有元素
		 */
		boolean cl = c1.containsAll(c3);
		System.out.println("c1全包含c3:"+cl);//c1全包含c3:true
		/*
		 * 删除交集：从当前集合中删除与给定集合中的共有元素
		 */
		c1.removeAll(c2);
		System.out.println("c1:"+c1);//c1:[c, c++]
//		c1.removeAll(c3);
//		System.out.println("c1:"+c1);//c1:[c, android, ios]
		
	}
}
