package list;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列：并发安全的队列，采用双缓冲，在并发安全的前提下解决存取互斥问题，并发效率更好。
 * @author OldFarHigh
 *ArrayBlockingQueue:规定大小的Blockingqueue，必须传入一个int值来指明大小
 *重载方法：offer（String e ,timeout,unit）
 */
public class BlockingQueueDemo {
	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
		boolean  b = queue.offer("1");
		System.out.println(b);
		queue.offer("2");
		queue.offer("3");
		queue.offer("4");
		
		try {
			b=queue.offer("5",5,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(b);
		System.out.println(queue);
	}
}
