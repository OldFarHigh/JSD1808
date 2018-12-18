package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 泛型应用最广泛的地方就是集合，而集合中使用泛型是用来约束集合的元素类型
 * @author OldFarHigh
 *
 */
public class CollectionDemo4 {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String> ();
		c.add("1");
		c.add("2");
		c.add("3");
		c.add("4");
		System.out.println(c);
		
		for (String string : c) {
			System.out.println(string);
		}
		
		//迭代器指定的泛型与其遍历的集合指定的泛型一致即可
		Iterator<String>  it = c.iterator();
		while(it.hasNext()) {
			String str = it.next();
			System.out.println("Iterator:"+str);
		}
	}
}
