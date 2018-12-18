package list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列 java.util.Deque
 * 它继承自queue，是两端都可以进出队的队列
 * @author OldFarHigh
 *offerFirst://从队首添加元素
 *offerLast://从队尾添加元素（与offer相同）
 *pollFirst://从队首获取并删除元素（与poll相同）
 *pollLast://从队尾获取并删除元素
 *peekFirst://从队首获取元素（与peek相同）
 *peekLast://从队尾获取元素
 */
public class DequeDemo {
	public static void main(String[] args) {
		Deque<String> deque = new LinkedList<String>();
		
		deque.offer("one");//从队尾添加元素
		deque.offer("two");
		deque.offer("three");
		System.out.println(deque);//[one, two, three]
		
		deque.offerFirst("zero");//从队首添加元素
		System.out.println(deque);//[zero, one, two, three]
		
		deque.offerLast("four");//从队尾添加元素（与offer相同）
		System.out.println(deque);//[zero, one, two, three, four]
		
		String str = deque.pollFirst();//从队首获取并删除元素（与poll相同）
		System.out.println(str);//zero
		System.out.println(deque);//[one, two, three, four]
		
		str = deque.pollLast();//从队尾获取并删除元素
		System.out.println(str);//four
		System.out.println(deque);//[one, two, three]
	}
}
