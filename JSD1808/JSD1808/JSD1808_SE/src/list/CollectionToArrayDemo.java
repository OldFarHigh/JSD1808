package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Collection中提供了一个方法：toArray
 * 可以将当前集合转换为一个数组
 * @author OldFarHigh
 *
 */
public class CollectionToArrayDemo {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		System.out.println(c);//[one, two, three, four]
		
	//	Object[] array = c.toArray();//数组的元素类型和集合的元素类型不一致，所以不常用
		
		String[] array = c.toArray(new String[c.size()]);//<T> T[] toArray(T[] a)
		System.out.println(array.length);//4
		System.out.println(Arrays.toString(array));//[one, two, three, four]
	}
}
