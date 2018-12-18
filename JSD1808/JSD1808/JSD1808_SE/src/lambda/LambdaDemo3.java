package lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JDK8之后集合，Map推出了一个方法：foreach
 * 该方法可以使用lambda来遍历集合。
 * 由于该方法是集合自身的方法进行遍历，那么如果该集合是一个并发安全的集合时，
 * 这种遍历方法是可以和其他集合操作进行互斥的，达到并发安全。
 * 原迭代器方式是不与集合自身方法互斥的，需要自行维护并发安全问题。
 * @author OldFarHigh
 *
 */
public class LambdaDemo3 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		list.add("six");
		System.out.println(list);
		list.forEach((e)->System.out.println(e));
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("一", 1);
		map.put("二",2);
		map.put("三", 3);
		map.forEach((k,v)->System.out.println(k+":"+v));
		
	}
}
