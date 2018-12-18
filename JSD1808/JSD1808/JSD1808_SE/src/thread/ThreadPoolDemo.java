package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 线程池是一个管理线程的机制.它主要解决两个问题:
 * 1:重用线程
 * 2:控制线程数量
 * 频繁的创建和销毁线程会给系统带来额外的开销,所以线程应当得以重用.
 * 当线程数量过多时,会出现资源消耗增大,CPU出现过度切换导致并发性能降低.
 * 对此线程的数量也要得以控制在当前硬件环境所能承受的范围内.
 * @author OldFarHigh
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		/*
		 * 懒汉模式  饿汉模式
		 */
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 5; i++) {
			Runnable r = new Runnable() {
				public void run() {
					Thread t =Thread.currentThread();;
					System.out.println(t.getName()+":2、正在执行任务....");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(t.getName()+":3、执行任务完毕........");
				}
			};
			//将任务交给线程池
			threadPool.execute(r);
			System.out.println("1、将一个任务指派给了线程池!");
		}
		//threadPool.shutdownNow();
		//threadPool.shutdown();
		//System.out.println("4、线程池结束了.....");
	}
}
