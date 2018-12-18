package list;

import java.util.ArrayList;
import java.util.List;

/**
 * java.util.List
 * List接口是Collection的一个子接口，称为线性表
 * 
 * List集合的特点：可以重复，是有序的。提供了一组通过下标操作元素的方法
 * 常见实现类：
 * java.util.ArrayList:数组实现，查询性能更好
 * java.util.LinkedList:链表实现，增删元素性能更好，尤其是首尾增删元素效果更佳
 * @author OldFarHigh
 *
 */
public class ListDemo1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		System.out.println("list："+list);
		/*
		 * E get(int index)： 获取给定下标的元素
		 */
		String str = list.get(0);
		System.out.println("list"+"[0]："+str);
		for (int i = 0; i < list.size(); i++) {
			str = list.get(i);
			System.out.println("list"+"["+i+"]:"+str);
		}
		/*
		 * E set(int index ,E element)
		 * 将给定元素设置到指定位置，返回值为原位置对应的元素（被替换的元素）
		 * [1, 2, 3, 4, 5]
		 * [one, 2, 3, 4, 5]
		 */
		String old =list.set(0, "one");
		System.out.println(list);//[one, 2, 3, 4, 5]
		System.out.println(old);//1
		
	}
}
