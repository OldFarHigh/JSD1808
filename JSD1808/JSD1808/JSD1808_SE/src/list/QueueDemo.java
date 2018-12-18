package list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue接口
 * Queue是队列码，其继承自Collection。
 * 队列可以保存一组元素，但是存取元素必须遵循先进先出原则
 * 
 * 常见实现类：java.util.LinkedList
 * @author OldFarHigh
 *
 *offer方法： 入对操作，将元素增加至队尾（与add相似）
 *poll方法：出队操作，获取并从队列中删除队首元素
 * peek方法：引用队首元素，与poll的区别在于获取后并不会将其从队列中删除
 */
public class QueueDemo {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		/*
		 * offer方法： 入对操作，将元素增加至队尾（与add相似）
		 */
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		System.out.println(queue);
		
		/*
		 * poll方法：出队操作，获取并从队列中删除队首元素
		 */
		String str = queue.poll();
		System.out.println(str);
		System.out.println(queue);
		/*
		 * peek方法：引用队首元素，与poll的区别在于获取后并不会将其从队列中删除
		 */
		str = queue.peek();
		System.out.println(str);
		System.out.println(queue);
		/*
		 * 由于队列也是集合，所以可以使用迭代器来遍历并且这种遍历不会影响队列中的元素
		 */
		for (String String:queue ){
			System.out.println(String);
		}
		System.out.println(queue);
		
		/*
		 * 自行定义循环：利用poll方法遍历队列
		 */
		while(queue.size()>0) {
			String string = queue.poll();
			System.out.println(string);
		}
		System.out.println(queue);
	}
	
	
}
