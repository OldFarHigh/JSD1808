package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Collections提供了将现有的集合转换为并发安全的集合
 * SynchronizedList
 * @author OldFarHigh
 *
 */
public class SyncApiDemo {
		public static void main(String[] args) {
			/*
			 * 常见的集合
			 * ArrayList,LinkedList,HashList
			 * 它们都不是线程安全的，并发操作存在安全问题
			 */
			List<String> list = new ArrayList<String>();
			list.add("one");
			list.add("two");
			list.add("three");
			list.add("four");
			/*
			 * 将给定List集合转换为并发安全的List集合
			 */
			list =Collections.synchronizedList(list);
			System.out.println(list);
			/*
			 * 将给定set集合转换为并发安全的set集合
			 */
			Set<String> set = new HashSet<String>(list);
			set = Collections.synchronizedSet(set);
			System.out.println(set);
			/*
			 * API文档有说明这个事情，一个并发安全的集合不和迭代器遍历做互斥，
			 * 这意味着并发同时做上述两件事会出现并发安全问题
			 * 所以当使用迭代器遍历时要自行维护与集合的互斥关系参考聊天室服务端的处理。
			 */
			
		}
}
