package list;

import java.util.ArrayList;
import java.util.List;

/**
 * List 提供获取子集的操作：
 * 
 * List subList(int start,int end)
 * 获取指定范围内的子集,含头不含尾
 * @author OldFarHigh
 *
 */
public class ListDemo3 {
	public static void main(String[] args) {
		List<Integer>  list  = new ArrayList<Integer>();
		for (int i = 0; i <10; i++) {
			list.add(i);
		}
		System.out.println(list);//[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		
		//获取3-7范围的
		List<Integer> sublist = list.subList(3, 8);
		System.out.println(sublist);//[3, 4, 5, 6, 7]
		
		/*
		 * 将自己元素各扩大10倍：【30，40，50，60，70】
		 */ 
		
		for (int i = 0; i < sublist.size(); i++) {
			sublist.set(i, sublist.get(i)*10);
		}
		System.out.println(sublist);
		/*
		 *对子集元素操作就是对原集合对应元素的操作
		 */
		System.out.println(list);
		/*
		 * 将list集合中2-8删除
		 */
		list.subList(2, 9).clear();
		System.out.println(list);
	}
}
