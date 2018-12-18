package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转换为集合
 * 数组的工具类Arrays提供了一个静态方法：asList
 * 可以将一个数组转换为一个List集合,不能转为set集合，因为set集合是不能存储重复数据的
 * @author OldFarHigh
 */
public class ArrayToListDemo {
	 public static void main(String[] args) {
		String[] arr = {"a","b","c","d"};
		System.out.println("arr:"+Arrays.toString(arr));
		/*
		 * 通过Arrays的asList将数组转换的集合表示的就是该数组，
		 * 所以对集合元素操作就是对该数组元素操作
		 */
		List<String> list = Arrays.asList(arr);
		System.out.println(list);
		
		list.set(1, "2");
		System.out.println("list:"+list);//list:[a, 2, c, d]
		System.out.println("Array:"+Arrays.toString(arr));//Array:[a, 2, c, d]
		/*
		 * 由于数组是定长的，所以该集合不可以增删元素
		 */
//		list.add("2");
//		System.out.println("list:"+list);
//		System.out.println("Array:"+Arrays.toString(arr));//列表不支持 add 操作 Exception:java.lang.UnsupportedOperationException
		/*
		 * 若希望对该集合进行增删操作，则需要自行创建一个集合并导入该集合元素
		 */
//		List<String> list2 = new ArrayList<String>();
//		list2.addAll(list);
		/*
		 * 所有的集合都支持一个参数为Collection的构造方法
		 * 作用是在创建当前集合的同时包含给定集合中的所有元素
		 */
		List<String> list2 = new ArrayList<String>(list);
		
		System.out.println("list2:"+list2);//list2:[a, 2, c, d]
		list2.add("five");
		System.out.println("list2:"+list2);//list2:[a, 2, c, d, five]
		
		
	}
}
