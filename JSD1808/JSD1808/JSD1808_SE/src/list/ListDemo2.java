package list;

import java.util.ArrayList;
import java.util.List;

/**
 * List提供了一对重载的add，remove方法。都是支持通过下标操作对应元素
 * 
 * void add(int index,E e):在指定位置插入给定元素
 * E remove(int index):删除并返回指定位置的元素
 * @author OldFarHigh
 *
 */
public class ListDemo2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		System.out.println(list);//[1, 2, 3]
		/*
		 * void add(int index,E e):在指定位置插入给定元素
		 */
		list.add(0, "null");
		list.add("not null");//不指定位置，默认在末尾添加
		System.out.println(list);//[null, 1, 2, 3]
		
		/*
		 * E remove(int index):删除并返回指定位置的元素
		 */
		String old = list.remove(0);
		System.out.println(list);
		System.out.println("被删除的元素是:"+old);
	}
}
